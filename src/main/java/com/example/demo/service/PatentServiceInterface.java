package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Patent;
import com.example.demo.common.Pizza;
import com.example.demo.dto.RequestDto;


public interface PatentServiceInterface {
	public Patent createPatent(Patent patent) ;
	public List<Patent> getAllPatents();
	public Patent getPatents(Integer id) ;
	public void deleteId(Integer id);
	
	public Pizza savePizza(Pizza pizza);
}
