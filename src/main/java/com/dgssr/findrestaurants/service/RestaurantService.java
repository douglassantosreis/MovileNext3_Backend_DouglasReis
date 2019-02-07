package com.dgssr.findrestaurants.service;

import java.util.List;

import com.dgssr.findrestaurants.model.Restaurant;

import javassist.NotFoundException;

public interface RestaurantService {

	public List<Restaurant> findAll() throws NotFoundException, Exception;

	public Restaurant findById(Integer restaurantId) throws NotFoundException, Exception;

}
