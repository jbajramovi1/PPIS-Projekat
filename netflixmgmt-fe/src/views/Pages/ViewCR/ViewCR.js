import React, { Component } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

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
		  change_request:
			{
			"id": "",
			"name" : "",
			"description": "",
			"revisionComment": "",
			"account": {
					"id": "",
							"username": "",
							"password": "",
							"role": {
									"id": "",
									"title": ""
										}
							},
			"changeRequestStatus": {
							"id": "",
							"name": ""
							 },
			"changeRequestType": {
							"id": "",
							"name": "",
							"description": ""
								}
	}
		};
	}

	componentDidMount(){
		axios.get(API_ROUTE + this.props.match.params.id)
		.then(res => {this.setState({ change_request: res.data });console.log(res.data);});
	}

	render(){
		return(
		  <div className="app flex-row ">
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
						  <FormText color="muted">#{this.state.change_request.id}</FormText>
						</Col>
					  </FormGroup>

					  <FormGroup row>
						<Col md="3">
						  <Label>Change Request Name:</Label>
						</Col>
						<Col xs="12" md="9">
						<FormText color="muted">{this.state.change_request.name}</FormText>
						</Col>
					  </FormGroup>

					  <FormGroup row>
						<Col md="3">
						  <Label>Change Request Submitted By:</Label>
						</Col>
						<Col xs="12" md="9">
						  <FormText color="muted">{this.state.change_request.account.username}</FormText>
						</Col>
					  </FormGroup>

					  <FormGroup row>
						<Col md="3">
						  <Label>Change Request Type: </Label>
						</Col>
						<Col xs="12" md="9">
						  <FormText color="muted">{this.state.change_request.changeRequestType.name}</FormText>
						</Col>
					  </FormGroup>

					  <FormGroup row>
						<Col md="3">
						  <Label>Change Request Status: </Label>
						</Col>
						<Col xs="12" md="9">
						  <FormText color="muted">{this.state.change_request.changeRequestStatus.name}</FormText>
						</Col>
					  </FormGroup>

					  <FormGroup row>
						<Col md="3">
						  <Label>Change Request Description: </Label>
						</Col>
						<Col xs="12" md="9">
						  <FormText color="muted">{this.state.change_request.description}</FormText>
						</Col>
					  </FormGroup>

					  <FormGroup row>
						<Col md="3">
						  <Label>Change Request Revision Comment:</Label>
						</Col>
						<Col xs="12" md="9">
						  <FormText color="muted">{this.state.change_request.revisionComment}</FormText>
						</Col>
					  </FormGroup>

				  </CardBody>
				  <CardFooter>
					<Link to={`/changerequests/`}><button type = "button" class="btn btn-cr btn-md btn-block">Back</button></Link>					
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
