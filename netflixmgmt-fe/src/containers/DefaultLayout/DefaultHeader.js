import React, { Component } from 'react';
import { Badge, DropdownItem, DropdownMenu, DropdownToggle, Nav, NavItem, NavLink } from 'reactstrap';
import PropTypes from 'prop-types';

import { AppAsideToggler, AppHeaderDropdown, AppNavbarBrand, AppSidebarToggler } from '@coreui/react';
import logo from '../../assets/img/brand/logo.svg'
import sygnet from '../../assets/img/brand/sygnet.svg'
import {Redirect} from "react-router";

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
        })
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
            <AppNavbarBrand
              full={{ src: logo, width: 89, height: 25, alt: 'CoreUI Logo' }}
              minimized={{ src: sygnet, width: 30, height: 30, alt: 'CoreUI Logo' }}
            />
            <AppSidebarToggler className="d-md-down-none" display="lg" />

            <Nav className="d-md-down-none" navbar>
              <NavItem className="px-3">
                <NavLink href="/">Dashboard</NavLink>
              </NavItem>
              <NavItem className="px-3">
                <NavLink href="#">Change requests</NavLink>
              </NavItem>
            </Nav>
            <Nav className="ml-auto" navbar>
              <NavItem className="d-md-down-none">
                <NavLink href="#"><i className="icon-bell"></i><Badge pill color="danger">5</Badge></NavLink>
              </NavItem>
              <AppHeaderDropdown direction="down">
                <DropdownToggle nav>
                  <img src={'assets/img/avatars/6.jpg'} className="img-avatar" alt="admin@bootstrapmaster.com" />
                </DropdownToggle>
                <DropdownMenu right style={{ right: 'auto' }}>
                  <DropdownItem header tag="div" className="text-center"><strong>Account</strong></DropdownItem>
                  <DropdownItem><i className="fa fa-tasks"></i> Tasks<Badge color="danger">42</Badge></DropdownItem>
                  <DropdownItem header tag="div" className="text-center"><strong>Settings</strong></DropdownItem>
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
