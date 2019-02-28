package com.dgssr.findrestaurants.application.service;

import java.util.List;

import com.dgssr.findrestaurants.domain.InputOrder;
import com.dgssr.findrestaurants.domain.Order;

public interface OrderService {

	public List<Order> findAll();

	public Order findById(Integer orderId);
	
	public void save(InputOrder inputOrder);


}
