package com.example.netflixmgmt.controller;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.netflixmgmt.models.Contract;
import com.example.netflixmgmt.services.ContractService;

@RestController
@RequestMapping(path = "/contract")
public class ContractController {

	@Autowired
	ContractService contractService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<Object> findAll(){
		List<Contract> allContracts = contractService.getAll();

		if (allContracts.size() == 0)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No contracts has been found!");
    	else	   						
    		return ResponseEntity.ok(allContracts);
	}	
	
	@RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> getContractById(@PathVariable Long id) {
		Contract contract = contractService.getById(id);
		
		if (contract == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This contract doesn't exist!");
    	else	   						
    		return ResponseEntity.ok(contract);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> saveContract(@RequestBody Contract contract) {
		if (contract == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't save this contract");
		else
			return ResponseEntity.ok(contractService.createContract(contract));
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteContract(@RequestParam("id") Long id) {
		try {
			contractService.deleteById(id);
			return ResponseEntity.ok("");
		} catch (ServiceException e){
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
	}
}
