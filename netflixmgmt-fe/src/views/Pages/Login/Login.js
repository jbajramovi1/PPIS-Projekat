import React, { Component } from 'react';
import { Button, Card, CardBody, CardGroup, Col, Container, Input, InputGroup, InputGroupAddon, InputGroupText, Row } from 'reactstrap';
import axios from 'axios';
import { Redirect } from 'react-router';

const API_ROUTE = 'http://localhost:8080/login';

class Login extends Component {

  constructor(props) {
    super(props);

    this.state = {
      email: '',
      pass: '',
      authenticated: false,
      register: false
    }

    this.updateState = this.updateState.bind(this);
  };

  updateState (event) {
    this.setState({
      [event.target.name]: event.target.value
    });
  }

  login (event) {
    const data = {
      username: this.state.email,
      password: this.state.pass
    };

    axios.post(API_ROUTE, data)
      .then(response => {
        localStorage.setItem('token', response.headers['authorization']);
        axios.defaults.headers['Authorization'] = response.headers['authorization'];
        this.setState({authenticated: true})
      })
      .catch(function (error) {
        console.log(error);
      });
  }

  register (event) {
    this.setState({
        register: true
    })
  }

  render() {
    if (this.state.authenticated) {
      return <Redirect to='/' />
    } else if (this.state.register) {
      return <Redirect to='/register' />
    }

    return (
      <div className="app flex-row align-items-center">
        <Container>
          <Row className="justify-content-center">
            <Col md="11">
              <CardGroup className="login-card">
                <Card className="p-4">
                  <CardBody className="login-cardbody">
                    <h1>Login</h1>
                    <p className="text-muted">Sign In to your account</p>
                    <InputGroup className="mb-3">
                      <InputGroupAddon addonType="prepend">
                        <InputGroupText>
                          <i className="icon-user"></i>
                        </InputGroupText>
                      </InputGroupAddon>
                      <Input type="text"
                      placeholder='Username'
                      name='email'
                      value={this.state.email}
                      onChange={this.updateState}/>
                    </InputGroup>
                    <InputGroup className="mb-4">
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
                    <Row>
                      <Col xs="6">
                        <Button color="primary"
                          className="px-4 login-btn"
                          onClick={(event) => this.login(event)}>
                            Login
                        </Button>
                      </Col>
                      <Col xs="6" className="text-right">
                        <Button color="link" className="px-0">Forgot password?</Button>
                      </Col>
                    </Row>
                  </CardBody>
                </Card>
                <Card className="text-white bg-primary card-register py-5 d-md-down-none" style={{ width: 44 + '%' }}>
                  <CardBody className="text-center" className="login-cardbody-register">
                    <div>
                      <h1 className="signup">Sign up</h1>
                      <Button color="primary"
                      className="mt-5 login-btn" size="lg"
                      onClick={event => this.register(event)}
                      active>
                        Register Now!
                      </Button>
                    </div>
                  </CardBody>
                </Card>
              </CardGroup>
            </Col>
          </Row>
        </Container>
      </div>
    );
  }
}

export default Login;
