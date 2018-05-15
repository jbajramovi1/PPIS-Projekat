import React, { Component } from 'react';
import { Button, Card, CardBody, CardColumns, CardHeader, CardGroup, Col, Container, Input, InputGroup, InputGroupAddon, InputGroupText, Row } from 'reactstrap';
import { Pie } from 'react-chartjs-2';

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

class ChangeStatistics extends Component {
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
                <Pie data={pie} />
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

export default ChangeStatistics;
