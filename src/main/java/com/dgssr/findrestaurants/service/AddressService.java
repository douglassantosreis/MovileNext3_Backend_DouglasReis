package com.dgssr.findrestaurants.service;

import java.util.List;

import com.dgssr.findrestaurants.model.Address;

import javassist.NotFoundException;

public interface AddressService {

	public List<Address> findAll() throws NotFoundException, Exception;

	public List<Address> findByLatitudeAndLongitude(String latitude, String longitude) throws NotFoundException, Exception;
	
	public List<Address> findByRestaurantAndLatitudeAndLongitude(Integer restaurantId, String latitude, String longitude) throws NotFoundException, Exception;

	

}
