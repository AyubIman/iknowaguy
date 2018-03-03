package com.iknowaguy.bootstraps;

import com.iknowaguy.models.User;
import com.iknowaguy.models.Vehicle;
import com.iknowaguy.repositories.UserRepository;
import com.iknowaguy.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class InitializeData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    public InitializeData( ) {
    }

    public InitializeData(UserRepository userRepository, VehicleRepository vehicleRepository) {
        this.userRepository = userRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        for(int i = 0; i <=9; i++) {
            //Ayub
            Vehicle ford = new Vehicle("String make", "String model", "String year", "String type");
            vehicleRepository.save(ford);
            User ayub = new User("Eric", "Evans");
            ayub.addVehicle(ford.getId());
            //ford.addUser(ayub);

            userRepository.save(ayub);
        }

    }
}