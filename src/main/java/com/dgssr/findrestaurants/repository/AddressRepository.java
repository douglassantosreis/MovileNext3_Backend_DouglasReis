package com.dgssr.findrestaurants.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dgssr.findrestaurants.model.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {
	
	@Query(
			  value = "SELECT *,\r\n" + 
			  		"(6371 * acos(\r\n" + 
			  		" cos( radians(?1) )\r\n" + 
			  		" * cos( radians( latitude ) )\r\n" + 
			  		" * cos( radians( longitude ) - radians(?2) )\r\n" + 
			  		" + sin( radians(?1) )\r\n" + 
			  		" * sin( radians( latitude ) ) \r\n" + 
			  		" )\r\n" + 
			  		") AS distance \r\n" + 
			  		"FROM find_restaurants.address HAVING distance < 25", 
			  nativeQuery = true)
	public Optional<List<Address>> findByLatitudeAndLongitude(String latitude, String longitude);
	
	@Query(
			  value = "SELECT *,\r\n" + 
			  		"(6371 * acos(\r\n" + 
			  		" cos( radians(?2) )\r\n" + 
			  		" * cos( radians( latitude ) )\r\n" + 
			  		" * cos( radians( longitude ) - radians(?3) )\r\n" + 
			  		" + sin( radians(?2) )\r\n" + 
			  		" * sin( radians( latitude ) ) \r\n" + 
			  		" )\r\n" + 
			  		") AS distance \r\n" + 
			  		"FROM find_restaurants.address where restaurant_id = ?1 HAVING distance < 25", 
			  nativeQuery = true)
	public Optional<List<Address>> findByRestaurantAndLatitudeAndLongitude(Integer restaurantId, String latitude, String longitude);

}
