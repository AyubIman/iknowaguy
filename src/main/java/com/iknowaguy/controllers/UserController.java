package com.iknowaguy.controllers;


import com.iknowaguy.models.User;
import com.iknowaguy.repositories.UserRepository;
import com.iknowaguy.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    private static final String template = "Hello, %s!";
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VehicleRepository vehicleRepository;


    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json" })
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json" })
    public @ResponseBody
    Optional<User> getOneUser(final @PathVariable Long id) {
        return userRepository.findById(id);
    }

    @RequestMapping(value = "/save")
    public void saveOneUser() {
        User user = new User("ayub","iman");
        userRepository.save(user);
    }

    private class DecoratedUser{
        private String firstName;
        private String lastName;
        private Long id;
        ArrayList<Long> vehicleIds = new ArrayList<>();

        public DecoratedUser() {
        }

        public DecoratedUser(Long id, String firstName, String lastName ) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public ArrayList<Long> getVehicleIds() {
            return vehicleIds;
        }

        public void setVehicleIds(ArrayList<Long> vehicleIds) {
            this.vehicleIds = vehicleIds;
        }

        public void addVehicleId(Long vehicleId) {
            this.vehicleIds.add(vehicleId);
        }
    }

}