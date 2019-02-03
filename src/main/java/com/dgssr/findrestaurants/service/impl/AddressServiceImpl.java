package com.dgssr.findrestaurants.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgssr.findrestaurants.model.Address;
import com.dgssr.findrestaurants.repository.AddressRepository;
import com.dgssr.findrestaurants.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public List<Address> findAll() {
		return (List<Address>) addressRepository.findAll();
	}

}
