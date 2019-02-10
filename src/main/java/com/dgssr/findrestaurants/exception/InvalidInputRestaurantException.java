package com.dgssr.findrestaurants.exception;

import java.io.Serializable;

public class InvalidInputRestaurantException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = -5848048019163959290L;

	public InvalidInputRestaurantException(String message) {
		super(message);
	}
}
