package com.dgssr.findrestaurants.service;

import java.util.List;

import com.dgssr.findrestaurants.model.Address;

public interface AddressService {

	public List<Address> findAll();

	public List<Address> findByLatitudeAndLongitude(double latitude, double longitude, double maxKilometer);
	
	public List<Address> findByRestaurantAndLatitudeAndLongitude(Integer restaurantId, double latitude, double longitude, double maxKilometer);

	

}
