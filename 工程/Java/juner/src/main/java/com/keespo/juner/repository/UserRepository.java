package com.keespo.juner.repository;

import com.keespo.juner.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByPhone(String phone);
    User findUserById(Integer userId);
}
