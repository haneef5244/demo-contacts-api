package com.airasia.democontactsapi.dal;

import com.airasia.democontactsapi.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class PeopleDALImpl implements PeopleDAL {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<People> findByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.find(query, People.class);
    }

    @Override
    public People findUniqueById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, People.class);
    }

    @Override
    public synchronized People save(People people) {
        return mongoTemplate.save(people);
    }

    @Override
    public List<People> findByParameters(HashMap<String, String> parameters) {
        Query query = new Query();
        parameters.forEach((k,v) -> query.addCriteria(Criteria.where(k).is(v)));
        return mongoTemplate.find(query, People.class);
    }


}
