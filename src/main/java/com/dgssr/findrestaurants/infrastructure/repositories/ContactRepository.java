package com.dgssr.findrestaurants.infrastructure.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dgssr.findrestaurants.domain.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

}
