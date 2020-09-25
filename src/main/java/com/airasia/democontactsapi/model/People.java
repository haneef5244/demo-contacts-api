package com.airasia.democontactsapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "people")
@Data
public class People {

    @Id
    private String id;

    private String name;

    private Integer age;

    private BigDecimal height;

    private Contact contact;

    public String toString() {
        return ("People[id=" + id + "," +
                "name=" + name + "," +
                "age=" + age + "," +
                "height=" + height + "]");
    }

}
