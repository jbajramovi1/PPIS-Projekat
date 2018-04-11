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

import com.example.netflixmgmt.models.IssueStatusLog;
import com.example.netflixmgmt.services.IssueStatusLogService;

@RestController
@RequestMapping(path = "/issuelog")
public class IssueStatusLogController {

	@Autowired
	IssueStatusLogService logService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<Object> findAll(){
		List<IssueStatusLog> allStatusLogs = logService.getAll();

		if (allStatusLogs.size() == 0)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No status log has been found!");
    	else	   						
    		return ResponseEntity.ok(allStatusLogs);
	}	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getStatusLogById(@RequestParam("id") Long id) {
		IssueStatusLog statusLog = logService.getById(id);
		
		if (statusLog == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This status log doesn't exist!");
    	else	   						
    		return ResponseEntity.ok(statusLog);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> saveStatusLog(@RequestBody IssueStatusLog log) {
		if (log == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't save this status log");
		else
			return ResponseEntity.ok(logService.createIssueStatusLog(log));
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteStatusLog(@RequestParam("id") Long id) {
		try {
			logService.deleteById(id);
			return ResponseEntity.ok("");
		} catch (ServiceException e){
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
	}
}

