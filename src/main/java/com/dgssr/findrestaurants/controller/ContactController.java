package com.dgssr.findrestaurants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dgssr.findrestaurants.model.Contact;
import com.dgssr.findrestaurants.service.ContactService;

@RestController
@RequestMapping(path = "/contact")
public class ContactController {
	
	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody Iterable<Contact> getAll() {
		return contactService.findAll();
	}
}
