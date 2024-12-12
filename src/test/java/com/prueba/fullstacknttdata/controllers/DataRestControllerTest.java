package com.prueba.fullstacknttdata.controllers;

import com.prueba.fullstacknttdata.services.IUserDataService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DataRestController.class)
@ContextConfiguration(classes = DataRestControllerTest.TestConfig.class) // Contexto personalizado
class DataRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IUserDataService userDataService;

    @Test
    void userData_ShouldReturnNOk() throws Exception {
        doNothing().when(userDataService).getUserData(1L);

        mockMvc.perform(get("/api/1"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void userData_ShouldHandleException() throws Exception {
        doThrow(new RuntimeException("Service exception")).when(userDataService).getUserData(2L);

        mockMvc.perform(get("/api/2"))
                .andExpect(status().is4xxClientError());
    }

    @Configuration
    static class TestConfig {
        @Bean
        public IUserDataService userDataService() {
            return Mockito.mock(IUserDataService.class);
        }
    }
}
