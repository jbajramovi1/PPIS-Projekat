package com.example.netflixmgmt.controller;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.netflixmgmt.models.ChangeRequestStatus;
import com.example.netflixmgmt.models.ChangeRequestType;
import com.example.netflixmgmt.services.ChangeRequestStatusService;

@RestController
@RequestMapping(path = "/changeRequestStatus")
public class ChangeRequestStatusController {
    @Autowired
    ChangeRequestStatusService changeRequestStatusService;

    @RequestMapping(value = "/all",  method = RequestMethod.GET)
    public ResponseEntity<Object> findAll(){
        List<ChangeRequestStatus> allRequests = changeRequestStatusService.getAll();

        if (allRequests.size() == 0)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No change request type has been found!");
        else
            return ResponseEntity.ok(allRequests);
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> saveChangeRequestStatus(@RequestBody ChangeRequestStatus status) {
		if (status == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
		else
			return ResponseEntity.ok(changeRequestStatusService.createChangeRequestStatus(status));
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteChangeRequestStatus(@RequestParam("id") Long id) {
		try {
			changeRequestStatusService.deleteById(id);
			return ResponseEntity.ok("");
		} catch (ServiceException e){
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public ResponseEntity<?> getRequestStatusById(@PathVariable Long id) {
		ChangeRequestStatus status = changeRequestStatusService.getById(id);
		
		if (status == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This change request status doesn't exist!");
    	else	   						
    		return ResponseEntity.ok(status);
	}
}
