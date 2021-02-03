package com.example.demo.service;

import com.example.demo.dao.dto.PersonDto;

import java.util.List;

/**
 * @Author LiuFeng
 */
public interface IPersonService {

    /**
     * 新增一只人
     * @param dto
     */
    PersonDto add(PersonDto dto);

    /**
     * 根据id删除一只人
     * @param id
     */
    void deleteById(Long id);

    /**
     * 修改一只人
     * @param dto
     */
    void update(PersonDto dto);

    /**
     * 查询单个Dog
     * @param id
     * @return
     */
    PersonDto findById(Long id);

    /**
     * 查询Dog列表
     * @return
     */
    List<PersonDto> findAll();
}
