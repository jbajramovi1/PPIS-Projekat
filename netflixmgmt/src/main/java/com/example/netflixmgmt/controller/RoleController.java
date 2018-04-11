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

import com.example.netflixmgmt.models.Role;
import com.example.netflixmgmt.services.RoleService;

@RestController
@RequestMapping(path = "/role")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<Object> findAll(){
		List<Role> allRoles = roleService.getAll();

		if (allRoles.size() == 0)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No role has been found!");
    	else	   						
    		return ResponseEntity.ok(allRoles);
	}	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getRoleById(@RequestParam("id") Long id) {
		Role role = roleService.getById(id);
		
		if (role == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This role doesn't exist!");
    	else	   						
    		return ResponseEntity.ok(role);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> saveRole(@RequestBody Role role) {
		if (role == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
		else
			return ResponseEntity.ok(roleService.createRole(role));
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteRole(@RequestParam("id") Long id) {
		try {
			roleService.deleteById(id);
			return ResponseEntity.ok("");
		} catch (ServiceException e){
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
	}
}
