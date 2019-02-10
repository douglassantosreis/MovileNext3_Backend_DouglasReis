package com.dgssr.findrestaurants.service;

import java.util.List;

import com.dgssr.findrestaurants.model.Restaurant;

public interface RestaurantService {

	public List<Restaurant> findAll();

	public Restaurant findById(Integer restaurantId);

}
