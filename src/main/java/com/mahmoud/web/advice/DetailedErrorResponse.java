package com.mahmoud.web.advice;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mahmoud.web.response.BaseResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonInclude(Include.NON_NULL)
public class DetailedErrorResponse<H extends Serializable , D extends Object> extends BaseResponse{

	private H errorHeader;
	private D errorDetails;
	private Integer errorCode;
	
	public DetailedErrorResponse(Boolean success, D errorMsgs) {
		super(success);
		this.errorDetails = errorMsgs ;
	}

	public DetailedErrorResponse(Boolean success, H errorTitle,D errorMsgs) {
		this(success , errorMsgs);
		this.errorHeader = errorTitle ;
	}

	public DetailedErrorResponse(Boolean success, H errorHeader, D errorDetails, Integer errorCode) {
		super(success);
		this.errorHeader = errorHeader;
		this.errorDetails = errorDetails;
		this.errorCode = errorCode;
	}
}
