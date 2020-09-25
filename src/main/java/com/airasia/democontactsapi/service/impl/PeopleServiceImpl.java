package com.airasia.democontactsapi.service.impl;

import com.airasia.democontactsapi.constant.PeopleConstantUtil;
import com.airasia.democontactsapi.dal.PeopleDALImpl;
import com.airasia.democontactsapi.exception.InvalidParameterException;
import com.airasia.democontactsapi.exception.PeopleNotFoundException;
import com.airasia.democontactsapi.mapper.ContactObjectMapper;
import com.airasia.democontactsapi.mapper.PeopleObjectMapper;
import com.airasia.democontactsapi.model.Contact;
import com.airasia.democontactsapi.model.People;
import com.airasia.democontactsapi.obj.req.ContactReq;
import com.airasia.democontactsapi.obj.req.PeopleReq;
import com.airasia.democontactsapi.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    PeopleDALImpl peopleDAO;

    @Autowired
    PeopleObjectMapper peopleMapper;

    @Autowired
    ContactObjectMapper contactMapper;

    @Override
    public void createPeople(PeopleReq req) {
        People peopleEntity = (People) peopleMapper.mapResourceToEntity(req);
        peopleDAO.save(peopleEntity);
    }


    @Override
    public void createContact(ContactReq req, String peopleId) {
        People people = peopleDAO.findUniqueById(peopleId);
        if (people == null) {
            throw new PeopleNotFoundException(peopleId);
        }
        people.setContact((Contact) contactMapper.mapResourceToEntity(req));
        peopleDAO.save(people);
    }

    @Override
    public List<People> getPeopleByParam(HashMap<String,String> hm) {
        hm.forEach((k,v) -> {
            if (!PeopleConstantUtil.PEOPLE_PARAM.contains(k)) {
                throw new InvalidParameterException(k);
            }
        });
        List<People> people = peopleDAO.findByParameters(hm);
        if (CollectionUtils.isEmpty(people)) {
            throw new PeopleNotFoundException();
        }
        return people;
    }


}
