package com.dgssr.findrestaurants.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dgssr.findrestaurants.domain.Address;
import com.dgssr.findrestaurants.domain.InputSearch;
import com.dgssr.findrestaurants.domain.Restaurant;
import com.dgssr.findrestaurants.infrastructure.exceptions.InvalidInputSearchAddressException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InputSearchTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void shouldBeInputSearchIsWithLatitudeAndLongitude() {
		double latitude = -23.142321;
		double longitude = -26.32434;
		
		InputSearch inputSearch = new InputSearch.InputSearchBuilder()
									.addLatitude(latitude)
									.addLongitude(longitude).build();
		
		assertTrue(inputSearch.getLatitude() == latitude);
		assertTrue(inputSearch.getLongitude() == longitude);

	}
	
	@Test(expected=InvalidInputSearchAddressException.class)
	public void shouldBeInputSearchThrowInvalidInputSearchAddressExceptionWhenIdNull() {
		double latitude = -23.142321;
		double longitude = -26.32434;
		double maxKilometers = 25;
		new InputSearch.InputSearchBuilder()
									.addRestaurantId(null)
									.addLatitude(latitude)
									.addLongitude(longitude)
									.addMaxKilometers(maxKilometers).build();
	}
	
	@Test
	public void shouldBeInputSearchComplete() {
		double latitude = -23.142321;
		double longitude = -26.32434;
		double maxKilometers = 25;
		InputSearch inputSearch = new InputSearch.InputSearchBuilder()
									.addRestaurantId(1)
									.addLatitude(latitude)
									.addLongitude(longitude)
									.addMaxKilometers(maxKilometers).build();
		
		assertTrue(inputSearch.getLatitude() == latitude);
		assertTrue(inputSearch.getLongitude() == longitude);
		assertEquals(inputSearch.getRestaurantId().intValue(), 1);
		assertTrue(inputSearch.getMaxKilometers() == maxKilometers);
	}
	
	@Test
	public void shouldBeInputSearchIsWithLatitudeAndLongitudeAndMaxKilometers() {
		double latitude = -23.142321;
		double longitude = -26.32434;
		double maxKilometers = 25;
		InputSearch inputSearch = new InputSearch.InputSearchBuilder()
									.addLatitude(latitude)
									.addLongitude(longitude)
									.addMaxKilometers(maxKilometers).build();
		
		assertTrue(inputSearch.getMaxKilometers() == maxKilometers);
	}
	
	@Test(expected=InvalidInputSearchAddressException.class)
	public void shouldBeThrowInvalidInputSearchAddressExceptionWhenCheckIfICanContinueUseSearch() {
		new InputSearch().checkIfICanContinueUseSearch();
	}
	
	@Test
	public void shouldBeCheckIfICanContinueUseSearchOk() {
		new InputSearch.InputSearchBuilder()
									.addLatitude(-23.211321)
									.addLongitude(-32.1421).build()
									.checkIfICanContinueUseSearch();
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
	public void shouldBeAddressIsWithCountry() {
		Address address = new Address();
		address.setCountry("SP");
		assertEquals(address.getCountry(), "SP");
	}

	@Test
	public void shouldBeAddressIsWithDistrict() {
		Address address = new Address();
		address.setDistrict("SP");
		assertEquals(address.getDistrict(), "SP");
	}
	
	@Test
	public void shouldBeAddressIsWithLatitude() {
		Address address = new Address();
		address.setLatitude(-22.32412);
		assertTrue(address.getLatitude() == -22.32412);
	}
	
	
	@Test
	public void shouldBeAddressIsWithLongitude() {
		Address address = new Address();
		address.setLongitude(-23.3242);
		assertTrue(address.getLongitude() == -23.3242);
	}
	
	@Test
	public void shouldBeAddressIsWithNumber() {
		Address address = new Address();
		address.setNumber("41A");
		assertEquals(address.getNumber(), "41A");
	}
	
	@Test
	public void shouldBeAddressIsWithStreet() {
		Address address = new Address();
		address.setStreet("Borão do Rio Branco");
		assertEquals(address.getStreet(), "Borão do Rio Branco");
	}
	
	@Test
	public void shouldBeAddressIsWithZipCode() {
		Address address = new Address();
		address.setZipCode("05854323");
		assertEquals(address.getZipCode(), "05854323");
	}
	
	@Test
	public void shouldBeAddressIsWithRestaurant() {
		Address address = new Address();
		address.setRestaurant(new Restaurant());
		assertNotNull(address.getRestaurant());
	}
	
	@Test
	public void shouldBeRestaurantIsOpen() {
		Address address = new Address();
		Restaurant restaurant = new Restaurant();
		restaurant.setOpen(LocalTime.of(0, 1, 0));
		restaurant.setClose(LocalTime.of(23, 59, 0));
		address.setRestaurant(restaurant);
		assertTrue(address.isOpen());
	}
	
	@Test
	public void shouldBeRestaurantIsClose() {
		Address address = new Address();
		Restaurant restaurant = new Restaurant();
		restaurant.setOpen(LocalTime.of(9, 0, 0));
		restaurant.setClose(LocalTime.of(9, 2, 0));
		address.setRestaurant(restaurant);
		assertFalse(address.isOpen());
	}

}
