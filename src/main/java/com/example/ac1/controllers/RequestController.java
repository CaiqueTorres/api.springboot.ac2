package com.example.ac1.controllers;

import com.example.ac1.models.IdConflictException;
import com.example.ac1.models.Ac1Request;
import com.example.ac1.models.RequestNotFoundException;
import com.example.ac1.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "pedidos")
public class RequestController{

    @Autowired
    private RequestService requestService;

    @PostMapping("/cadastrar")
    public void createRequest (@RequestBody Ac1Request ac1Request) throws IdConflictException {
        requestService.createRequest (ac1Request);
    }

    @GetMapping
    public List<Ac1Request> getAllRequest () {
        return requestService.getAllRequests ();
    }

    @GetMapping("/{id}")
    public Ac1Request getAc1RequestById(@PathVariable int id) throws RequestNotFoundException  {
        return requestService.getAc1RequestById (id);
    }

    @DeleteMapping("/{id}")
    public void deleteAc1RequestById(@PathVariable int id) throws RequestNotFoundException  {
        requestService.deleteAc1RequestById (id);
    }

    @PutMapping
    public void putAc1Request (@RequestBody Ac1Request ac1Request) throws RequestNotFoundException  {
        requestService.putAc1Request (ac1Request);
    }
}
