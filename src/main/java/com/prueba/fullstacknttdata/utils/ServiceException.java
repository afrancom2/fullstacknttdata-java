package com.prueba.fullstacknttdata.utils;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class ServiceException extends Exception {
    private ResponseEnum data;
    private Object body;
}
