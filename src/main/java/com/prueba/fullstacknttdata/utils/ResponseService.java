package com.prueba.fullstacknttdata.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseService {
    private Integer code;
    private HttpStatus httpStatus;
    private String message;
    private String trace;
    private Object body;
}
