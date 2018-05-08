import React, { Component } from 'react';
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


class RegisterCR extends Component{
  constructor(props) {
    super(props);

    this.toggle = this.toggle.bind(this);
    this.state = {
      collapse: true,
      name:'',
      type:0,
      description:''
    };
  }

  toggle() {
    this.setState({ collapse: !this.state.collapse });
  }


  render(){
    return(
      <div className="app flex-row align-items-center">
        <Container>
          <Row className="justify-content-center">
            <Col md="8">
            <Form  action="" method="post" encType="multipart/form-data" className="form-horizontal">

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
                      <Input type="text" id="text-input" name="name" placeholder="Name" />
                      <FormText color="muted">Please enter the name of your change request</FormText>
                    </Col>
                  </FormGroup>

                  <FormGroup row>
                    <Col md="3">
                      <Label htmlFor="select">Change Request Type</Label>
                    </Col>
                    <Col xs="12" md="9">
                      <Input type="select" name="type" id="select">
                        <option value="0">Please select</option>
                        <option value="1">Option #1</option>
                        <option value="2">Option #2</option>
                        <option value="3">Option #3</option>
                      </Input>
                    </Col>
                  </FormGroup>

                  <FormGroup row>
                    <Col md="3">
                      <Label htmlFor="textarea-input">Description</Label>
                    </Col>
                    <Col xs="12" md="9">
                      <Input type="textarea" name="description" id="textarea-input" rows="9"
                             placeholder="Content..." />
                    </Col>
                  </FormGroup>


              </CardBody>
              <CardFooter>
                <Button type="submit" size="sm" color="primary"><i className="fa fa-dot-circle-o"></i> Submit</Button>
                <Button color="danger" size="sm"><i className="fa fa-ban"></i> Cancel</Button>
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
