package com.dgssr.findrestaurants.infrastructure.exceptions;

import java.io.Serializable;

public class OrderException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 2578886597452071132L;

	public OrderException(String message) {
		super(message);
	}
}
