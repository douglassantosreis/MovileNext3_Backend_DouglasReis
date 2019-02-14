package com.dgssr.findrestaurants.application.service;

import java.util.List;

import com.dgssr.findrestaurants.domain.Restaurant;

public interface RestaurantService {

	public List<Restaurant> findAll();

	public Restaurant findById(Integer restaurantId);

}
