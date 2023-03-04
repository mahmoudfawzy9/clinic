package com.mahmoud.web.advice;


import com.mahmoud.util.constant.ResponseIntegerKeys;
import com.mahmoud.util.constant.ResponseStringKeys;
import com.mahmoud.web.exception.CustomDataException;
import com.mahmoud.web.exception.CustomServiceException;
import com.mahmoud.web.response.BaseResponse;
import com.mahmoud.web.response.ErrorResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	@ExceptionHandler(value = CustomServiceException.class)
	public @ResponseBody BaseResponse handle(HttpServletRequest req, CustomServiceException ex) {
		ex.printStackTrace();
		return createCustomResponse(ex.getMessage(), ex.getErrorCode());
	}

	@ExceptionHandler(value = CustomDataException.class)
	public @ResponseBody BaseResponse handle(HttpServletRequest req, CustomDataException ex) {
		ex.printStackTrace();
		return createCustomResponse(ex.getMessage(), ex.getErrorCode());
	}

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public @ResponseBody BaseResponse handleMaxSizeException(MaxUploadSizeExceededException exc) {
		exc.printStackTrace();
		return createResponse(ResponseStringKeys.MAX_SIZE_EXCEPTION, ResponseIntegerKeys.MAX_SIZE_EXCEPTION, exc.getMessage());
	}

	@ExceptionHandler(value = SQLException.class)
	public @ResponseBody BaseResponse handle(HttpServletRequest req, SQLException ex) {
		ex.printStackTrace();
		return createResponse(ResponseStringKeys.SQL_EXC, ResponseIntegerKeys.SQL_EXC, ex.getMessage());
	}

	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public @ResponseBody BaseResponse handle(HttpServletRequest req, DataIntegrityViolationException ex) {
		ex.printStackTrace();
		return createCustomResponse(ResponseStringKeys.DATA_INTEGERITY_VIOLATION, ResponseIntegerKeys.DATA_INTEGERITY_VIOLATION);
	}

	@ExceptionHandler(value = ConstraintViolationException.class)
	public @ResponseBody BaseResponse handle(HttpServletRequest req, ConstraintViolationException ex) {
		ex.printStackTrace();
		return createResponse(ex.getConstraintName(),ResponseIntegerKeys.CONSTRAINT_EXC, ex.getMessage());
	}

	@ExceptionHandler(value = Exception.class)
	public @ResponseBody BaseResponse handle(HttpServletRequest req, Exception ex) {
		ex.printStackTrace();
		return createCustomResponse(ResponseStringKeys.EXC,ResponseIntegerKeys.EXC);
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public @ResponseBody BaseResponse handle(HttpServletRequest req, MethodArgumentNotValidException ex) {
		Map<String,String> errors = getErrorCodes(ex.getBindingResult());
		return new DetailedErrorResponse<String,Map<String,String>>(false, ResponseStringKeys.NOT_VALID_EXCEPTION, errors, ResponseIntegerKeys.NOT_VALID_EXCEPTION);
	}

	@ExceptionHandler(value = BindException.class)
	public @ResponseBody BaseResponse handle(HttpServletRequest req, BindException ex) {
		Map<String,String> errors = getErrorCodes(ex.getBindingResult());
		return new DetailedErrorResponse<String, Map<String,String>>(false, ResponseStringKeys.BINDING_EXCEPTION, errors, ResponseIntegerKeys.BINDING_EXCEPTION);
	}

	private BaseResponse createResponse(String errorMsg , Integer errorCode, String errorDetails){
		StringBuilder finalStatusMessage = new StringBuilder(errorMsg);
		StringBuilder finalErrorDetailsMessage = new StringBuilder(errorDetails);
		return new ErrorResponse(finalStatusMessage.toString(), errorCode, finalErrorDetailsMessage.toString());
	}

	private BaseResponse createCustomResponse(String errorMsg , Integer errorCode){
		StringBuilder finalStatusMessage = new StringBuilder(errorMsg);
		return new ErrorResponse(finalStatusMessage.toString(), errorCode);
	}

	public Map<String, String> getErrorCodes(BindingResult bindingResult){
		HashMap<String, String> errorCodes = null;
		if(bindingResult != null && bindingResult.hasErrors()){
			errorCodes = new HashMap<>();
			List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
			for(FieldError fieldError : fieldErrorList)
				errorCodes.put(fieldError.getField(), fieldError.getCode()) ;
		}
		return errorCodes;
	}

}

