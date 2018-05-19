package com.example.netflixmgmt.controller;

import java.util.List;
import java.util.Map;

import com.example.netflixmgmt.models.ChangeRequest;
import com.example.netflixmgmt.models.ChangeRequestStatus;
import com.example.netflixmgmt.models.ChangeRequestType;
import com.example.netflixmgmt.repositories.IChangeRequestRepository;
import com.example.netflixmgmt.services.ChangeRequestService;
import com.example.netflixmgmt.services.ChangeRequestStatusService;
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
import java.util.Optional;

@RestController
@RequestMapping(path = "/changeRequest")
public class ChangeRequestController {
	@Autowired
	ChangeRequestService changeService;
	
	@Autowired
	ChangeRequestStatusService statusService;
	
	@Autowired
	ChangeRequestTypeService typeService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<Object> findAll(){
		List<ChangeRequest> allRequests = changeService.getAll();

		if (allRequests.size() == 0)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No change request has been found!");
    	else	   						
    		return ResponseEntity.ok(allRequests);
	}	
	
	@RequestMapping(method = RequestMethod.GET, value="/show/{id}")
	public ResponseEntity<?> getRequestById(@PathVariable Long id) {
		ChangeRequest request = changeService.getById(id);
		
		if (request == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This change request doesn't exist!");
    	else	   						
    		return ResponseEntity.ok(request);
	}
	
	@RequestMapping(value = "/getbytype",method = RequestMethod.GET)
	public ResponseEntity<?> getRequestByType(@RequestParam("type") ChangeRequestType type) {
		List<ChangeRequest> requests = changeService.getByChangeRequestType(type);
		
		if (requests.size() == 0)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This change request doesn't exist!");
    	else	   						
    		return ResponseEntity.ok(requests);
	}
	
	@RequestMapping(value = "/getbystatus",method = RequestMethod.GET)
	public ResponseEntity<?> getRequestByStatus(@RequestParam("status") ChangeRequestStatus status) {
		List<ChangeRequest> requests = changeService.getByChangeRequestStatus(status);
		
		if (requests.size() == 0)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This change request doesn't exist!");
    	else	   						
    		return ResponseEntity.ok(requests);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> saveRequest(@RequestBody ChangeRequest request) {
		if (request == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
		else
			return ResponseEntity.ok(changeService.createChangeRequest(request));
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteRequest(@PathVariable Long id) {
		try {
			changeService.deleteById(id);
			return ResponseEntity.ok("");
		} catch (ServiceException e){
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
	}
	
    @RequestMapping(method=RequestMethod.PUT, value="/{id}/update")
    public ResponseEntity<?> updateChangeRequest(@PathVariable Long id, @RequestBody ChangeRequest changeRequest) {
    	if (changeRequest == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
    	else
    		return ResponseEntity.ok(changeService.updateChangeRequest(changeRequest, id));
    }

	@RequestMapping(value = "/get-stats", method = RequestMethod.GET)
	public ResponseEntity<?> getStatistics() {
		Map<String, Integer> request = changeService.getChangeRequestStatistics();

		if (request == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No requests");
		else
			return ResponseEntity.ok(request);
	}
}
