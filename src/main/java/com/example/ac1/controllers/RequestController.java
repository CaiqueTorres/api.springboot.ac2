package com.example.ac1.controllers;

import com.example.ac1.models.*;
import com.example.ac1.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "pedidos")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Ac1Response<Ac1Request> createRequest (@RequestBody Ac1Request ac1Request) throws IdConflictAc1Exception {
        return requestService.createRequest (ac1Request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Ac1Response<DefaultListResponse<Ac1Request>> getAllRequest () {
        return requestService.getAllRequests ();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ac1Response<Ac1Request> getAc1RequestById(@PathVariable int id) throws RequestNotFoundAc1Exception {
        return requestService.getAc1RequestById (id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ac1Response<?> deleteAc1RequestById(@PathVariable int id) throws RequestNotFoundAc1Exception {
        return requestService.deleteAc1RequestById (id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Ac1Response<Ac1Request> putAc1Request (@RequestBody Ac1Request ac1Request) throws RequestNotFoundAc1Exception {
        return requestService.putAc1Request (ac1Request);
    }

}
