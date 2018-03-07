package com.iknowaguy.controllers;


import com.iknowaguy.models.Vehicle;
import com.iknowaguy.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/vehicle")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping(value = "/all")
    public List<Vehicle> getAllVehicles(){
        List<Vehicle> vehicles = this.vehicleRepository.findAll();
        return vehicles;
    }
}
