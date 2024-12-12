package com.prueba.fullstacknttdata.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.fullstacknttdata.models.UserData;
import com.prueba.fullstacknttdata.utils.ResponseEnum;
import com.prueba.fullstacknttdata.utils.ServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class USerDataDaoTest {
    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private ClassPathResource classPathResource;

    @InjectMocks
    private UserDataDao userDataDao;

    private InputStream mockInputStream;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockInputStream = mock(InputStream.class);
    }

    @Test
    void init_success() throws Exception {
        // Arrange
        UserData mockUserData = UserData.builder()
                .firstName("andres")
                .identification(23445322)
                .build();

        when(classPathResource.getInputStream()).thenReturn(mockInputStream);
        when(objectMapper.readValue(mockInputStream, UserData.class)).thenReturn(mockUserData);

        // Act
        userDataDao.init();

        // Assert
        assertNotNull(userDataDao.getUserData());
        assertEquals("andres", userDataDao.getUserData().getFirstName());
        assertEquals(23445322, userDataDao.getUserData().getIdentification());
    }

}
