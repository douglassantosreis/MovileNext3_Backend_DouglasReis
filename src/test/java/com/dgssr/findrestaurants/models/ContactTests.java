package com.dgssr.findrestaurants.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dgssr.findrestaurants.model.Contact;
import com.dgssr.findrestaurants.model.Restaurant;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void shouldBeContactIsWithId() {
		Contact contact = new Contact();
		contact.setId(1);
		assertEquals(contact.getId().intValue(), 1);
	}

	@Test
	public void shouldBeContactIsWithName() {
		Contact contact = new Contact();
		contact.setName("Douglas");
		assertEquals(contact.getName(), "Douglas");
	}

	@Test
	public void shouldBeContactIsWithType() {
		Contact contact = new Contact();
		contact.setType("Residencial");
		assertEquals(contact.getType(), "Residencial");
	}

	@Test
	public void shouldBeContactIsWithNumber() {
		Contact contact = new Contact();
		contact.setNumber("11 9999-9999");
		assertEquals(contact.getNumber(), "11 9999-9999");
	}

	@Test
	public void shouldBeContactIsWithRestaurantReference() {
		Contact contact = new Contact();
		contact.setRestaurant(new Restaurant());
		assertNotNull(contact.getRestaurant());
	}

}
