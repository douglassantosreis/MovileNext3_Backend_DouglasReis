package com.dgssr.findrestaurants.application.integration;

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

import com.dgssr.findrestaurants.domain.Address;
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
	public void givenWacWhenServletContextThenItProvidesAddressController() {
		ServletContext servletContext = wac.getServletContext();

		Assert.assertNotNull(servletContext);
		Assert.assertTrue(servletContext instanceof MockServletContext);
		Assert.assertNotNull(wac.getBean("addressController"));
	}

	@Test
	public void shouldBeFindAllContacts() throws Exception {

		String result = this.mockMvc.perform(get("/addresses/")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn().getResponse()
				.getContentAsString();

		Address[] addressesArray = gson.fromJson(result, Address[].class);

		List<Address> addresses = Arrays.asList(addressesArray);

		assertNotNull(addresses);
		assertNotNull(addresses.size() > 0);
	}
	
	@Test
	public void shouldBeFindAllContactsByLatitudeLongitudeMaxKilometers() throws Exception {

		String result = this.mockMvc.perform(get("/addresses/find/?lat=-23.6864837&lon=-46.7800381&mx=25")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn().getResponse()
				.getContentAsString();

		Address[] addressesArray = gson.fromJson(result, Address[].class);

		List<Address> addresses = Arrays.asList(addressesArray);

		assertNotNull(addresses);
		assertNotNull(addresses.size() > 0);
	}
	
	@Test
	public void shouldBeFindAllContactsByRestaurantLatitudeLongitudeMaxKilometers() throws Exception {

		String result = this.mockMvc.perform(get("/addresses/find/filter/?id=1&lat=-23.6864837&lon=-46.7800381&mx=25")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn().getResponse()
				.getContentAsString();

		Address[] addressesArray = gson.fromJson(result, Address[].class);

		List<Address> addresses = Arrays.asList(addressesArray);

		assertNotNull(addresses);
		assertNotNull(addresses.size() > 0);
	}


}
