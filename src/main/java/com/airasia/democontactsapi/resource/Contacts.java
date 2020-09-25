package com.airasia.democontactsapi.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;
import lombok.Data;

@JsonApiResource(type = "contacts")
@Data
public class Contacts {

    @JsonApiId
    private String id;

    @JsonProperty
    private String name;
    @JsonProperty
    private String age;
    @JsonProperty
    private String height;
}
