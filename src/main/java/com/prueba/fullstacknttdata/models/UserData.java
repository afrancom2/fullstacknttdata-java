package com.prueba.fullstacknttdata.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserData {
    private int identification;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private int phone;
    private String address;
    private String city;

    @JsonCreator
    public UserData(
            @JsonProperty("identification") int identification,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("secondName") String secondName,
            @JsonProperty("firstLastName") String firstLastName,
            @JsonProperty("secondLastName") String secondLastName,
            @JsonProperty("phone") int phone,
            @JsonProperty("address") String address,
            @JsonProperty("city") String city
    ) {
        this.identification = identification;
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.phone = phone;
        this.address = address;
        this.city = city;
    }
}
