package com.dgssr.findrestaurants.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dgssr.findrestaurants.domain.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {
	
	@Query("SELECT a FROM Address a WHERE RESTAURANT_ID = ?1")
	public Optional<List<Address>> findByRestaurantId(Integer restaurantId);

}
