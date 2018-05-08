package com.example.netflixmgmt.controller;

import com.example.netflixmgmt.models.ChangeRequestType;
import com.example.netflixmgmt.services.ChangeRequestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/changeRequestType")
public class ChangeRequestTypeController {
    @Autowired
    ChangeRequestTypeService changeRequestTypeService;

    @RequestMapping(value = "/all",  method = RequestMethod.GET)
    public ResponseEntity<Object> findAll(){
        List<ChangeRequestType> allRequests = changeRequestTypeService.getAll();

        if (allRequests.size() == 0)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No change request type has been found!");
        else
            return ResponseEntity.ok(allRequests);
    }
}
