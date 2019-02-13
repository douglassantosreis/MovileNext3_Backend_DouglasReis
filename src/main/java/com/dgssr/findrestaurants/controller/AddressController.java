package com.dgssr.findrestaurants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dgssr.findrestaurants.service.AddressService;

@RestController
@RequestMapping(path = "/addresses")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getAll() {
		return ResponseEntity.ok(addressService.findAll());
	}

	@RequestMapping(value = "/find/", method = RequestMethod.GET)
	public ResponseEntity<?> getByLatitudeLongetude(@RequestParam("lat") double latitude, @RequestParam("lon") double longitude,
			@RequestParam("mx") double maxKilometer) {
		return ResponseEntity.ok(addressService.findByLatitudeAndLongitude(latitude, longitude, maxKilometer));
	}

	@RequestMapping(value = "/find/filter/", method = RequestMethod.GET)
	public ResponseEntity<?> getByRestaurantLatitudeLongetude(@RequestParam("id") Integer restaurantId,
			@RequestParam("lat") double latitude, @RequestParam("lon") double longitude, @RequestParam("mx") double maxKilometer) {
		return ResponseEntity.ok(addressService.findByRestaurantAndLatitudeAndLongitude(restaurantId, latitude,
				longitude, maxKilometer));
	}
}
