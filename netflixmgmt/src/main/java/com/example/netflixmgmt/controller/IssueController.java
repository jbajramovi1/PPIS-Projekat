package com.example.netflixmgmt.controller;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.netflixmgmt.models.ChangeRequestStatus;
import com.example.netflixmgmt.models.ChangeRequestType;
import com.example.netflixmgmt.models.Issue;
import com.example.netflixmgmt.models.IssueStatus;
import com.example.netflixmgmt.models.IssueType;
import com.example.netflixmgmt.services.ChangeRequestStatusService;
import com.example.netflixmgmt.services.ChangeRequestTypeService;
import com.example.netflixmgmt.services.IssueService;
import com.example.netflixmgmt.services.IssueStatusService;
import com.example.netflixmgmt.services.IssueTypeService;

@RestController
@RequestMapping(path = "/issue")
public class IssueController {
	
	@Autowired
	IssueService issueService;
	
	@Autowired
	IssueStatusService statusService;
	
	@Autowired
	IssueTypeService typeService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<Object> findAll(){
		List<Issue> allIssues = issueService.getAll();

		if (allIssues.size() == 0)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No issue has been found!");
    	else	   						
    		return ResponseEntity.ok(allIssues);
	}	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getIssueById(@RequestParam("id") Long id) {
		Issue issue = issueService.getById(id);
		
		if (issue == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This change request doesn't exist!");
    	else	   						
    		return ResponseEntity.ok(issue);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getIssueByType(@RequestParam("type") IssueType type) {
		List<Issue> issues = issueService.getByIssueType(type);
		
		if (issues.size() == 0)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No issue has been found!");
    	else	   						
    		return ResponseEntity.ok(issues);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getIssueByStatus(@RequestParam("status") IssueStatus status) {
		List<Issue> issues  = issueService.getByIssueStatus(status);
		
		if (issues.size() == 0)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No issue has been found!");
    	else	   						
    		return ResponseEntity.ok(issues);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> saveIssue(@RequestBody Issue issue) {
		if (issue == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
		else
			return ResponseEntity.ok(issueService.createIssue(issue));
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteIssue(@RequestParam("id") Long id) {
		try {
			issueService.deleteById(id);
			return ResponseEntity.ok("");
		} catch (ServiceException e){
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
	}
	
	@RequestMapping(value = "/save/status", method = RequestMethod.POST)
	public ResponseEntity<?> saveIssueStatus(@RequestBody IssueStatus status) {
		if (status == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
		else
			return ResponseEntity.ok(statusService.createIssueStatus(status));
	}
	
	@RequestMapping(value = "/delete/status", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteIssueStatus(@RequestParam("id") Long id) {
		try {
			statusService.deleteById(id);
			return ResponseEntity.ok("");
		} catch (ServiceException e){
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
	}
	
	@RequestMapping(value = "/save/status", method = RequestMethod.POST)
	public ResponseEntity<?> saveIssueType(@RequestBody IssueType type) {
		if (type == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
		else
			return ResponseEntity.ok(typeService.createIssueType(type));
	}
	
	@RequestMapping(value = "/delete/type", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteIssueType(@RequestParam("id") Long id) {
		try {
			typeService.deleteById(id);
			return ResponseEntity.ok("");
		} catch (ServiceException e){
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
	}
}
