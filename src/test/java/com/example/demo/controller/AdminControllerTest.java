package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class AdminControllerTest {

    @Autowired
    MockMvc mockMvc;

    private ObjectMapper mapper;

    public AdminControllerTest(){
        mapper = new ObjectMapper();
    }

    @Test
    @Ignore
    public void getAll()throws Exception{
        mockMvc.perform( get("/ad/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findByName()throws Exception{
        MvcResult mvcResult
       = mockMvc.perform(get("/ad/get/{name}","name"))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void update() throws Exception{
        User user = new User("aidar","aidar", new Role(),new Order());
        String jsonRequest = mapper.writeValueAsString((user));

        mockMvc.perform(put("/ad/edit/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
