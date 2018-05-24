import React, { Component } from 'react';
import { Button, Card, CardBody, CardColumns, CardHeader, CardGroup, Col, Container, Input, InputGroup, InputGroupAddon, InputGroupText, Row } from 'reactstrap';
import { Pie } from 'react-chartjs-2';
import axios from 'axios';


const API_ROUTE = 'http://localhost:8080/issue/get-stats';


const pie = {
    labels: [
      'Red',
      'Green',
      'Yellow',
    ],
    datasets: [
      {
        data: [300, 50, 100],
        backgroundColor: [
          '#FF6384',
          '#36A2EB',
          '#FFCE56',
        ],
        hoverBackgroundColor: [
          '#FF6384',
          '#36A2EB',
          '#FFCE56',
        ],
      }],
  };

class IssueStatistics extends Component {

  constructor(props){
    super(props);
    this.state = {
      pie: {
          labels: [

          ],
          datasets: [
              {
                  data: [],
                  backgroundColor: [
                      '#FF6384',
                      '#36A2EB',
                      '#FFCE56',
                  ],
                  hoverBackgroundColor: [
                      '#FF6384',
                      '#36A2EB',
                      '#FFCE56',
                  ],
              }],
      }
    };


  }

  fetchStats() {
    axios.get(API_ROUTE, {}
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
    this.fetchStats();
  }

  render() {
    return (

        <div className="app flex-row align-items-center">
        <Container>
        <Row>
        <h1>Change Statistics</h1>
        </Row>
        <div className="animated fadeIn">
        <CardColumns className="cols-2">
          <Card>
            <CardHeader>
              Pie Chart
              <div className="card-header-actions">

              </div>
            </CardHeader>
            <CardBody>
              <div className="chart-wrapper">
                <Pie data={this.state.pie} />
              </div>
            </CardBody>
          </Card>

        </CardColumns>
      </div>
      </Container>
      </div>
    );
  }
}

export default IssueStatistics;
