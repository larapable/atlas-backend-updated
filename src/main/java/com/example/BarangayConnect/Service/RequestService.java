package com.example.BarangayConnect.Service;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BarangayConnect.Entity.RequestEntity;
import com.example.BarangayConnect.Repository.RequestRepository;

@Service
public class RequestService {
    @Autowired
    RequestRepository rrepo;
    
    //Create
    public RequestEntity insertRequest(RequestEntity request) {
        return rrepo.save(request);
    }

    //Read
    public List<RequestEntity> getAllRequest(){
        return rrepo.findAll();
    }

    //Update
    @SuppressWarnings("finally")
    public RequestEntity updateRequest(int docid, RequestEntity newRequestDetails) {
        RequestEntity request = new RequestEntity();
        try {
            request = rrepo.findById(docid).get();
            request.setLastname(newRequestDetails.getLastname());
            request.setFirstname(newRequestDetails.getFirstname());
            request.setMiddlename(newRequestDetails.getMiddlename());
            request.setSuffix(newRequestDetails.getSuffix());
            request.setBirthdate(newRequestDetails.getBirthdate());
            request.setAge(newRequestDetails.getAge());
            request.setGender(newRequestDetails.getGender());
            request.setNumcopies(newRequestDetails.getNumcopies());
            request.setPurok(newRequestDetails.getPurok());
            request.setPurpose(newRequestDetails.getPurpose());
            request.setDoctype(newRequestDetails.getDoctype());;
            request.setOthers(newRequestDetails.getOthers());
            request.setType(newRequestDetails.getType());
            request.setContactnum(newRequestDetails.getContactnum());
            request.setEmail(newRequestDetails.getEmail());
            request.setTrack(newRequestDetails.getTrack());
        } catch(NoSuchElementException ex) {
            throw new NoSuchElementException("Request "+docid+" does not exist!");
        } finally {
            return rrepo.save(request);
        }
    }

    //Delete 
    public String deleteRequest(int docid) {
        String msg="";
        if (rrepo.findById(docid) != null) {
            rrepo.deleteById(docid);
            msg = "Request "+docid+" is succesfully deleted!";
        } else 
            msg = "Request "+docid+" does not exist!";
            return msg;
    } 


 }