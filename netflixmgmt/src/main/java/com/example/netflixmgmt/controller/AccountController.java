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

import com.example.netflixmgmt.models.Account;
import com.example.netflixmgmt.services.AccountService;

@RestController
@RequestMapping(path = "/account")
public class AccountController {
	
	@Autowired
	AccountService accService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<Object> findAll(){
		List<Account> allAccounts = accService.getAll();

		if (allAccounts.size() == 0)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No account has been found!");
    	else	   						
    		return ResponseEntity.ok(allAccounts);
	}	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@RequestParam("id") Long id) {
		Account acc = accService.getById(id);
		
		if (acc == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This account doesn't exist!");
    	else	   						
    		return ResponseEntity.ok(acc);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody Account acc) {
		if (acc == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
		else
			return ResponseEntity.ok(accService.createAccount(acc));
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@RequestParam("id") Long id) {
		try {
			accService.deleteById(id);
			return ResponseEntity.ok("");
		} catch (ServiceException e){
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
	}
}
