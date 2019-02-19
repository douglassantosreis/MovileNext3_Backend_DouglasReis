package com.dgssr.findrestaurants.application.implementation;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dgssr.findrestaurants.application.service.implementation.ContactServiceImpl;
import com.dgssr.findrestaurants.domain.Contact;
import com.dgssr.findrestaurants.infrastructure.repositories.ContactRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactServiceImplTests {

	@Mock
	private ContactRepository contactRepository;

	@InjectMocks
	private ContactServiceImpl contactServiceImpl;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void shouldBeFindAllContacts() {

		Contact contactExpected = mock(Contact.class);
		List<Contact> contactsExpected = new ArrayList<Contact>();
		contactsExpected.add(contactExpected);

		when(contactRepository.findAll()).thenReturn(contactsExpected);

		List<Contact> contacts = contactServiceImpl.findAll();

		assertEquals(contactsExpected, contacts);

	}

}
