package com.iknowaguy.repositories;
import com.iknowaguy.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
}