package com.dgssr.findrestaurants.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dgssr.findrestaurants.model.Restaurant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressControllerTests {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	private Gson gson;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		gson = new GsonBuilder()
				.registerTypeAdapter(LocalTime.class, (JsonDeserializer<LocalTime>) (json, type,
						jsonDeserializationContext) -> LocalTime.parse(json.getAsJsonPrimitive().getAsString()))
				.create();
	}

	@Test
	public void givenWacWhenServletContextThenItProvidesContactController() {
		ServletContext servletContext = wac.getServletContext();

		Assert.assertNotNull(servletContext);
		Assert.assertTrue(servletContext instanceof MockServletContext);
		Assert.assertNotNull(wac.getBean("restaurantController"));
	}

	@Test
	public void shouldFindAllRestaurants() throws Exception {

		String result = this.mockMvc.perform(get("/restaurants/")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn().getResponse()
				.getContentAsString();

		Restaurant[] restaurantsArray = gson.fromJson(result, Restaurant[].class);

		List<Restaurant> restaurants = Arrays.asList(restaurantsArray);

		assertNotNull(restaurants);
		assertNotNull(restaurants.size() > 0);
		assertPatternForRestaurants(restaurants.get(0));

	}

	@Test
	public void shouldFindOnRestaurantById() throws Exception {

		String result = this.mockMvc.perform(get("/restaurants/1")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn().getResponse()
				.getContentAsString();

		Restaurant restaurant = gson.fromJson(result, Restaurant.class);

		assertPatternForRestaurants(restaurant);

	}

	private void assertPatternForRestaurants(Restaurant restaurant) {
		assertNotNull(restaurant);
		assertEquals(restaurant.getId(), new Integer(1));
		assertEquals(restaurant.getName(), "Metro Capão");
		assertEquals(restaurant.getOpen(), LocalTime.of(9, 0, 0));
		assertEquals(restaurant.getClose(), LocalTime.of(22, 0, 0));
	}

}
