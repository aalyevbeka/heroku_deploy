package com.example.demo.controller;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/ad")
public class AdminController {

    @Autowired
    private UserService userService;


    //method is get all
    @GetMapping("/")
    public List<User> getAllAdmins(){
        return userService.getAll();
    }

    //method is delete by id
    @DeleteMapping("/delete/{id}")
    public void deleteAdminById(@PathVariable int id){
        userService.delete(id);
    }

    //method is edit by id
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updatwAdmin(@PathVariable int id, User user){
        User user1 = userService.edit(id,user);
        return new ResponseEntity<>("admin is update", HttpStatus.OK);
    }

    //method is get by name
    @GetMapping("/get/{name}")
    public User getByName(@PathVariable String name){
        return userService.getByName(name);
    }
}
