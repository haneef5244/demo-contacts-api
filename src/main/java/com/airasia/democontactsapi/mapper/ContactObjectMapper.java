package com.airasia.democontactsapi.mapper;

import com.airasia.democontactsapi.model.Contact;
import com.airasia.democontactsapi.obj.req.ContactReq;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;

@Component
public class ContactObjectMapper {

    private final static MapperFacade contactMapper;

    static {
        final MapperFactory contactMapperFactory = new DefaultMapperFactory.Builder().build();
        contactMapper = contactMapperFactory.getMapperFacade();
    }

    public Object mapResourceToEntity(Object resource) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        if (resource instanceof ContactReq) {
            mapperFactory.classMap(ContactReq.class, Contact.class);
            MapperFacade mapper = mapperFactory.getMapperFacade();
            return mapper.map(resource, Contact.class);
        }
        return null;
    }
}
