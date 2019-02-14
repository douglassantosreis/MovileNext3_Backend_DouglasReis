package com.dgssr.findrestaurants.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dgssr.findrestaurants.application.handlers.Error;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ErrorTests {

	@Test
	public void shouldBeCreate() {
		Error error = new Error(1, "Erro");
		assertNotNull(error);
	}

	@Test
	public void shouldBeHaveCodeError() {
		Error error = new Error(1, "Erro");
		assertEquals(error.getStatus(), 1);
	}

	@Test
	public void shouldBeHaveMessageError() {
		Error error = new Error(1, "Erro");
		assertEquals(error.getMessage(), "Erro");
	}

}
