package com.example.demo.controller;

import com.example.demo.config.jwt.JwtProvider;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.entity.jwtModel.AuthRequest;
import com.example.demo.entity.jwtModel.AuthResponse;
import com.example.demo.entity.jwtModel.RegistrationRequest;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private RoleRepository roleRepository;


    //method is register User
    @PostMapping("/register")
    public String registerUser(@RequestBody RegistrationRequest registrationRequest) {
        User u = new User();
        u.setPassword(registrationRequest.getPassword());
        u.setLogin(registrationRequest.getLogin());
        userService.saveUser(u);
        return "OK";
    }


    //method is login
    @PostMapping("/login")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        User user = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(user.getLogin());
        return new AuthResponse(token);
    }

    //method is get all
    @GetMapping("/getall")
    public List<User> findAll(){
        return userService.getAll();
    }

    //method is delete by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable int id){
        userService.delete(id);
        return new ResponseEntity<>("User is delete", HttpStatus.OK);
    }

    //method is edit by id
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editUser(@PathVariable int id, User user){
        User user1 = userService.edit(id,user);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

    //method is get by name
    @GetMapping("/get/{login}")
    public User getByLogin(@PathVariable String login){
        return userService.getByName(login);
    }

    @GetMapping("/role")
    public List<Role> role(){
        return roleRepository.findAll();
    }

}
