package com.dgssr.findrestaurants.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgssr.findrestaurants.model.Address;
import com.dgssr.findrestaurants.repository.AddressRepository;
import com.dgssr.findrestaurants.service.AddressService;

import javassist.NotFoundException;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public List<Address> findAll() throws NotFoundException, Exception{
		
		List<Address> addresses = (List<Address>) addressRepository.findAll();
		
		if(addresses.isEmpty())
			throw new NotFoundException("Não foi encontrado nenhum endereço");
		
		return addresses;
	}

	@Override
	public List<Address> findByLatitudeAndLongitude(String latitude, String longitude)
			throws NotFoundException, Exception {

		Optional<List<Address>> addresses = addressRepository.findByLatitudeAndLongitude(latitude, longitude);

		if (addresses.isPresent()) {
			return addresses.get();
		} else {
			throw new NotFoundException("Não foi encontrado nenhum endereço");
		}
	}

	@Override
	public List<Address> findByRestaurantAndLatitudeAndLongitude(Integer restaurantId, String latitude,
			String longitude) throws NotFoundException, Exception {

		Optional<List<Address>> addresses = addressRepository.findByRestaurantAndLatitudeAndLongitude(restaurantId,
				latitude, longitude);

		if (addresses.isPresent()) {
			return addresses.get();
		} else {
			throw new NotFoundException("Não foi encontrado nenhum endereço");
		}

	}
}
