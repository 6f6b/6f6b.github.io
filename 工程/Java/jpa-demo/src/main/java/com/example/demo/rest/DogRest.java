package com.example.demo.rest;

import com.example.demo.dao.dto.DogDto;
import com.example.demo.service.IDogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 狗rest
 * @Author LiuFeng
 */
@RestController
@RequestMapping(value = "dog")
public class DogRest {

    @Autowired
    private IDogService dogService;

    /**
     * 新增一只狗
     * @param dto
     */
    @PostMapping
    public DogDto add(@RequestBody  DogDto dto){
        return dogService.add(dto);
    }

    /**
     * 根据id删除一只狗
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        dogService.deleteById(id);
    }

    /**
     * 修改一只狗
     * @param dto
     */
    @PutMapping
    public void update(@RequestBody DogDto dto){
        dogService.update(dto);
    }

    /**
     * 查询单个Dog
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public DogDto findById(@PathVariable(value = "id") Long id){
        return dogService.findById(id);
    }

    /**
     * 查询Dog列表
     * @return
     */
    @GetMapping
    public List<DogDto> findAll(){
        return dogService.findAll();
    }
}
