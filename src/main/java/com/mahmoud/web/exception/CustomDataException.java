package com.mahmoud.web.exception;

/**
 * This exception is for DAO to use later in Controller advisor
 *
 */
public class CustomDataException extends CustomException {

	private static final long serialVersionUID = 7168555867098356326L;

	public CustomDataException (String message,int errorCode){
		super(message,errorCode);
	}
}
