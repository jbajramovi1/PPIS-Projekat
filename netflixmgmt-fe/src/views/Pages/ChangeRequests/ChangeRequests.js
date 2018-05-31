import React, { Component } from 'react';
import { Button, Card, CardBody, CardColumns, CardHeader, CardGroup, Col, Container, Input, InputGroup, InputGroupAddon, InputGroupText, Row } from 'reactstrap';
import { Link } from 'react-router-dom';
import axios from 'axios';


const API_ROUTE = 'http://localhost:8080/changeRequest/all';



class ChangeRequests extends Component {

    constructor(props){
        super(props);
        this.state = {
        requests:[],
        changeRequests:[
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
        ]
        }
        ;
    }



    componentDidMount() {
        axios.get('http://localhost:8080/changeRequest/all',{})
            .then( response => {
                this.setState({changeRequests: response.data});


            })
    }

    render() {
        return (
           // <div className="app flex-row align-items-center">

                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Status</th>
                        <th scope="col">Type</th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.state.changeRequests.map((request) =>
                        <tr key={request.id}>												
                            <Link to={`/viewcr/${request.id}`}><td>{request.name}</td></Link>
                            <td>{request.changeRequestStatus.name}</td>
                            <td>{request.changeRequestType.name}</td>
                        </tr>
                    )}
                    </tbody>
                </table>
            //</div>
        );
    }
}

export default ChangeRequests;
