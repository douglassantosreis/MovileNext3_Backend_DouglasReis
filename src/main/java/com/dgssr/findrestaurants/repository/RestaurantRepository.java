package com.dgssr.findrestaurants.repository;

import org.springframework.data.repository.CrudRepository;

import com.dgssr.findrestaurants.model.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

}
