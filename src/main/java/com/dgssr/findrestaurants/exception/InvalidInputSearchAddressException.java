package com.dgssr.findrestaurants.exception;

import java.io.Serializable;

public class InvalidInputSearchAddressException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = -5848048019163959290L;

	public InvalidInputSearchAddressException(String message) {
		super(message);
	}
}
