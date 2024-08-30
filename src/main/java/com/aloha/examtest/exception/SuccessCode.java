package com.aloha.examtest.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum SuccessCode {

    GET_SUCCESS(200, "get top rank user successfully", HttpStatus.OK),
    INVALID_BOD(1008, "Your age must be at least {min}", HttpStatus.BAD_REQUEST);

    SuccessCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private int code;
    private String message;
    private HttpStatusCode statusCode;
}
