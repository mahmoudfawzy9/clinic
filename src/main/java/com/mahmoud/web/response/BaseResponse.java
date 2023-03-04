package com.mahmoud.web.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode
@JsonInclude(Include.NON_NULL)
public abstract class BaseResponse{

	@JsonIgnore
	private Boolean success;
	private String message;
	private Integer msgCode ;
	
	/**
	 * @param success
	 */
	public BaseResponse(Boolean success) {
		super();
		this.success = success;
	}
	
	/**
	 * @param success
	 * @param status
	 */
	public BaseResponse(Boolean success, String errorMsg , Integer errorCode) {
		super();
		this.success = success;
		this.message = errorMsg;
		this.msgCode = errorCode;
	}
	
	public BaseResponse(String errorMsg , Integer errorCode) {
		super();
		this.message = errorMsg;
		this.msgCode = errorCode;
	}
}
