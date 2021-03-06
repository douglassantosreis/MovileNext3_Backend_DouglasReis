package com.dgssr.findrestaurants.application.implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dgssr.findrestaurants.application.service.implementation.RestaurantServiceImpl;
import com.dgssr.findrestaurants.domain.Restaurant;
import com.dgssr.findrestaurants.infrastructure.exceptions.InvalidInputException;
import com.dgssr.findrestaurants.infrastructure.exceptions.RestaurantNotFoundException;
import com.dgssr.findrestaurants.infrastructure.repositories.RestaurantRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantServiceImplTests {

	@Mock
	private RestaurantRepository restaurantRepository;

	@InjectMocks
	private RestaurantServiceImpl restaurantServiceImpl;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void shouldBeFindAllRestaurants() {

		Restaurant restaurantExpected = mock(Restaurant.class);
		List<Restaurant> restaurantsExpected = new ArrayList<Restaurant>();
		restaurantsExpected.add(restaurantExpected);

		when(restaurantRepository.findAll()).thenReturn(restaurantsExpected);

		List<Restaurant> restaurants = restaurantServiceImpl.findAll();

		assertEquals(restaurantsExpected, restaurants);

	}

	@Test
	public void shouldBeFindRestaurantById() {

		Restaurant restaurantExpected = mock(Restaurant.class);
		Optional<Restaurant> optionalExpected = Optional.of(restaurantExpected);

		when(restaurantRepository.findById(1)).thenReturn(optionalExpected);

		Restaurant restaurant = restaurantServiceImpl.findById(1);

		assertEquals(restaurantExpected, restaurant);

	}

	@Test(expected = InvalidInputException.class)
	public void shouldBeFindRestaurantByIdThrowInvalidInputRestaurantException() {
		restaurantServiceImpl.findById(null);
	}

	@Test(expected = RestaurantNotFoundException.class)
	public void shouldBeFindRestaurantByIdThrowRestaurantNotFoundException() {

		Integer id = new Integer(1);

		when(restaurantRepository.findById(id)).thenReturn(Optional.empty());

		restaurantServiceImpl.findById(id);

	}
	
	@Test
	public void shouldBeCheckIfRestaurantIsElegibleReturnTrue() {
				Restaurant restaurant = new Restaurant(1);
		restaurant.setOpen(LocalTime.of(0, 1, 0));
		restaurant.setClose(LocalTime.of(23, 59, 0));

		assertTrue(restaurant.isOpen());
	}
	
	@Test
	public void shouldBeCheckIfRestaurantIsElegibleReturnFalse() {
		
		Restaurant restaurant = new Restaurant(1);
		restaurant.setOpen(LocalTime.of(1, 0, 0));
		restaurant.setClose(LocalTime.of(1, 1, 0));
	

		assertFalse(restaurant.isOpen());
	}

}
