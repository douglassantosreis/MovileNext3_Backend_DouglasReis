package com.dgssr.findrestaurants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dgssr.findrestaurants.model.Address;
import com.dgssr.findrestaurants.service.AddressService;

@RestController
@RequestMapping(path = "/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody Iterable<Address> getAll() {
		return addressService.findAll();
	}

	@RequestMapping(value = "/by-latitude-longetude/{latitude},{longitude}", method = RequestMethod.GET)
	public ResponseEntity<Address> getByLatitudeLongetude(@PathVariable String latitude,
			@PathVariable String longitude) {
		return addressService.findByLatitudeAndLongitude(latitude, longitude)
				.map(addresses -> ResponseEntity.ok(addresses)).orElse(ResponseEntity.notFound().build());
	}

	@RequestMapping(value = "/by-restaurant-latitude-longetude/{restaurantId},{latitude},{longitude}", method = RequestMethod.GET)
	public ResponseEntity<Address> getByRestaurantLatitudeLongetude(@PathVariable Integer restaurantId,
			@PathVariable String latitude, @PathVariable String longitude) {
		return addressService.findByRestaurantAndLatitudeAndLongitude(restaurantId, latitude, longitude)
				.map(addresses -> ResponseEntity.ok(addresses)).orElse(ResponseEntity.notFound().build());
	}
}
