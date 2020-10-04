package com.example.ac1.services;

import com.example.ac1.models.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequestService{

    private List<Ac1Request> ac1Requests;

    public RequestService () { }

    public Ac1Response<Ac1Request> createRequest (Ac1Request ac1Request) throws IdConflictAc1Exception {
        if (ac1Requests == null) {
            ac1Requests = new ArrayList<> ();
        }
        else {
            if (findRequest (ac1Request.id) != null)
                throw new IdConflictAc1Exception ();
        }
        ac1Requests.add (ac1Request);

        return new Ac1Response<> (
            201,
            "Pedido criado com sucesso!",
            ac1Request
        );
    }

    public Ac1Response<DefaultListResponse<Ac1Request>> getAllRequests() {
        return new Ac1Response<> (
            200,
            null,
            new DefaultListResponse<> (
                ac1Requests.size (),
                ac1Requests
            )
        );
    }

    public Ac1Response<Ac1Request> getAc1RequestById(int id) throws RequestNotFoundAc1Exception {
        Ac1Request ac1Request = findRequest (id);
        if (ac1Request == null)
            throw new RequestNotFoundAc1Exception ();

        return new Ac1Response<> (
            200,
            null,
            ac1Request
        );
    }

    public Ac1Response<?> deleteAc1RequestById(int id) throws RequestNotFoundAc1Exception {
        Ac1Request ac1Request = findRequest (id);
        if (ac1Request == null)
            throw new RequestNotFoundAc1Exception ();

        ac1Requests.remove (ac1Request);
        return new Ac1Response<> (
                200,
                "Pedido deletado com sucesso!",
                null
        );
    }

    public Ac1Response<Ac1Request> putAc1Request (Ac1Request newAc1Request) throws RequestNotFoundAc1Exception {
        Ac1Request ac1Request = findRequest (newAc1Request.id);
        if (ac1Request == null)
            throw new RequestNotFoundAc1Exception ();
        ac1Requests.remove(ac1Request);
        ac1Requests.add (newAc1Request);
        return new Ac1Response<> (
            200,
            null,
            newAc1Request
        );
    }

    //#region Utils

    public Ac1Request findRequest (int id) {
        for (Ac1Request ac1Request : ac1Requests) {
            if (ac1Request.id == id)
                return ac1Request;
        }
        return null;
    }

    //#endregion

}
