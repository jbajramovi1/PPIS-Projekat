import React, { Component } from 'react';
import { Button, Card, CardBody, CardFooter, Col, Container, Input, InputGroup, InputGroupAddon, InputGroupText, Row } from 'reactstrap';
import axios from 'axios';
import { Redirect } from 'react-router';

const API_ROUTE = 'http://localhost:8080/auth/register';

class Register extends Component {

  constructor(props) {
    super(props);

    this.state = {
      username: '',
      email: '',
      pass: '',
      repeatPass: '',
      authenticated: false
    }

    this.updateState = this.updateState.bind(this);
  };

  updateState (event) {
    this.setState({
      [event.target.name]: event.target.value
    });
  }

  register (event) {
    if (this.state.pass === this.state.repeatPass) {
      axios.post(API_ROUTE, JSON.stringify(this.state))
        .then(response => {
          localStorage.setItem('token', response);
          this.state.authenticated = true;
        })
        .catch(function (error) {
          console.log(error);
        });
    }
  }

  render() {
    return (
      <div className="app flex-row align-items-center">
        <Container>
          <Row className="justify-content-center">
            <Col md="6">
              <Card className="mx-4">
                <CardBody className="p-4">
                  <h1>Register</h1>
                  <p className="text-muted">Create your account</p>
                  <InputGroup className="mb-3">
                    <InputGroupAddon addonType="prepend">
                      <InputGroupText>
                        <i className="icon-user"></i>
                      </InputGroupText>
                    </InputGroupAddon>
                      <Input type="text" 
                        placeholder='Username'
                        name='username'
                        value={this.state.username} 
                        onChange={this.updateState}/>
                  </InputGroup>
                  <InputGroup className="mb-3">
                    <InputGroupAddon addonType="prepend">
                      <InputGroupText>@</InputGroupText>
                    </InputGroupAddon>
                      <Input type="text" 
                        placeholder='Email'
                        name='email'
                        value={this.state.email} 
                        onChange={this.updateState}/>
                  </InputGroup>
                  <InputGroup className="mb-3">
                    <InputGroupAddon addonType="prepend">
                      <InputGroupText>
                        <i className="icon-lock"></i>
                      </InputGroupText>
                    </InputGroupAddon>
                      <Input type="password" 
                        placeholder='Password'
                        name='pass'
                        value={this.state.pass} 
                        onChange={this.updateState}/>
                  </InputGroup>
                  <InputGroup className="mb-4">
                    <InputGroupAddon addonType="prepend">
                      <InputGroupText>
                        <i className="icon-lock"></i>
                      </InputGroupText>
                    </InputGroupAddon>
                      <Input type="password" 
                        placeholder='Repeat password'
                        name='repeatPass'
                        value={this.state.repeatPass} 
                        onChange={this.updateState}/>
                  </InputGroup>
                  <Button color="success" 
                    className="px-4" 
                    onClick={(event) => this.register(event)}>
                      Login
                  </Button>
                </CardBody>
                <CardFooter className="p-4">
                  <Row>
                    <Col xs="12" sm="6">
                      <Button className="btn-facebook" block><span>facebook</span></Button>
                    </Col>
                    <Col xs="12" sm="6">
                      <Button className="btn-twitter" block><span>twitter</span></Button>
                    </Col>
                  </Row>
                </CardFooter>
              </Card>
            </Col>
          </Row>
        </Container>
      </div>
    );
  }
}

export default Register;
