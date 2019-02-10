package com.dgssr.findrestaurants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dgssr.findrestaurants.service.ContactService;

@RestController
@RequestMapping(path = "/contacts")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getAll() {
		return ResponseEntity.ok(contactService.findAll());
	}
}
