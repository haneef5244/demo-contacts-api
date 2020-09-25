package com.airasia.democontactsapi.controller;

import com.airasia.democontactsapi.model.People;
import com.airasia.democontactsapi.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    PeopleService service;

    @GetMapping
    public ResponseEntity<List<People>> getPeopleByParam(@RequestParam HashMap<String, String> hm) {
        return ResponseEntity.ok(service.getPeopleByParam(hm));
    }

}
