package com.dgssr.findrestaurants.infrastructure.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dgssr.findrestaurants.domain.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

}
