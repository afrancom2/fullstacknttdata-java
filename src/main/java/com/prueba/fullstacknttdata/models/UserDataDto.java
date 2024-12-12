package com.prueba.fullstacknttdata.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDataDto {
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private int phone;
    private String address;
    private String city;
}
