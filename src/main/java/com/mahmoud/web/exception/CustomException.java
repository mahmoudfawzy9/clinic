package com.mahmoud.web.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
public class CustomException extends RuntimeException{
	
	private static final long serialVersionUID = 6008437565530199228L;

	private final int errorCode;
	
	public CustomException (String message, int errorCode){
		super(message);
		this.errorCode=errorCode;

	}
}
