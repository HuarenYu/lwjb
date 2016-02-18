package com.lwjb.tour.exceptions;

public class InvalidBookDateException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidBookDateException(String msg) {
		super(msg);
	}

}
