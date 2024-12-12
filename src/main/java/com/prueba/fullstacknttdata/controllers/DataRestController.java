package com.prueba.fullstacknttdata.controllers;

import com.prueba.fullstacknttdata.services.IUserDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class DataRestController {

    private IUserDataService userDataService;

    @GetMapping("/{id}")
    public void userData(@PathVariable Long id) throws Exception {
        userDataService.getUserData(id);
    }
}
