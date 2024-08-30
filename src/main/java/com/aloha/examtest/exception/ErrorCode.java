package com.aloha.examtest.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(1111, "Uncategorized EXCEPTION", HttpStatus.INTERNAL_SERVER_ERROR),
    UNCATEGORIZED(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(1001, "Uncategoried error", HttpStatus.BAD_REQUEST),
    USER_EXSITED(101, "USER EXSITED", HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1003, "USERNAME MUST BE AT LEAST {min} CHARACTER", HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(1004, "PASSWORD MUST BE AT LEAST {min} CHARACTER", HttpStatus.BAD_REQUEST),
    USER_NOT_EXSITED(105, "USER NOT EXSITED", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(105, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(105, "You do not have permission", HttpStatus.FORBIDDEN),
    CREATED(201, "create succeffully", HttpStatus.CREATED),
    INVALID_BOD(1008, "Your age must be at least {min}", HttpStatus.BAD_REQUEST);

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private int code;
    private String message;
    private HttpStatusCode statusCode;
}
