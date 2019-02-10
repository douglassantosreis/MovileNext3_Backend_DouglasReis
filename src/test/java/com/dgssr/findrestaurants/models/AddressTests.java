package com.dgssr.findrestaurants.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dgssr.findrestaurants.model.Address;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void shouldBeAddressIsWithId() {
		Address address = new Address();
		address.setId(1);
		assertEquals(address.getId().intValue(), 1);
	}

	@Test
	public void shouldBeAddressIsWithCity() {
		Address address = new Address();
		address.setCity("São Paulo");
		assertEquals(address.getCity(), "São Paulo");
	}

	@Test
	public void shouldBeAddressIsWithComplement() {
		Address address = new Address();
		address.setComplement("Bloco 19 Apto 400");
		assertEquals(address.getComplement(), "Bloco 19 Apto 400");
	}

	@Test
	public void shouldBeContactIsWithCountry() {
		Address address = new Address();
		address.setCountry("SP");
		assertEquals(address.getCountry(), "SP");
	}

	@Test
	public void shouldBeContactIsWitDistrict() {
		Address address = new Address();
		address.setDistrict("SP");
		assertEquals(address.getDistrict(), "SP");
	}
	
	@Test
	public void shouldBeContactIsWitLatitude() {
		Address address = new Address();
		address.setLatitude(-22.32412);
		assertTrue(address.getLatitude() == -22.32412);
	}

}
