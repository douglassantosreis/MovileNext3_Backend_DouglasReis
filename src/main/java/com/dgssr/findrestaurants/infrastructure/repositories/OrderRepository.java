package com.dgssr.findrestaurants.infrastructure.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dgssr.findrestaurants.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
