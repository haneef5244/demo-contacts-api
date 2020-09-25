package com.airasia.democontactsapi.mapper;

import com.airasia.democontactsapi.model.People;
import com.airasia.democontactsapi.obj.req.PeopleReq;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;

@Component
public class PeopleObjectMapper {

    private final static MapperFacade peopleMapper;

    static {
        final MapperFactory peopleMapperFactory = new DefaultMapperFactory.Builder().build();
        peopleMapper = peopleMapperFactory.getMapperFacade();
    }

    public Object mapResourceToEntity(Object resource) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        if (resource instanceof PeopleReq) {
            System.out.println("is instance of peoplereq");
            System.out.println("resource.name" + ((PeopleReq) resource).getName());
            mapperFactory.classMap(PeopleReq.class, People.class);
            MapperFacade mapper = mapperFactory.getMapperFacade();
            return mapper.map(resource, People.class);
        }

        return null;
    }
}
