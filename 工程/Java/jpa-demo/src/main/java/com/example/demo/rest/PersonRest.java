package com.example.demo.rest;

import com.example.demo.dao.dto.PersonDto;
import com.example.demo.service.IDogService;
import com.example.demo.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author LiuFeng
 */
@RestController
@RequestMapping(value = "person")
public class PersonRest {

    @Autowired
    private IPersonService service;

    /**
     * 新增一只人
     * @param dto
     */
    @PostMapping
    public PersonDto add(@RequestBody PersonDto dto){
        return service.add(dto);
    }

    /**
     * 根据id删除一只人
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        service.deleteById(id);
    }

    /**
     * 修改一只人
     * @param dto
     */
    @PutMapping
    public void update(@RequestBody PersonDto dto){
        service.update(dto);
    }

    /**
     * 查询单个Dog
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public PersonDto findById(@PathVariable(value = "id") Long id){
        return service.findById(id);
    }

    /**
     * 查询Dog列表
     * @return
     */
    @GetMapping
    public List<PersonDto> findAll(){
        return service.findAll();
    }
}
