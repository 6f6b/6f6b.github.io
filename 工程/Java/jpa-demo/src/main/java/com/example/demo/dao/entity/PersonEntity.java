package com.example.demo.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * 人实体
 * @Author LiuFeng
 */
@Entity
@Data
@Table(name = "person")
public class PersonEntity {

    /**
     * 人的ID
     */
    @Id
    private Long id;

    /**
     * 人的名字
     */
    private String name;

    /**
     * 受人支配的狗
     */
    @OneToMany
    private List<DogEntity> dogs;
}
