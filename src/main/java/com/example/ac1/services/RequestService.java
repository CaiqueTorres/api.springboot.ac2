package com.example.ac1.services;

import com.example.ac1.models.IdConflictException;
import com.example.ac1.models.Ac1Request;
import com.example.ac1.models.RequestNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RequestService{

    private List<Ac1Request> ac1Requests;

    public RequestService () { }

    public void createRequest (Ac1Request ac1Request) throws IdConflictException {
        if (ac1Requests == null) {
            ac1Requests = Arrays.asList (ac1Request);
        }
        else {
            if (findRequest (ac1Request.id) == null)
                throw new IdConflictException ();
            ac1Requests.add (ac1Request);
        }
    }

    public List<Ac1Request> getAllRequests() {
        return ac1Requests;
    }

    public Ac1Request getRequest(int id) throws Exception {
        Ac1Request ac1Request = findRequest (id);
        if (ac1Request == null)
            throw new RequestNotFoundException ();

        return ac1Request;
    }

    public void deleteRequest(int id) throws Exception{
        Ac1Request ac1Request = findRequest (id);
        if (ac1Request == null)
            throw new RequestNotFoundException ();

        ac1Requests.remove (ac1Request);
    }

    public void patchRequest(Ac1Request p) throws Exception {
        Ac1Request ac1Request = findRequest (p.id);
        if (ac1Request == null)
            throw new RequestNotFoundException ();
        ac1Requests.remove(ac1Request);
        ac1Requests.add (p);
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
