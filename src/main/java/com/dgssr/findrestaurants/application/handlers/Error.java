package com.dgssr.findrestaurants.application.handlers;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * This class is a simple representation of a message error. This class can be
 * improved to be more informative when passing content to the requester,
 * informing things like the original exception for example.
 * 
 * @author
 *
 */
public class Error {

	private final Date timestamp;
	private final int status;
	private final String message;

	@JsonCreator
	public Error(int status, String message) {
		super();
		this.timestamp = new Date();
		this.status = status;
		this.message = message;
	}

	/**
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

}
