package com.dgssr.findrestaurants.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dgssr.findrestaurants.application.service.RestaurantService;

@Controller
@RequestMapping(path = "/restaurants")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getAll() {
		return ResponseEntity.ok(restaurantService.findAll());
	}

	@GetMapping(path = "/{restaurantId}")
	public @ResponseBody ResponseEntity<?> getById(@PathVariable Integer restaurantId) {
		return ResponseEntity.ok(restaurantService.findById(restaurantId));
	}
}
