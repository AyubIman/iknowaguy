package com.iknowaguy.models;

import javax.persistence.*;
        import java.util.ArrayList;
        import java.util.HashSet;
        import java.util.Objects;
        import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    //@OneToMany
    private ArrayList<Long> vehicles = new ArrayList<>();

    public User() {
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName, ArrayList<Long> vehicles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.vehicles = vehicles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public ArrayList<Long> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Long vehicle) {
        this.vehicles.add(vehicle);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        User user = (User) obj;
        return this.id != null ? this.id.equals(user.id): user.getId() == null;
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