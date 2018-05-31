import React, { Component } from 'react';
import { Button, Card, CardBody, Col, Container, Input, InputGroup, InputGroupAddon, InputGroupText, Row } from 'reactstrap';
import axios from 'axios';
import { Redirect } from 'react-router';

const API_ROUTE = 'http://localhost:8080/account/save';

class Register extends Component {

  constructor(props) {
    super(props);

    this.state = {
      username: '',
      email: '',
      pass: '',
      repeatPass: '',
      registered: false
    }

    this.updateState = this.updateState.bind(this);
  };

  updateState (event) {
    this.setState({
      [event.target.name]: event.target.value
    });
  }

  register (event) {

    let registerData = {
      username: this.state.username,
      password: this.state.pass,
      email: this.state.email
    }

    if (this.state.pass === this.state.repeatPass) {
      axios.post(API_ROUTE, registerData)
        .then(response => {
          this.setState({
            registered: true
          });
        })
        .catch(function (error) {
          console.log(error);
          alert("Unsuccessful registration, please check your input!");
        });
    }
    else {
      alert("Password and Repeat Password don't match!");
    }
  }

  render() {

    if (this.state.registered) {
      return <Redirect to="/login"/>
    }

    return (
      <div className="app flex-row align-items-center">
        <Container>
          <Row className="justify-content-center">
            <Col md="9">
              <Card className="mx-4">
                <CardBody className="p-4 register-card">
                  <h1>Register</h1>
                  <p className="text-muted">Create your account</p>
                  <InputGroup className="mb-3 input-register">
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
                  <InputGroup className="mb-3 input-register">
                    <InputGroupAddon addonType="prepend">
                      <InputGroupText>@</InputGroupText>
                    </InputGroupAddon>
                      <Input type="text"
                        placeholder='Email'
                        name='email'
                        value={this.state.email}
                        onChange={this.updateState}/>
                  </InputGroup>
                  <InputGroup className="mb-3 input-register">
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
                  <InputGroup className="mb-4 input-register">
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
                    className="px-4 btn-register"
                    onClick={(event) => this.register(event)}>
                      Register
                  </Button>
                </CardBody>
              </Card>
            </Col>
          </Row>
        </Container>
      </div>
    );
  }
}

export default Register;
