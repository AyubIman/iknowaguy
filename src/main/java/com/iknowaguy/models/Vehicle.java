package com.iknowaguy.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String make;
    private String model;
    private String year;
    private String type;

    public Vehicle() {
    }

    public Vehicle(String make, String model, String year, String type) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void addUser(User user) {
//        this.users.add(user);
//    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Vehicle vehicle = (Vehicle) obj;
        return this.id != null ? this.id.equals(vehicle.id): vehicle.getId() == null;
    }

    @Override
    public int hashCode() {

        return id != null ? id.hashCode():0; //Objects.hash(id);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}