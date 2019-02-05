package com.dgssr.findrestaurants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dgssr.findrestaurants.model.Restaurant;
import com.dgssr.findrestaurants.service.RestaurantService;

@Controller
@RequestMapping(path = "/restaurant")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Restaurant> getAll() {
		return restaurantService.findAll();
	}
	
	@GetMapping(path = "/{restaurantId}")
	public ResponseEntity<Restaurant> getById(@PathVariable Integer restaurantId) {
		return restaurantService.findById(restaurantId)
						.map(restaurant -> ResponseEntity.ok(restaurant))
						.orElse(ResponseEntity.notFound().build());
	}
}
