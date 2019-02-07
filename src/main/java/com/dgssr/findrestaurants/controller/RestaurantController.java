package com.dgssr.findrestaurants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dgssr.findrestaurants.service.RestaurantService;

import javassist.NotFoundException;

@Controller
@RequestMapping(path = "/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	@GetMapping(path = "/all")
	public @ResponseBody ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.ok(restaurantService.findAll());
		} catch (NotFoundException e) {
			return new ResponseEntity<>("Não foi encontrado nenhum restaurante", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	@GetMapping(path = "/{restaurantId}")
	public @ResponseBody ResponseEntity<?> getById(@PathVariable Integer restaurantId) {

		try {
			return ResponseEntity.ok(restaurantService.findById(restaurantId));

		} catch (NotFoundException e) {
			return new ResponseEntity<>("Não foi encontrado nenhum restaurante", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}

	}
}
