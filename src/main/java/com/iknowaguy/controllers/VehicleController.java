package com.iknowaguy.controllers;


import com.iknowaguy.models.Vehicle;
import com.iknowaguy.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/vehicle")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    // Get all the Vehicles in the database
    @GetMapping(value = "/all")
    public List<Vehicle> getAllVehicles(){
        List<Vehicle> vehicles = this.vehicleRepository.findAll();
        return vehicles;
    }

    // Get a single Vehicle in the database
    @GetMapping(value = "/{id}")
    public Optional<Vehicle> getVehicle(@PathVariable("id") String id){
        return this.vehicleRepository.findById(id);
    }

    // Save a new single Vehicle in the database
    @PutMapping
    public void insertVehicle(@RequestBody Vehicle vehicle){
        this.vehicleRepository.insert(vehicle);
    }

    // Update a single Vehicle in the database
    @PostMapping
    public void updateVehicle(@RequestBody Vehicle vehicle){
        this.vehicleRepository.save(vehicle);
    }

    // Delete a single Vehicle in the database
    @DeleteMapping
    public void deleteVehicle(@PathVariable("id") String id){
        this.vehicleRepository.deleteById(id);
    }
}
