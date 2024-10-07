package com.example.demo.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Entity.Patent;
import com.example.demo.Entity.address.Address;
import com.example.demo.common.Pizza;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {
	
	@Autowired
	private Patent patent;
	@Autowired
	private Address address;
	@Autowired
	private Pizza pizza;

}
