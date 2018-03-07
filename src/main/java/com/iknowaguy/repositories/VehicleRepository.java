package com.iknowaguy.repositories;

import com.iknowaguy.models.User;
import com.iknowaguy.models.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle,String>, QuerydslPredicateExecutor<Vehicle> {
}
