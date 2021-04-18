package com.example.demo.controller;


import com.example.demo.entity.Order;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper;
    public  UserControllerTest(){
        objectMapper = new ObjectMapper();
    }

    @Test
    public void save() throws Exception{
        User user = new User("aidar","aidar", new Role(),new Order());
        String jsonRequest = objectMapper.writeValueAsString((user));

        mockMvc.perform(post("/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getAll()throws Exception{
        mockMvc.perform( get("/getall/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void update() throws Exception{
        User user = new User("aidar","aidar", new Role(),new Order());
        String jsonRequest = objectMapper.writeValueAsString((user));

        mockMvc.perform(put("/edit/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findByLogin()throws Exception{
        MvcResult mvcResult
                = mockMvc.perform(get("/get/{login}","login"))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();
    }


}

