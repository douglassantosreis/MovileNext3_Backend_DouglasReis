package com.dgssr.findrestaurants.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgssr.findrestaurants.model.Contact;
import com.dgssr.findrestaurants.repository.ContactRepository;
import com.dgssr.findrestaurants.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public List<Contact> findAll() {
		return (List<Contact>) contactRepository.findAll();
	}

}
