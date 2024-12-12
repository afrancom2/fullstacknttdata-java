package com.prueba.fullstacknttdata.services;

import com.prueba.fullstacknttdata.dao.UserDataDao;
import com.prueba.fullstacknttdata.models.UserData;
import com.prueba.fullstacknttdata.models.UserDataDto;
import com.prueba.fullstacknttdata.services.impl.UserDataService;
import com.prueba.fullstacknttdata.utils.ResponseEnum;
import com.prueba.fullstacknttdata.utils.ServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserDataServiceTest {

    @Mock
    private UserDataDao userDataDao;

    @InjectMocks
    private UserDataService userDataService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getUserData_ShouldReturnOk() throws ServiceException {
        UserData mockUserData = UserData.builder().build();
        mockUserData.setIdentification(1);
        mockUserData.setFirstName("John");
        mockUserData.setSecondName("Doe");
        mockUserData.setFirstLastName("Smith");
        mockUserData.setSecondLastName("Johnson");
        mockUserData.setPhone(123456789);
        mockUserData.setAddress("123 Street");
        mockUserData.setCity("Cityville");

        when(userDataDao.getUserData()).thenReturn(mockUserData);

        ServiceException exception = assertThrows(ServiceException.class, () -> {
            userDataService.getUserData(1L);
        });

        assertEquals(ResponseEnum.OK, exception.getData());
        assertInstanceOf(UserDataDto.class, exception.getBody());

        UserDataDto userDataDto = (UserDataDto) exception.getBody();
        assertEquals("John", userDataDto.getFirstName());
        assertEquals("Doe", userDataDto.getSecondName());
    }

    @Test
    void getUserData_ShouldThrowBadRequest_WhenUserNotFound() {
        when(userDataDao.getUserData()).thenReturn(null);
        ServiceException exception = assertThrows(ServiceException.class, () -> {
            userDataService.getUserData(2L);
        });
        assertEquals(ResponseEnum.BAD_REQUEST, exception.getData());
        assertNull(exception.getBody());
    }
}
