package com.example.netflixmgmt.controller;

import com.example.netflixmgmt.models.IssueType;
import com.example.netflixmgmt.services.IssueTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/issueType")
public class IssueTypeController {
    @Autowired
    IssueTypeService issueTypeService;

    @RequestMapping(value = "/all",  method = RequestMethod.GET)
    public ResponseEntity<Object> findAll(){
        List<IssueType> allIssueTypes = issueTypeService.getAll();

        if (allIssueTypes.size() == 0)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No issue type has been found!");
        else
            return ResponseEntity.ok(allIssueTypes);
    }
}
