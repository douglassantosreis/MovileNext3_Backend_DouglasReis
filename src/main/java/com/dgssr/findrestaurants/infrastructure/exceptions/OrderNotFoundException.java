package com.dgssr.findrestaurants.infrastructure.exceptions;

import java.io.Serializable;

public class OrderNotFoundException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 2578886597452071132L;

	public OrderNotFoundException(String message) {
		super(message);
	}
}
