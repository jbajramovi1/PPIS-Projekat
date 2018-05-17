import React, { Component } from 'react';
import { Button, Card, CardBody, CardColumns, CardHeader, CardGroup, Col, Container, Input, InputGroup, InputGroupAddon, InputGroupText, Row } from 'reactstrap';

import axios from 'axios';


const API_ROUTE = 'http://localhost:8080/changeRequest/all';



class ChangeRequests extends Component {

    // constructor(props){
    //     super(props);
    //     this.state = {
    //     requests:[]
    //     }
    //     ;
    //
    //
    // }
    //
    //
    // componentDidMount() {
    //     axios.get('http://localhost:8080/changeRequest/all',{})
    //         .then( response => {
    //             this.setState({requests: response.data});
    //         })
    // }

    render() {
        // let changeRequests = Array.from(this.state.requests).map((request) =>
        //     <option value={request.name}>{request.description}</option>
        // );

        return (
            <div className="app flex-row align-items-center">
                <Container>
                    <Row>
                        <h1>Change Requests</h1>
                    </Row>
                </Container>

            </div>
        );
    }
}

export default ChangeRequests;
