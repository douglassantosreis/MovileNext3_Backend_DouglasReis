package com.dgssr.findrestaurants.application.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgssr.findrestaurants.application.service.ContactService;
import com.dgssr.findrestaurants.domain.Contact;
import com.dgssr.findrestaurants.infrastructure.repositories.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public List<Contact> findAll() {
		return (List<Contact>) contactRepository.findAll();
	}

}
