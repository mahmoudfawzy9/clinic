package com.mahmoud.clinic2.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessResponse<T> extends BaseResponse{

    private T data ;

    public SuccessResponse(T data) {
        super(Boolean.TRUE);
        this.data = data ;
    }

    public SuccessResponse(String responseMessage, int errorCode, T model) {
        super(responseMessage, errorCode);
        this.data = model;
    }

    public SuccessResponse(String responseMessage, int errorCode) {
        super(responseMessage, errorCode);
    }
}

