import React, { Component } from 'react';
import axios from 'axios';

import {
Container,
Button,
Badge,
ButtonDropdown,
Card,
CardBody,
CardFooter,
CardHeader,
Col,
Collapse,
DropdownItem,
DropdownMenu,
DropdownToggle,
Form,
FormGroup,
FormText,
FormFeedback,
Input,
InputGroup,
InputGroupAddon,
InputGroupText,
Label,
Row, } from 'reactstrap';

const API_ROUTE = 'http://localhost:8080/changeRequest/show/';

	class ViewCR extends Component{
		constructor(props) {
		super(props);

		this.state = {
		  change_request: {}
		};
	}
  
	componentDidMount(){
		axios.get(API_ROUTE + this.props.match.params.id)
				  .then(res => {this.setState({ change_request: res.data })});
	}
	
  render(){
    return(
      <div className="app flex-row align-items-center">
        <Container>
          <Row className="justify-content-center" >
            <Col md="8">
            <Card>
              <CardHeader>
                <strong>View Change Request</strong>
              </CardHeader>
              <CardBody>
				  <FormGroup row>
                    <Col md="3">
                      <Label>Change Request ID:</Label>
                    </Col>
                    <Col xs="12" md="9">
                      <FormText color="muted">#24031996</FormText>
					  //<FormText color="muted">{this.state.change_request.id}</FormText>
                    </Col>
                  </FormGroup>
			  
                  <FormGroup row>
                    <Col md="3">
                      <Label>Change Request Name:</Label>
                    </Col>
                    <Col xs="12" md="9">
					<FormText color="muted">Placeholder Name</FormText>
					//<FormText color="muted">{this.state.change_request.name}</FormText>
                    </Col>
                  </FormGroup>
				  
				  <FormGroup row>
                    <Col md="3">
                      <Label>Change Request Submitted By:</Label>
                    </Col>
                    <Col xs="12" md="9">
                      <FormText color="muted">Placeholder username</FormText>
                    </Col>
                  </FormGroup>

                  <FormGroup row>
                    <Col md="3">
                      <Label>Change Request Type: </Label>
                    </Col>
                    <Col xs="12" md="9">
                      <FormText color="muted">Placeholder type</FormText>
                    </Col>
                  </FormGroup>
				  
				  <FormGroup row>
                    <Col md="3">
                      <Label>Change Request Status: </Label>
                    </Col>
                    <Col xs="12" md="9">
                      <FormText color="muted">Placeholder status</FormText>
                    </Col>
                  </FormGroup>

                  <FormGroup row>
                    <Col md="3">
                      <Label>Change Request Description: </Label>
                    </Col>
                    <Col xs="12" md="9">
                      <FormText color="muted">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</FormText>
                    </Col>
                  </FormGroup>
				  
				  <FormGroup row>
                    <Col md="3">
                      <Label>Change Request Revision Comment:</Label>
                    </Col>
                    <Col xs="12" md="9">
                      <FormText color="muted">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</FormText>
                    </Col>
                  </FormGroup>

              </CardBody>
              <CardFooter>
                <button type = "button" class="btn btn-outline-primary btn-lg btn-block">Cancel</button>
              </CardFooter>
            </Card>
            </Col>
          </Row>
        </Container>
      </div>
    );
  }
}

export default ViewCR;