package com.dgssr.findrestaurants.infrastructure.exceptions;

import java.io.Serializable;

public class InvalidInputException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = -5848048019163959290L;

	public InvalidInputException(String message) {
		super(message);
	}
}
