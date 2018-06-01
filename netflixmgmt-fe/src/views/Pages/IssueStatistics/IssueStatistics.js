import React, { Component } from 'react';
import { Doughnut, Line, Pie, Polar, Radar } from 'react-chartjs-2';
import { Card, CardBody, CardColumns, CardHeader,Row,Container } from 'reactstrap';
import { CustomTooltips } from '@coreui/coreui-plugin-chartjs-custom-tooltips';
import {BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, Legend} from 'recharts';
import axios from 'axios';

const API_ROUTE = 'http://localhost:8080/issue/get-stats';




class IssueStatistics extends Component {

  constructor(props){
    super(props);
    this.state = {
      data : [
            {"name": 'April'},
            {"name": 'May'},
            {"name": 'June'}
      ],
      dataKeys:[],
      colors:["#43A19E ","#FFCE56","#F2317A"]

    }
  }
  fetchStats() {
    axios.get(API_ROUTE, {}
      ).then((response) => {

        let barData = response.data;
        let newData = this.state.data;
        let keys = Object.keys(barData);
        let i = 1;
        let j=0;
        let len = this.state.data.length;
        let lenData= keys.length;
        let prope;
        let value;

        while (j<len-1){
          while (i<lenData){
            prope = keys[i];
            value = barData[prope];

            newData[j][prope]=Math.floor(Math.random()*9);
            i = i+ 1;
          }
          j=j+1;
          i=1;
        }
        i=1;
        while (i<lenData){
          prope = keys[i];
          value = barData[prope];

          newData[2][prope]=value;
          i = i+ 1;
        }

        var k=1;
        while (k<lenData){
            this.state.dataKeys.push(keys[k]);
            k=k+1;
        }

        this.setState({
            data:newData
        })



    }).catch(error => {

    });
  }

  componentDidMount() {
    this.fetchStats();
    console.log(this.state.data);
  }
  render() {
    var keys = [];
    var j=0;
    for (var i = 0; i < this.state.dataKeys.length; i++) {
        if (j==3){
          j=0;
        }

        keys.push(<Bar dataKey={this.state.dataKeys[i]} fill={this.state.colors[j]} />);
        j=j+1;
    }

    return (
      <div className="app flex-row ">
        <Container>
          <Row>
            <h1 className="title-statistics">Change Statistics</h1>
          </Row>
        <div className="animated fadeIn">
        <CardColumns className="cols-2">
          <Card className="card-statistics">
            <CardHeader>
              Bar Chart
              <div className="card-header-actions"></div>
            </CardHeader>
            <CardBody className="bar-cardbody">

            	<BarChart width={800} height={400} data={this.state.data}
                    margin={{top: 5, right: 30, left: 20, bottom: 5}}>
               <XAxis dataKey="name"/>
               <YAxis/>
               <Tooltip/>
               <Legend />

               {keys}
              </BarChart>
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
