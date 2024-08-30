package com.example.demo.dao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 狗实体
 * @Author LiuFeng
 */
@Entity
@Data
@Table(name = "dog")
public class DogEntity {

    /**
     * 狗的ID
     */
    @Id
    private Long id;

    /**
     * 狗的名字
     */
    private String name;
}
