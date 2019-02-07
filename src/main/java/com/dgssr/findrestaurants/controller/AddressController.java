package com.dgssr.findrestaurants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dgssr.findrestaurants.service.AddressService;

import javassist.NotFoundException;

@RestController
@RequestMapping(path = "/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.ok(addressService.findAll());
		} catch (NotFoundException e) {
			return new ResponseEntity<>("Não foi encontrado nenhum restaurante", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	@RequestMapping(value = "/by-latitude-longetude/{latitude},{longitude}", method = RequestMethod.GET)
	public ResponseEntity<?> getByLatitudeLongetude(@PathVariable String latitude, @PathVariable String longitude) {
		try {
			return ResponseEntity.ok(addressService.findByLatitudeAndLongitude(latitude, longitude));

		} catch (NotFoundException e) {
			return new ResponseEntity<>("Não foi encontrado nenhum restaurante", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	@RequestMapping(value = "/by-restaurant-latitude-longetude/{restaurantId},{latitude},{longitude}", method = RequestMethod.GET)
	public ResponseEntity<?> getByRestaurantLatitudeLongetude(@PathVariable Integer restaurantId,
			@PathVariable String latitude, @PathVariable String longitude) {
		try {
			return ResponseEntity
					.ok(addressService.findByRestaurantAndLatitudeAndLongitude(restaurantId, latitude, longitude));

		} catch (NotFoundException e) {
			return new ResponseEntity<>("Não foi encontrado nenhum restaurante", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
}
