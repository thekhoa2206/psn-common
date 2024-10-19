package com.psn.common.exception;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

    public ApiException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    private ErrorCode errorCode;

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
