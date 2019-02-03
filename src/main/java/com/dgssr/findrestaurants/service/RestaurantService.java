package com.dgssr.findrestaurants.service;

import java.util.List;
import java.util.Optional;

import com.dgssr.findrestaurants.model.Restaurant;

public interface RestaurantService {

	public List<Restaurant> findAll();
	public Optional<Restaurant> findById(Integer restaurantId);

}
