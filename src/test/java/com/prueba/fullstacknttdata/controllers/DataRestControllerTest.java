package com.prueba.fullstacknttdata.controllers;

import com.prueba.fullstacknttdata.services.IUserDataService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = DataRestController.class)
class DataRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IUserDataService userDataService;

    @DisplayName("Test get user data")
    @Test
    void deleteUserData() throws Exception {
        willDoNothing().given(userDataService).getUserData(1L);
        ResultActions resultActions = mockMvc.perform(
                get("/api/{id}", 1L)
        );

        resultActions.andExpect(status().isOk());
    }

}
