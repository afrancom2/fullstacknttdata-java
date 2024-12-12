package com.prueba.fullstacknttdata.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ResponseEnum {

    OK(200, HttpStatus.OK, "OK"),
    BAD_REQUEST(400, HttpStatus.BAD_REQUEST, "BAD REQUEST - ID"),
    NOT_FOUND(404, HttpStatus.NOT_FOUND, "NOT FOUND DATA"),;

    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;
}
