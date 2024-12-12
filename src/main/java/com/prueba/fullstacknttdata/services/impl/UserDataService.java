package com.prueba.fullstacknttdata.services.impl;

import com.prueba.fullstacknttdata.dao.UserDataDao;
import com.prueba.fullstacknttdata.models.UserData;
import com.prueba.fullstacknttdata.models.UserDataDto;
import com.prueba.fullstacknttdata.services.IUserDataService;
import com.prueba.fullstacknttdata.utils.ResponseEnum;
import com.prueba.fullstacknttdata.utils.ServiceException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDataService implements IUserDataService {

    private final UserDataDao userDataDao;

    public UserDataService(UserDataDao userDataDao) {
        this.userDataDao = userDataDao;
    }

    @Override
    public void getUserData(Long id) throws ServiceException {
        UserData userData = Optional.ofNullable(userDataDao.getUserData())
                .filter(user -> user.getIdentification() == id)
                .orElseThrow(() ->
                        ServiceException.builder()
                                .data(ResponseEnum.BAD_REQUEST)
                                .build()
                );

        throw ServiceException.builder()
                .data(ResponseEnum.OK)
                .body(UserDataDto.builder()
                        .firstName(userData.getFirstName())
                        .secondName(userData.getSecondName())
                        .firstLastName(userData.getFirstLastName())
                        .secondLastName(userData.getSecondLastName())
                        .phone(userData.getPhone())
                        .address(userData.getAddress())
                        .city(userData.getCity())
                        .build()
                )
                .build();
    }
}
