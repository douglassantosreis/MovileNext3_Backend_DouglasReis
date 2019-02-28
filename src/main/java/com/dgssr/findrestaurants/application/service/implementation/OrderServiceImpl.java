package com.dgssr.findrestaurants.application.service.implementation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

import com.dgssr.findrestaurants.application.service.OrderService;
import com.dgssr.findrestaurants.domain.InputOrder;
import com.dgssr.findrestaurants.domain.Order;
import com.dgssr.findrestaurants.infrastructure.exceptions.InvalidInputException;
import com.dgssr.findrestaurants.infrastructure.exceptions.OrderNotFoundException;
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
			throw new InvalidInputException("Necessário passar um código do pedido");
		
		Optional<Order> order = orderRepository.findById(restaurantId);

		if (order.isPresent()) {
			return order.get();
		} else {
			throw new OrderNotFoundException("Nenhuma ordem encontrada");
		}
	}

	@Override
	public Order save(InputOrder inputOrder) {
		Order order = orderRepository.save(new Order.OrderBuilder()
				.addCustomerId(inputOrder.getCustomerId())
				.addRestaurantId(inputOrder.getRestaurantId())
				.addPrice(inputOrder.getPrice())
				.addStatus(inputOrder.getStatus())
				.addCreatedAt(new Date())
				.addUpdatedAt(new Date()).build());
		stateMachine.sendEvent(OrderEvents.OPEN);
		return order;
	}
}
