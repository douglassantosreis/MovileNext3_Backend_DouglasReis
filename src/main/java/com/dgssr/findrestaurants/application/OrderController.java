package com.dgssr.findrestaurants.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dgssr.findrestaurants.application.service.OrderService;
import com.dgssr.findrestaurants.domain.InputOrder;

@Controller
@RequestMapping(path = "/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getAll() {
		return ResponseEntity.ok(orderService.findAll());
	}

	@GetMapping(path = "/{orderId}")
	public @ResponseBody ResponseEntity<?> getById(@PathVariable Integer orderId) {
		return ResponseEntity.ok(orderService.findById(orderId));
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> save() {
		orderService.save(new InputOrder());
		return ResponseEntity.ok().build();
	}
}
