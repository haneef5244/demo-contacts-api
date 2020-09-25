package com.airasia.democontactsapi.service;

import com.airasia.democontactsapi.model.People;
import com.airasia.democontactsapi.obj.req.ContactReq;
import com.airasia.democontactsapi.obj.req.PeopleReq;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface PeopleService {

    void createPeople(PeopleReq req);
    void createContact(ContactReq req, String peopleId);
    List<People> getPeopleByParam(HashMap<String,String> hm);
}
