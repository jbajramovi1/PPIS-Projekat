import React, { Component } from 'react';
import { Badge, DropdownItem, DropdownMenu, DropdownToggle, Nav, NavItem, NavLink } from 'reactstrap';
import PropTypes from 'prop-types';

import { AppAsideToggler, AppHeaderDropdown, AppNavbarBrand, AppSidebarToggler } from '@coreui/react';
import logo from '../../assets/img/brand/logo.svg'
import sygnet from '../../assets/img/brand/sygnet.svg'
import {Redirect} from "react-router";
import axios from "axios";

const propTypes = {
  children: PropTypes.node,
};

const defaultProps = {};

class DefaultHeader extends Component {

    constructor(props) {
        super(props);
        this.state = {
            token: localStorage.getItem('token') || ""
        }
    }

    logout(event) {
        localStorage.removeItem('token');
        this.setState({
            token: ""
        });
        delete axios.defaults.headers['Authorization'];
    }

    render() {

        if (this.state.token === "") {
            return <Redirect to='/login' />
        }

        // eslint-disable-next-line
        const { children, ...attributes } = this.props;

        return (
          <React.Fragment>
            <AppSidebarToggler className="d-lg-none" display="md" mobile />
            <AppSidebarToggler className="d-md-down-none" display="lg" />

            <Nav className="d-md-down-none" navbar>
              <NavItem className="px-3">
                <NavLink href="/#/dashboard">Netflix Management</NavLink>
              </NavItem>
            </Nav>
            <Nav className="ml-auto" navbar>
              <AppHeaderDropdown direction="down">
                <DropdownToggle nav>
                  <img src={'assets/img/avatars/6.jpg'} className="img-avatar" alt="admin@bootstrapmaster.com" />
                </DropdownToggle>
                <DropdownMenu right style={{ right: 'auto' }}>
                  <DropdownItem><i className="fa fa-user"></i> Profile</DropdownItem>
                  <DropdownItem><i className="fa fa-wrench"></i> Settings</DropdownItem>
                  <DropdownItem divider />
                  <DropdownItem
                    onClick={event => this.logout(event)}><i className="fa fa-lock"></i> Logout</DropdownItem>
                </DropdownMenu>
              </AppHeaderDropdown>
            </Nav>
            {/*<AppAsideToggler className="d-md-down-none" />*/}
            {/*<AppAsideToggler className="d-lg-none" mobile />*/}
          </React.Fragment>
        );
    }
}

DefaultHeader.propTypes = propTypes;
DefaultHeader.defaultProps = defaultProps;

export default DefaultHeader;
