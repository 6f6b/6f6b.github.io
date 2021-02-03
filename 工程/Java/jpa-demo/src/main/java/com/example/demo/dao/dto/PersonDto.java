package com.example.demo.dao.dto;

import com.example.demo.dao.entity.DogEntity;
import lombok.Data;

import javax.persistence.OneToMany;
import java.util.List;

/**
 * @Author LiuFeng
 */
@Data
public class PersonDto {

    /**
     * 人的ID
     */
    private Long id;

    /**
     * 人的名字
     */
    private String name;

    /**
     * 受人支配的狗
     */
    private List<DogDto> dogs;
}
