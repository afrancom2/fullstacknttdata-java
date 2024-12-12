package com.prueba.fullstacknttdata.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ServiceException.class})
    protected ResponseEntity<Object> handleServiceException(ServiceException ex, WebRequest request) {
        return handleExceptionInternal(
                ex,
                ResponseService.builder()
                        .code(ex.getData().getCode())
                        .httpStatus(ex.getData().getHttpStatus())
                        .message(ex.getData().getMessage())
                        .trace(!Objects.equals(ex.getData().getHttpStatus(), HttpStatus.OK) ? ex.getMessage() : null)
                        .body(ex.getBody())
                        .build()
                , new HttpHeaders(), ex.getData().getHttpStatus(), request
        );
    }
}
