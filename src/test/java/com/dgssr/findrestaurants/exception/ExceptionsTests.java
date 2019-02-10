package com.dgssr.findrestaurants.exception;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExceptionsTests {

	@Test
	public void shouldBeAddressNotFoundExceptionIsCreated() {
		assertNotNull(new AddressNotFoundException("Exception"));
	}
	@Test
	public void shouldBeContactNotFoundExceptionIsCreated() {
		assertNotNull(new ContactNotFoundException("Exception"));
	}
	@Test
	public void shouldBeInvalidInputRestaurantExceptionIsCreated() {
		assertNotNull(new InvalidInputRestaurantException("Exception"));
	}
	@Test
	public void shouldBeInvalidInputSearchAddressExceptionIsCreated() {
		assertNotNull(new InvalidInputSearchAddressException("Exception"));
	}
	@Test
	public void shouldBeRestaurantNotFoundExceptionIsCreated() {
		assertNotNull(new RestaurantNotFoundException("Exception"));
	}

}
