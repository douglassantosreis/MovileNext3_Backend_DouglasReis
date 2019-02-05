package com.dgssr.findrestaurants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dgssr.findrestaurants.model.Restaurant;
import com.dgssr.findrestaurants.service.RestaurantService;

@RestController
@RequestMapping(path = "/restaurant")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody Iterable<Restaurant> getAll() {
		return restaurantService.findAll();
	}
	
	@RequestMapping(value = "/{restaurantId}", method = RequestMethod.GET)
	public ResponseEntity<Restaurant> getById(@PathVariable Integer restaurantId) {
		return restaurantService.findById(restaurantId)
						.map(restaurant -> ResponseEntity.ok(restaurant))
						.orElse(ResponseEntity.notFound().build());
	}
}
