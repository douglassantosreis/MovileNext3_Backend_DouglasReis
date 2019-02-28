package com.dgssr.findrestaurants.application.service.implementation;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

import com.dgssr.findrestaurants.application.service.OrderService;
import com.dgssr.findrestaurants.domain.Customer;
import com.dgssr.findrestaurants.domain.InputOrder;
import com.dgssr.findrestaurants.domain.Order;
import com.dgssr.findrestaurants.domain.Restaurant;
import com.dgssr.findrestaurants.infrastructure.exceptions.InvalidInputRestaurantException;
import com.dgssr.findrestaurants.infrastructure.exceptions.RestaurantNotFoundException;
import com.dgssr.findrestaurants.infrastructure.repositories.OrderRepository;
import com.dgssr.findrestaurants.infrastructure.statemachine.OrderEvents;
import com.dgssr.findrestaurants.infrastructure.statemachine.OrderStates;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private StateMachine<OrderStates, OrderEvents> stateMachine;

	
	@Override
	public List<Order> findAll() {
		return (List<Order>) orderRepository.findAll();
	}

	@Override
	public Order findById(Integer restaurantId) {

		if (restaurantId == null)
			throw new InvalidInputRestaurantException("Necessário passar um código do pedido");
		
		Optional<Order> order = orderRepository.findById(restaurantId);

		if (order.isPresent()) {
			return order.get();
		} else {
			throw new RestaurantNotFoundException("Nenhuma ordem encontrada");
		}
	}

	@Override
	public void save(InputOrder inputOrder) {
		
		Order order = new Order();
		order.setPrice(BigDecimal.TEN);
		order.setStatus(OrderStates.OPEN);
		order.setRestaurant(new Restaurant(1));
		order.setCustomer(new Customer(1));
		order.setCreatedAt(new Date());
		order.setUpdatedAt(new Date());
		
		boolean sendEvent = stateMachine.sendEvent(OrderEvents.OPEN);
		System.out.println(sendEvent);
		orderRepository.save(order);
		
		
	}
}
