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

class EditCR extends Component{
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
	},
			types: [],
			statuses: [],
			description:''
		};

		this.updateCR = this.updateCR.bind(this);
		this.onChange=this.onChange.bind(this);
	}

	componentDidMount(){
		axios.get('http://localhost:8080/changeRequest/show/' + this.props.match.params.id)
			.then(res => {this.setState({ change_request: res.data })});

		axios.get('http://localhost:8080/changeRequestType/all',{})
			.then( response => {this.setState({types: response.data});})

		axios.get('http://localhost:8080/changeRequestStatus/all',{})
			.then( response => {this.setState({statuses: response.data});})
	}

	updateCR(event){
		axios.post('http://localhost:8080/changeRequest/update/'+ this.props.match.params.id, {
			name: this.state.change_request.name,
			description: this.state.change_request.description,
			changeRequestType: {id:this.state.change_request.changeRequestType.id},
			changeRequestStatus: {id:this.state.change_request.changeRequestStatus.id},
			revisionComment: this.state.description
		})
		.then(this.handleSuccess.bind(this))
		.catch(console.log(this));
	}

	handleSuccess(response) {
		if(response.data){
			alert('Successfully updated change request!');
			window.location='/dashboard';
		}
	}

	onChange(e) {
		this.setState({[e.target.name]:e.target.value});
	}

	render(){
		let types = Array.from(this.state.types).map((type) =>
			<option value={type.id}>{type.name}</option>
		);

		let status = Array.from(this.state.statuses).map((status) =>
			<option value={status.id}>{status.name}</option>
		);

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
						  <Label>Change Request Description: </Label>
						</Col>
						<Col xs="12" md="9">
						  <FormText color="muted">{this.state.change_request.description}</FormText>
						</Col>
					  </FormGroup>

					  <FormGroup row>
						<Col md="3">
						  <Label>Change Request Type: </Label>
						</Col>
						<Col xs="12" md="9">
						  <Input type="select" name="type" id="select" value={this.state.change_request.changeRequestType.id} onChange={this.onChange}>
							{types}
						  </Input>
						</Col>
					  </FormGroup>

					  <FormGroup row>
						<Col md="3">
						  <Label>Change Request Status: </Label>
						</Col>
						<Col xs="12" md="9">
						  <Input type="select" name="type" id="select" value={this.state.change_request.changeRequestStatus.id} onChange={this.onChange}>
							{status}
						  </Input>
						</Col>
					  </FormGroup>



					  <FormGroup row>
						<Col md="3">
						  <Label>Change Request Revision Comment:</Label>
						</Col>
						<Col xs="12" md="9">
						  <Input type="textarea" name="description" value={this.state.description} onChange={this.onChange} id="textarea-input" rows="4" placeholder="Change Request Revision Comment..." />
						</Col>
					  </FormGroup>

				  </CardBody>
				  <CardFooter>
					<button type = "button" onClick={event => this.updateCR(event)} class="btn btn-md btn-block">Save</button>
				  </CardFooter>
				</Card>
				</Col>
			  </Row>
			</Container>
		  </div>
		);
	}
}

export default EditCR;
