package com.dgssr.findrestaurants.exception;

import java.io.Serializable;

public class AddressNotFoundException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = -622349365954524482L;

	public AddressNotFoundException(String message) {
		super(message);
	}
}
