package com.example.demo.controller;


import com.example.demo.entity.Book;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper;
    public  BookControllerTest(){
        objectMapper = new ObjectMapper();
    }

    @Test
    public void save() throws Exception{
        Book book = new Book("Kolobok","Kolobok","Kolobok","Сказка",100);
        String jsonRequest = objectMapper.writeValueAsString((book));

        mockMvc.perform(post("/book/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findByAuthor()throws Exception{
        MvcResult mvcResult
                = mockMvc.perform(get("/book/author/{author}","author"))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void findByNane()throws Exception{
        MvcResult mvcResult
                = mockMvc.perform(get("/book/name/{name}","name"))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();
    }


    @Test
    public void sort()throws Exception{
        MvcResult mvcResult
                = mockMvc.perform(get("/book/sort"))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void getAll()throws Exception{
        mockMvc.perform( get("/book/getall/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void update() throws Exception{
        Book book = new Book("Kolobok","Kolobok","Kolobok","Сказка",100);
        String jsonRequest = objectMapper.writeValueAsString((book));

        mockMvc.perform(put("/book/edit/{id}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
