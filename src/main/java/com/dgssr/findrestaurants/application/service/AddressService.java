package com.dgssr.findrestaurants.application.service;

import java.util.List;

import com.dgssr.findrestaurants.domain.Address;
import com.dgssr.findrestaurants.domain.InputSearch;

public interface AddressService {

	public List<Address> findAll();

	public List<Address> findByLatitudeAndLongitude(double latitude, double longitude, double maxKilometer);
	
	public List<Address> findByRestaurantAndLatitudeAndLongitude(Integer restaurantId, double latitude, double longitude, double maxKilometer);

	public List<Address> transformResult(List<Address> addresses, InputSearch inputSearch);
	
}
