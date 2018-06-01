import React, { Component } from 'react';
import { Button, Card, CardBody, CardColumns, CardHeader, CardGroup, Col, Container, Input, InputGroup, InputGroupAddon, InputGroupText, Row } from 'reactstrap';

import axios from 'axios';


const API_ROUTE = 'http://localhost:8080/issue/all';



class Issues extends Component {

    constructor(props){
        super(props);
        this.state = {
        issues:[],
        availabilityIssues:[
            {
                "id": "",
                "name" : "",
                "description": "",
                "date":"",

                "account": {
                    "id": "",
                        "username": "",
                        "password": "",
                        "role": {
                            "id": "",
                            "title": ""
                              }
                        },
                "component":{
                  "id":"",
                  "name":"",
                  "description":"",
                  "client":""
                },
                "issueStatus": {
                        "id": "",
                        "name": ""
                         },
                "issueType": {
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
        axios.get('http://localhost:8080/issue/all',{})
            .then( response => {
                this.setState({availabilityIssues: response.data});


            })
    }

    render() {
        return (
           // <div className="app flex-row align-items-center">
           //<h2>Availability Issues</h2>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Report date</th>
                        <th scope="col">Status</th>
                        <th scope="col">Type</th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.state.availabilityIssues.map((issue) =>
                        <tr key={issue.id}>

                            <td>{issue.name}</td>
                            <td>{issue.date}</td>
                            <td>{issue.issueStatus.name}</td>
                            <td>{issue.issueType.name}</td>
                        </tr>)
                    }
                    </tbody>
                </table>
            //</div>
        );
    }
}

export default Issues;
