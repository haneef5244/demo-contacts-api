package com.airasia.democontactsapi;

import com.airasia.democontactsapi.dal.PeopleDALImpl;
import com.airasia.democontactsapi.obj.req.ContactReq;
import com.airasia.democontactsapi.obj.req.PeopleReq;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.MOCK, classes={ DemoContactsApiApplication.class })
public class PeopleControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    PeopleDALImpl peopleDAL;

    private String userId = "";

    @Before
    public void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void create() throws Exception {
        PeopleReq peopleReq = new PeopleReq();
        peopleReq.setAge("29");
        peopleReq.setHeight("170");
        peopleReq.setName("Tester");

        this.mockMvc.perform(post("/people")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(asJsonString(peopleReq)))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk());
        userId  = peopleDAL.findByName("Tester").get(0).getId();

        ContactReq contactReq = new ContactReq();
        contactReq.setEmail("tester@gmail.com");
        contactReq.setNumber("931231221");
        this.mockMvc.perform(post(String.format("/people/%s/contacts",userId))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(asJsonString(contactReq)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

    }

    @Test
    public void getPeopleByName()  throws Exception {
        this.mockMvc.perform(get("/contacts")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .queryParam("name", "Tester"))
                .andDo(MockMvcResultHandlers.print())
        .andExpect(status().isOk())
        .andExpect(content().string(isNot("[]")));
    }

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Matcher<String> isNot(String s) {
        return CoreMatchers.not(CoreMatchers.containsString(s));
    }
}
