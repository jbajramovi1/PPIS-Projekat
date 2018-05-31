import React, { Component } from 'react';
import axios from 'axios';
import {
Container,
Button,
Badge,
ButtonDropdown,
Card,
CardBody,
CardFooter,
CardHeader,
Col,
Collapse,
DropdownItem,
DropdownMenu,
DropdownToggle,
Form,
FormGroup,
FormText,
FormFeedback,
Input,
InputGroup,
InputGroupAddon,
InputGroupText,
Label,
Row, } from 'reactstrap';

const API_ROUTE = 'http://localhost:8080/issue/save';

class RegisterAI extends Component{
  constructor(props) {
    super(props);

    this.toggle = this.toggle.bind(this);
    this.state = {
      collapse: true,
      name:'',
      type:1,
      description:'',
      types:[],
      component:1,
      components:[]
    };

    this.onChange=this.onChange.bind(this);
    this.handleSuccess=this.handleSuccess.bind(this);
    this.handleError=this.handleError.bind(this);
  }

  componentDidMount(){
    axios.get('http://localhost:8080/issueType/all',{})
    .then( response => {
        this.setState({types: response.data});

    });

    axios.get('http://localhost:8080/component/all',{})
    .then( response => {
        this.setState({components: response.data});

    });


  }

  registerAI(event){
    axios.post(API_ROUTE, {
                  name: this.state.name,
                  description: this.state.description,
                  issueType: {id:this.state.type},
                  component: {id:this.state.component}
              })
              .then(this.handleSuccess.bind(this))
              .catch(this.handleError.bind(this));

  }

  handleSuccess(response) {
        if(response.data)
        {
            alert('Successfully registered issue!');
            window.location='/dashboard';
        }
    }

    handleError(error) {
        alert(error.response.data);
    }

  toggle() {
    this.setState({ collapse: !this.state.collapse });
  }

  onChange(e) {
        this.setState({[e.target.name]:e.target.value});
    }


  render(){
    let types = Array.from(this.state.types).map((type) =>
                <option value={type.id}>{type.name}</option>
            );

    let components = Array.from(this.state.components).map((type) =>
                <option value={type.id}>{type.name}</option>
                    );
    return(
      <div className="app flex-row ">
        <Container>
          <Row className="justify-content-center" >
            <Col md="11">
            <Form  encType="multipart/form-data" className="form-horizontal">

            <Card>
              <CardHeader>
                <strong>Register Availibility Issue</strong>
              </CardHeader>
              <CardBody>

                  <FormGroup row>
                    <Col md="3">
                      <Label htmlFor="text-input">Availibility issue name</Label>
                    </Col>
                    <Col xs="12" md="9">
                      <Input type="text" id="text-input" name="name" placeholder="Name" value={this.state.name} onChange={this.onChange} />
                      <FormText color="muted">Please enter the name of your issue</FormText>
                    </Col>
                  </FormGroup>

                  <FormGroup row>
                    <Col md="3">
                      <Label htmlFor="select">Component</Label>
                    </Col>
                    <Col xs="12" md="9">
                    <Input type="select" name="type" id="select" value={this.state.component} onChange={this.onChange}>

                      {components}

                    </Input>
                    </Col>
                  </FormGroup>

                  <FormGroup row>
                    <Col md="3">
                      <Label htmlFor="select">Availibility issue Type</Label>
                    </Col>
                    <Col xs="12" md="9">
                    <Input type="select" name="type" id="select" value={this.state.type} onChange={this.onChange}>

                      {types}

                    </Input>
                    </Col>
                  </FormGroup>

                  <FormGroup row>
                    <Col md="3">
                      <Label htmlFor="textarea-input">Description</Label>
                    </Col>
                    <Col xs="12" md="9">
                      <Input type="textarea" name="description" id="textarea-input" value={this.state.description} onChange={this.onChange} rows="9"
                             placeholder="Content..." />
                    </Col>
                  </FormGroup>


              </CardBody>
              <CardFooter>
                <Button onClick={event => this.registerAI(event)} size="md" color="primary"><i className="fa fa-dot-circle-o"></i> Submit</Button>
                <Button type="reset" color="danger"  size="md"><i className="fa fa-ban"></i> Reset</Button>
                <Row className="float-right">
                  <Button type="reset" color="secondary"  size="md">Cancel</Button>
                </Row>
              </CardFooter>
            </Card>
            </Form>
            </Col>
          </Row>
        </Container>
      </div>
    );
  }
}

export default RegisterAI;
