package com.dgssr.findrestaurants.application.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgssr.findrestaurants.application.service.RestaurantService;
import com.dgssr.findrestaurants.domain.Restaurant;
import com.dgssr.findrestaurants.infrastructure.exceptions.InvalidInputException;
import com.dgssr.findrestaurants.infrastructure.exceptions.RestaurantNotFoundException;
import com.dgssr.findrestaurants.infrastructure.repositories.RestaurantRepository;

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
			throw new InvalidInputException("Necessário passar um código de restaurante");
		
		Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);

		if (restaurant.isPresent()) {
			return restaurant.get();
		} else {
			throw new RestaurantNotFoundException("Nenhum restaurante encontrado");
		}
	}
}
