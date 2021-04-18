package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user) {
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRole(userRole);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }


    public User findByLoginAndPassword(String login, String password) {
        User user = findByLogin(login);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public void save(User user){
        userRepository.save(user);
    }


    public void delete(int id){
        userRepository.deleteById(id);
    }

    public User getByName(String login){
        return userRepository.findByLogin(login);
    }

    public User edit(int id, User user){
        if(userRepository.findById(id).isPresent()){
            User user1 = userRepository.getOne(id);
            user1.setLogin(user.getLogin());
            user1.setPassword(user.getPassword());
            return userRepository.save(user1);
        }else {
            return null;
        }
    }
}
