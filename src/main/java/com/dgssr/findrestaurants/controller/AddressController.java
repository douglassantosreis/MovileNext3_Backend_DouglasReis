package com.dgssr.findrestaurants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dgssr.findrestaurants.model.Address;
import com.dgssr.findrestaurants.service.AddressService;

@Controller
@RequestMapping(path = "/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Address> getAll() {
		return addressService.findAll();
	}
}
