package com.airasia.democontactsapi.dal;

import com.airasia.democontactsapi.model.People;

import java.util.HashMap;
import java.util.List;

public interface PeopleDAL {

    List<People> findByName(String name);

    People findUniqueById(String id);

    People save(People people);

    List<People> findByParameters(HashMap<String,String> parameters);
}
