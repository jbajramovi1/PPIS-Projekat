import React, { Component } from 'react';
import { Button, Card, CardBody, CardColumns, CardHeader, CardGroup, Col, Container, Input, InputGroup, InputGroupAddon, InputGroupText, Row } from 'reactstrap';

import axios from 'axios';


const API_ROUTE = 'http://localhost:8080/changeRequest/all';



class ChangeRequests extends Component {

    constructor(props){
        super(props);
        this.state = {

        }
        ;


    }

    fetchStats() {
        axios.get(API_ROUTE, {
            headers: {'Authorization': 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbmlzYSIsImV4cCI6MTUyNzQxNzMxOH0.n4IlskGFqyl-cNpRUhp3nzTGeXMd6rgJPJ_HZNSEMlrCEciKLcwJA9InhrCza5xmnfSzAxLa7RPEzzd7ammAew'}}
        ).then((response) => {
            let pieData = response.data;
            let newPie = this.state.pie;
            let keys = Object.keys(pieData);
            let i = 1;
            let len = keys.length;
            let prope;
            let value;
            while (i<len){
                prope = keys[i];
                value = pieData[prope];
                newPie.labels.push(prope);
                newPie.datasets[0].data.push(value);
                i = i+ 1;
            }

            this.setState({
                pie:newPie
            })
            console.log(this.state.pie.labels)
        }).catch(error => {

        });
    }

    componentDidMount() {

    }

    render() {
        return (

            <div className="app flex-row align-items-center">

            </div>
        );
    }
}

export default ChangeRequests;
