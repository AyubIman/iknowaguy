package com.iknowaguy.controllers;


import com.iknowaguy.models.User;
import com.iknowaguy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all the users in the database
    @GetMapping(value = "/all")
    public List<User> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        return users;
    }

    // Get a single user from the database
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") String id){
        Optional<User> user = this.userRepository.findById(id);
        return user;
    }

    // Save one new user that is not in the database
    @PutMapping
    public void insert(@RequestBody User user){
        this.userRepository.insert(user);
    }

    // Update an existing user in the database
    @PostMapping
    public void update(@RequestBody User user){
        this.userRepository.save(user);
    }

    // Delete a given user from the database
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        this.userRepository.deleteById(id);
    }
}