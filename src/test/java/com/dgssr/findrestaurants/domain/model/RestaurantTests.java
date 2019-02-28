package com.dgssr.findrestaurants.domain.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dgssr.findrestaurants.domain.Address;
import com.dgssr.findrestaurants.domain.Contact;
import com.dgssr.findrestaurants.domain.Restaurant;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void shouldBeRestaurantIsWithIdPassInCOntructor(){
		Restaurant restaurant = new Restaurant(1);
		assertEquals(restaurant.getId().intValue(), 1);
	}
	
	@Test
	public void shouldBeRestaurantIsWithId(){
		Restaurant restaurant = new Restaurant();
		restaurant.setId(1);
		assertEquals(restaurant.getId().intValue(), 1);
	}
	
	@Test
	public void shouldBeRestaurantIsWithName(){
		Restaurant restaurant = new Restaurant();
		restaurant.setName("Dogão");
		assertEquals(restaurant.getName(), "Dogão");
	}
	
	@Test
	public void shouldBeRestaurantIsWithAddress(){
		Restaurant restaurant = new Restaurant();
		restaurant.setAdresses(new ArrayList<>());
		restaurant.getAdresses().add(new Address());
		assertNotNull(restaurant.getAdresses());
		assertTrue(!restaurant.getAdresses().isEmpty());
	}
	
	@Test
	public void shouldBeRestaurantIsWithContacts(){
		Restaurant restaurant = new Restaurant();
		restaurant.setContacts(new ArrayList<>());
		restaurant.getContacts().add(new Contact());
		assertNotNull(restaurant.getContacts());
		assertTrue(!restaurant.getContacts().isEmpty());
	}
	
	@Test
	public void shouldBeRestaurantIsWithOpenTime(){
		Restaurant restaurant = new Restaurant();
		restaurant.setOpen(LocalTime.now());
		assertNotNull(restaurant.getOpen());
	}
	
	@Test
	public void shouldBeRestaurantIsWithCloseTime(){
		Restaurant restaurant = new Restaurant();
		restaurant.setClose(LocalTime.now());
		assertNotNull(restaurant.getClose());
	}
	
	
	@Test
	public void shouldBeRestaurantIsOpen(){
		Restaurant restaurant = new Restaurant();
		restaurant.setClose(LocalTime.of(0, 1, 0));
		restaurant.setOpen(LocalTime.of(23, 59, 0));
		assertTrue(restaurant.isOpen());
	}
	
}

