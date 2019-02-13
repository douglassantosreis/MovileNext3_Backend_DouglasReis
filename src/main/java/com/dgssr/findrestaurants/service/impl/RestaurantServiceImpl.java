package com.dgssr.findrestaurants.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgssr.findrestaurants.exception.InvalidInputRestaurantException;
import com.dgssr.findrestaurants.exception.RestaurantNotFoundException;
import com.dgssr.findrestaurants.model.Restaurant;
import com.dgssr.findrestaurants.repository.RestaurantRepository;
import com.dgssr.findrestaurants.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Override
	public List<Restaurant> findAll() {
		return (List<Restaurant>) restaurantRepository.findAll();
	}

	@Override
	public Restaurant findById(Integer restaurantId) {

		if (restaurantId == null)
			throw new InvalidInputRestaurantException("Necessário passar um código de restaurante");
		
		Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);

		if (restaurant.isPresent()) {
			return restaurant.get();
		} else {
			throw new RestaurantNotFoundException("Nenhum restaurante encontrado");
		}
	}
}
