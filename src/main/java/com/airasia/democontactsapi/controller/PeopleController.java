package com.airasia.democontactsapi.controller;

import com.airasia.democontactsapi.obj.req.ContactReq;
import com.airasia.democontactsapi.obj.req.PeopleReq;
import com.airasia.democontactsapi.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    PeopleService peopleService;

    @PostMapping
    public void createPeople(@RequestBody PeopleReq req) {
        peopleService.createPeople(req);
    }

    @PostMapping("/{id}/contacts")
    public void updateContact(@RequestBody ContactReq req, @PathVariable String id) {
        peopleService.createContact(req, id);
    }
}
