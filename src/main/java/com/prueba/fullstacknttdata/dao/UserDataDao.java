package com.prueba.fullstacknttdata.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.fullstacknttdata.models.UserData;
import com.prueba.fullstacknttdata.utils.ResponseEnum;
import com.prueba.fullstacknttdata.utils.ServiceException;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Getter
@Component
public class UserDataDao {
    private UserData userData;

    @PostConstruct
    public void init() throws ServiceException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            userData = objectMapper.readValue(new ClassPathResource("data.json").getInputStream(), UserData.class);
        } catch (IOException e) {
            throw ServiceException.builder()
                    .data(ResponseEnum.OK)
                    .build();
        }
    }

}
