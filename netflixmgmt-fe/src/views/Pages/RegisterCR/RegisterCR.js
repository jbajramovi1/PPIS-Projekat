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

const API_ROUTE = 'http://localhost:8080/changeRequest/save';

class RegisterCR extends Component{
  constructor(props) {
    super(props);

    this.toggle = this.toggle.bind(this);
    this.state = {
      collapse: true,
      name:'',
      type:1,
      description:'',
      types: []
    };


    this.registerCR = this.registerCR.bind(this);
    this.onChange=this.onChange.bind(this);


  }

  componentDidMount(){
    axios.get('http://localhost:8080/changeRequestType/all',{})
    .then( response => {
        this.setState({types: response.data});

    })


  }

  registerCR(event){
    axios.post(API_ROUTE, {
                  name: this.state.name,
                  description: this.state.description,
                  changeRequestType: {id:this.state.type},
                  changeRequestStatus: {id:3}
              })
              .then(this.handleSuccess.bind(this))
              .catch(this.handleError.bind(this));

  }

  handleSuccess(response) {
        if(response.data)
        {

            alert('Successfully registered change request!');
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
    return(
      <div className="app flex-row ">
        <Container>
          <Row className="justify-content-center" >
            <Col md="11">
            <Form  action="" encType="multipart/form-data" className="form-horizontal">

            <Card>
              <CardHeader>
                <strong>Register Change Request</strong>
              </CardHeader>
              <CardBody>

                  <FormGroup row>
                    <Col md="3">
                      <Label htmlFor="text-input">Change Request name</Label>
                    </Col>
                    <Col xs="12" md="9">
                      <Input type="text" id="text-input" name="name" placeholder="Name" value={this.state.name} onChange={this.onChange} />
                      <FormText color="muted">Please enter the name of your change request</FormText>
                    </Col>
                  </FormGroup>

                  <FormGroup row>
                    <Col md="3">
                      <Label htmlFor="select">Change Request Type</Label>
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
                      <Input type="textarea" name="description" value={this.state.description} onChange={this.onChange} id="textarea-input" rows="9"
                             placeholder="Content..." />
                    </Col>
                  </FormGroup>


              </CardBody>
              <CardFooter>
                <Button size="md" onClick={event => this.registerCR(event)} color="primary"><i className="fa fa-dot-circle-o"></i> Submit</Button>
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

export default RegisterCR;
