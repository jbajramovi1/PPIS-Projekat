import React, { Component } from 'react';
import { Button, Card, CardBody, CardColumns, CardHeader, CardGroup, Col, Container, Input, InputGroup, InputGroupAddon, InputGroupText, Row } from 'reactstrap';
import { Link } from 'react-router-dom';
import axios from 'axios';


const API_ROUTE = 'http://localhost:8080/contract/all';



class Contracts extends Component {

    constructor(props){
        super(props);
        this.state = {
        issues:[],
        contracts:[
            {
                "id": "",
                "name" : "",
                "client":"",
                "description": "",

            }
        ]
        }
        ;
    }

    componentDidMount() {
        axios.get(API_ROUTE,{})
            .then( response => {
                this.setState({contracts: response.data});


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
                        <th scope="col">Client</th>

                    </tr>
                    </thead>
                    <tbody>
                    {this.state.contracts.map((contract) =>
                        <tr key={contract.id}>
							<Link to={`/viewcontract/${contract.id}`}><td>{contract.name}</td></Link>                            
                            <td>{contract.client}</td>
                      </tr>)
                    }
                    </tbody>
                </table>
            //</div>
        );
    }
}

export default Contracts;
