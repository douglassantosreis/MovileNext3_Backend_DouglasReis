package com.dgssr.findrestaurants.application.service;

import java.util.List;

import com.dgssr.findrestaurants.domain.Address;

public interface AddressService {

	public List<Address> findAll();

	public List<Address> findByLatitudeAndLongitude(double latitude, double longitude, double maxKilometer);
	
	public List<Address> findByRestaurantAndLatitudeAndLongitude(Integer restaurantId, double latitude, double longitude, double maxKilometer);

	

}
