package com.example.netflixmgmt.controller;

import com.example.netflixmgmt.models.ChangeRequest;
import com.example.netflixmgmt.models.ChangeRequestType;
import com.example.netflixmgmt.services.ChangeRequestTypeService;

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
    
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> saveChangeRequestType(@RequestBody ChangeRequestType type) {
		if (type == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
		else
			return ResponseEntity.ok(changeRequestTypeService.createChangeRequestType(type));
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteChangeRequestType(@RequestParam("id") Long id) {
		try {
			changeRequestTypeService.deleteById(id);
			return ResponseEntity.ok("");
		} catch (ServiceException e){
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public ResponseEntity<?> getRequestTypeById(@PathVariable Long id) {
		ChangeRequestType type = changeRequestTypeService.getById(id);
		
		if (type == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This change request type doesn't exist!");
    	else	   						
    		return ResponseEntity.ok(type);
	}
}
