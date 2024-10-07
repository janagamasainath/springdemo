package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.aspectj.weaver.tools.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Entity.Patent;
import com.example.demo.Entity.address.Address;
import com.example.demo.common.Pizza;
import com.example.demo.dto.RequestDto;
import com.example.demo.exceptions.PatentException;
import com.example.demo.repo.PatentRepo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class PatentService implements PatentServiceInterface {

	@Autowired
	private PatentRepo patentRepo;
	
	@Lazy
    private RestTemplate template;

	@Override
	public Patent createPatent(Patent patent) {
		Patent savepatent = patentRepo.save(patent);
		return savepatent;

	}
	@Override
	public List<Patent> getAllPatents() {
		List<Patent> all = patentRepo.findAll();
		return all;
	}
	@Override
	public Patent getPatents(Integer id) {

		Patent p = null;
		try {
			p = patentRepo.findById(id).get();
			// return patent;

		} catch (NoSuchElementException e) {
			// TODO: handle exception

			System.out.println(id + "id not found");
		}
		return p;
	}
	@Override
	public void deleteId(Integer id) {
	patentRepo.deleteById(id);
	
		
	}
	@Override
	public Pizza savePizza(Pizza req) {
		// TODO Auto-generated method stub
		/*
		 * Patent p = new Patent(); p.setSalary(req.getPatent().getSalary());
		 * p.setName(req.getPatent().getName()); Address a = new Address();
		 * a.setCity(req.getAddress().getCity());
		 * a.setState(req.getAddress().getState()); Pizza pp = new Pizza();
		 * pp.setName(req.getPizza().getName()); pp.setPrice(req.getPizza().getPrice());
		 * req.setAddress(a); req.setPatent(p); req.setPizza(pp);
		 */
		
		ResponseEntity<Pizza> postForEntity = template.postForEntity("http://localhost:8888/savepizza", req, Pizza.class);
		return req;
	}
}