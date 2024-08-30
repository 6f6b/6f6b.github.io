package com.example.demo.dao.repository;

import com.example.demo.dao.entity.DogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 狗仓储
 * @Author LiuFeng
 */
public interface IDogRepository extends JpaRepository<DogEntity,Long> {
}
