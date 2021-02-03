package com.example.demo.dao.repository;

import com.example.demo.dao.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 人仓储
 * @Author LiuFeng
 */
public interface IPersonRepository extends JpaRepository<PersonEntity,Long> {
}
