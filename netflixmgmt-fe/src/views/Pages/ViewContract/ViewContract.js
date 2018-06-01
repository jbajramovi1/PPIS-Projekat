import React, { Component } from 'react';
import { FormGroup, FormText, Label, CardFooter, ColButton, Card, CardBody, CardColumns, CardHeader, CardGroup, Col, Container, Input, InputGroup, InputGroupAddon, InputGroupText, Row } from 'reactstrap';
import { Link } from 'react-router-dom';

import axios from 'axios';


const API_ROUTE = 'http://localhost:8080/contract/get/';


class ViewContract extends Component {

    constructor(props){
        super(props);
        this.state = {
            contract:{
                "id": "",
                "name" : "",
                "client":"",
                "component": { "id":"","name":""},
                "description": ""

            }
        }
        ;
    }


    componentDidMount() {
        axios.get(API_ROUTE + this.props.match.params.id)
            .then(response => {
                this.setState({ contract: response.data });
            });
    }

    render() {
        return (

        <div className="app flex-row ">
            <Container>
                <Row className="justify-content-center" >
                    <Col md="11">
                        <Card>
                            <CardHeader>
                                <strong>View Contract</strong>
                            </CardHeader>
                            <CardBody>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label>Contract ID:</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <FormText className="form-text" color="muted">{this.state.contract.id}</FormText>
                                    </Col>
                                </FormGroup>

                                <FormGroup row>
                                    <Col md="3">
                                        <Label>Contract Name:</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <FormText className="form-text" color="muted">{this.state.contract.name}</FormText>
                                    </Col>
                                </FormGroup>

                                <FormGroup row>
                                    <Col md="3">
                                        <Label>Client:</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <FormText className="form-text" color="muted">{this.state.contract.client}</FormText>
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label>Component: </Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <FormText className="form-text" color="muted">{this.state.contract.component.name}</FormText>
                                    </Col>
                                </FormGroup>

                                <FormGroup row>
                                    <Col md="3">
                                        <Label>Description: </Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <FormText className="form-text" color="muted">{this.state.contract.description}</FormText>
                                    </Col>
                                </FormGroup>
                            </CardBody>
                            <CardFooter>
                              <Link to={`/contracts/`}><button type = "button" class="btn btn-cr btn-md btn-block">Back</button></Link>
                            </CardFooter>
                        </Card>
                    </Col>
                </Row>
            </Container>
        </div>

        // {/*<div className="app flex-row align-items-center">*/}
        // {/*<h3>*/}
        // {/*{this.state.contract.name}*/}
        // {/*<small class="text-muted">Contract id: {this.state.contract.id}</small>*/}
        // {/*</h3>*/}
        // {/*<ul class="list-unstyled">*/}
        // {/*<li>Descrtiption: {this.state.contract.description}</li>*/}
        // {/*<li>Client: {this.state.contract.client}</li>*/}
        // {/*</ul>*/}
        //
        // {/*</div>*/}
        );
    }
}

export default ViewContract;
