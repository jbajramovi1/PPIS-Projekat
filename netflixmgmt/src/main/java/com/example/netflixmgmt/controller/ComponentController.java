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

import com.example.netflixmgmt.models.Component;
import com.example.netflixmgmt.services.ComponentService;

@RestController
@RequestMapping(path = "/component")
public class ComponentController {

	@Autowired
	ComponentService componentService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<Object> findAll(){
		List<Component> allComponents = componentService.getAll();

		if (allComponents.size() == 0)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No components has been found!");
    	else	   						
    		return ResponseEntity.ok(allComponents);
	}	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getComponentById(@RequestParam("id") Long id) {
		Component component = componentService.getById(id);
		
		if (component == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This component doesn't exist!");
    	else	   						
    		return ResponseEntity.ok(component);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> saveComponent(@RequestBody Component component) {
		if (component == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't save this component");
		else
			return ResponseEntity.ok(componentService.createComponent(component));
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteComponent(@RequestParam("id") Long id) {
		try {
			componentService.deleteById(id);
			return ResponseEntity.ok("");
		} catch (ServiceException e){
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
	}
}
