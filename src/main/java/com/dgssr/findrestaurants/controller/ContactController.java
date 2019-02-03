package com.dgssr.findrestaurants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dgssr.findrestaurants.model.Contact;
import com.dgssr.findrestaurants.service.ContactService;

@Controller
@RequestMapping(path = "/contact")
public class ContactController {
	
	@Autowired
	private ContactService contactService;

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Contact> getAll() {
		return contactService.findAll();
	}
}
