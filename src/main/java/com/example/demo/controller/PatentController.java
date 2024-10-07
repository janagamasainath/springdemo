package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Patent;
import com.example.demo.Entity.address.Address;
import com.example.demo.common.Pizza;
import com.example.demo.dto.RequestDto;
import com.example.demo.service.PatentService;

@RestController
@CrossOrigin(origins = "https://sai.com")
@RequestMapping(value = "/api/parent" , produces = MediaType.APPLICATION_JSON_VALUE)
public class PatentController {
	
	@Autowired
	private PatentService patentService;
	
	@PostMapping("/savepatent" )

	@CrossOrigin(
	        origins = "https://sai.com", 
	        
	        allowedHeaders = "*", 
	        allowCredentials = "true", 
	        maxAge = 3600)
	public ResponseEntity<Patent> createPatent(@RequestBody Patent dto){
		/*
		 * Patent p = new Patent(); p.setName(dto.getPatent().getName());
		 * p.setSalary(dto.getPatent().getSalary());
		 * 
		 * 
		 * 
		 * Address a = new Address(); a.setCity(dto.getAddress().getCity());
		 * a.setState(dto.getAddress().getState());
		 * 
		 * dto.setAddress(a); dto.setPatent(p); Patent patent =
		 * patentService.createPatent(p);
		 */
		
		
		Patent patent2 = patentService.createPatent(dto);
		return new ResponseEntity<Patent>(patent2,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/findpatent")
	public ResponseEntity<List<Patent>> findAllPatents(){
		List<Patent> allPatents = patentService.getAllPatents();
		return new ResponseEntity<List<Patent>>(allPatents,HttpStatus.OK);
		
	}
	
	@GetMapping("/findpatent/{id}")
	public ResponseEntity<Patent> findpatent(@PathVariable Integer id){
	 Patent patents = patentService.getPatents(id);
	return new ResponseEntity(patents,HttpStatus.OK);

}
	@DeleteMapping("/deleteby/{id}")
	public void deletepatent(@PathVariable Integer id) {
		patentService.deleteId(id);
			
	}
	
	@PostMapping("/savepizza")
	public ResponseEntity<Pizza> savePizza(@RequestBody Pizza req) {
Pizza savePizza = patentService.savePizza(req);
		return new ResponseEntity<Pizza> (savePizza,HttpStatus.CREATED);
		
	}
}