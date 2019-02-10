package com.dgssr.findrestaurants.exception;

import java.io.Serializable;

public class ContactNotFoundException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 5792665703515507188L;

	public ContactNotFoundException(String message) {
		super(message);
	}
}
