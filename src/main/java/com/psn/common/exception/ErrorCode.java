package com.psn.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(1001, "Uncategorized error", HttpStatus.BAD_REQUEST),
    DATA_EXISTED(1002, "Data existed", HttpStatus.BAD_REQUEST),
    DATA_NOT_EXISTED(1005, "Data not existed", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1006, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007, "You do not have permission", HttpStatus.FORBIDDEN),
    INVALID_PARAMS(1008, "Invalid params", HttpStatus.BAD_REQUEST),
    PARAMS_NOT_NULL(1009, "Param is not null", HttpStatus.BAD_REQUEST),
    SAVE_NOT_SUCCESS(1010, "Save data not success", HttpStatus.INTERNAL_SERVER_ERROR),
    ID_NOT_NULL(1011, "Id not null", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1012, "User not existed", HttpStatus.BAD_REQUEST)
    ;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private final int code;
    private final String message;
    private final HttpStatusCode statusCode;
}
