package com.dgssr.findrestaurants.service;

import java.util.List;
import java.util.Optional;

import com.dgssr.findrestaurants.model.Address;

public interface AddressService {

	public List<Address> findAll();

	public Optional<Address> findByLatitudeAndLongitude(String latitude, String longitude);
	
	public Optional<Address> findByRestaurantAndLatitudeAndLongitude(Integer restaurantId, String latitude, String longitude);

	

}
