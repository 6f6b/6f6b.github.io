package com.example.springmvcdemo.repository;

import com.example.springmvcdemo.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
