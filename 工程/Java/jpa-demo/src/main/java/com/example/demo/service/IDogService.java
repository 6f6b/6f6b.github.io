package com.example.demo.service;

import com.example.demo.dao.dto.DogDto;
import com.example.demo.dao.entity.DogEntity;
import com.example.demo.dao.repository.IDogRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author LiuFeng
 */
public interface IDogService {

    /**
     * 新增一只狗
     * @param dto
     */
    DogDto add(DogDto dto);

    /**
     * 根据id删除一只狗
     * @param id
     */
    void deleteById(Long id);

    /**
     * 修改一只狗
     * @param dto
     */
    void update(DogDto dto);

    /**
     * 查询单个Dog
     * @param id
     * @return
     */
    DogDto findById(Long id);

    /**
     * 查询Dog列表
     * @return
     */
    List<DogDto> findAll();
}
