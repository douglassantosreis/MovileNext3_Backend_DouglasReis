package com.dgssr.findrestaurants.application.implementation;

import static org.junit.Assert.assertEquals;
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

import com.dgssr.findrestaurants.application.service.implementation.AddressServiceImpl;
import com.dgssr.findrestaurants.domain.Address;
import com.dgssr.findrestaurants.domain.Restaurant;
import com.dgssr.findrestaurants.infrastructure.repositories.AddressRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceImplTests {

	@Mock
	private AddressRepository addressRepository;

	@InjectMocks
	private AddressServiceImpl addressServiceImpl;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void shouldBeFindAllAddresses() {

		Address addressExpected = mock(Address.class);
		List<Address> addressesExpected = new ArrayList<Address>();
		addressesExpected.add(addressExpected);

		when(addressRepository.findAll()).thenReturn(addressesExpected);

		assertEquals(addressesExpected, addressServiceImpl.findAll());

	}
	
	@Test
	public void shouldBeFindAddressesByLatitudeAndLongitude() {

		Address addressExpected = new Address();
		Restaurant restaurant = new Restaurant();
		restaurant.setOpen(LocalTime.of(0, 1, 0));
		restaurant.setClose(LocalTime.of(23, 59, 0));
		addressExpected.setLatitude(-23.6864837);
		addressExpected.setLongitude(-46.7800381);
		addressExpected.setRestaurant(restaurant);
		List<Address> addressesExpected = new ArrayList<Address>();
		addressesExpected.add(addressExpected);

		when(addressRepository.findAll()).thenReturn(addressesExpected);

		List<Address> addresses = addressServiceImpl.findByLatitudeAndLongitude(-23.6864837, -46.7800381, 25);

		assertEquals(addressesExpected, addresses);

	}
	
	
	@Test
	public void shouldBeFindAddressesfindByRestaurantAndLatitudeAndLongitude() {

		Address addressExpected = new Address();
		Restaurant restaurant = new Restaurant(1);
		restaurant.setOpen(LocalTime.of(0, 1, 0));
		restaurant.setClose(LocalTime.of(23, 59, 0));
		addressExpected.setLatitude(-23.6864837);
		addressExpected.setLongitude(-46.7800381);
		addressExpected.setRestaurant(restaurant);
		List<Address> addressesExpected = new ArrayList<Address>();
		addressesExpected.add(addressExpected);
		
		Optional<List<Address>> optionalExpected = Optional.of(addressesExpected);

		when(addressRepository.findByRestaurantId(1)).thenReturn(optionalExpected);

		List<Address> addresses = addressServiceImpl.findByRestaurantAndLatitudeAndLongitude(1, -23.6864837, -46.7800381, 25);

		assertEquals(addressesExpected, addresses);

	}
	
	@Test
	public void shouldBeReturnEmptyArrayListOfAddress() {

		Address addressExpected = new Address();
		Restaurant restaurant = new Restaurant(1);
		restaurant.setOpen(LocalTime.of(1, 0, 0));
		restaurant.setClose(LocalTime.of(1, 1, 0));
		addressExpected.setLatitude(-23.6864837);
		addressExpected.setLongitude(-46.7800381);
		addressExpected.setRestaurant(restaurant);
		List<Address> addressesExpected = new ArrayList<Address>();
		addressesExpected.add(addressExpected);

		when(addressRepository.findAll()).thenReturn(addressesExpected);

		List<Address> addresses = addressServiceImpl.findByRestaurantAndLatitudeAndLongitude(1, -23.6864837, -46.7800381, 25);

		assertTrue(addresses.isEmpty());

	}

}
