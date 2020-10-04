package com.example.ac1.controllers;

import com.example.ac1.models.IdConflictException;
import com.example.ac1.models.Ac1Request;
import com.example.ac1.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "pedidos")
public class RequestController{

    @Autowired
    private RequestService requestService;

    @PostMapping("/cadastrar")
    public void createRequest (@RequestBody Ac1Request ac1Request) throws IdConflictException {
        requestService.createRequest (ac1Request);
    }

}
