package com.example.demo.controller;


import com.example.demo.entity.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper;
    public  OrderControllerTest(){
        objectMapper = new ObjectMapper();
    }

    @Test
    public void save() throws Exception{
        Order order = new Order("Bishkek","996777555555","Kolobok@gmail.com","10.10.2020");
        String jsonRequest = objectMapper.writeValueAsString((order));

        mockMvc.perform(post("/order/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getAll()throws Exception{
        mockMvc.perform( get("/order/getorder/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getById()throws Exception{
                 mockMvc.perform(get("/order/get/{id}",2))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void update() throws Exception{
        Order order = new Order("Bishkek","996777555555","Kolobok@gmail.com","10.10.2020");
        String jsonRequest = objectMapper.writeValueAsString((order));

        mockMvc.perform(put("/oder/edit/{id}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
