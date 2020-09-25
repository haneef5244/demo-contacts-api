package com.airasia.democontactsapi.model;


import lombok.Data;

@Data
public class Contact {
    private String email;
    private String number;

    public String toString() {
        return "Contact[email=" + email + ",number=" + number + "]";
    }



}
