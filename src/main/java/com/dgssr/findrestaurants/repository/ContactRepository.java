package com.dgssr.findrestaurants.repository;

import org.springframework.data.repository.CrudRepository;

import com.dgssr.findrestaurants.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

}
