package com.example.demo.service.impl;

import com.example.demo.dao.dto.DogDto;
import com.example.demo.dao.entity.DogEntity;
import com.example.demo.dao.repository.IDogRepository;
import com.example.demo.service.IDogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Author LiuFeng
 */
@Service
public class DogServiceImpl implements IDogService {

    @Autowired
    private IDogRepository repository;

    /**
     * 新增一只狗
     * @param dto
     */
    public DogDto add(DogDto dto){
        DogEntity entity = buildEntity(dto);
        dto.setId(entity.getId());
        repository.save(entity);
        return dto;
    }

    /**
     * 根据id删除一只狗
     * @param id
     */
    public void deleteById(Long id){
        repository.deleteById(id);
    }

    /**
     * 修改一只狗
     * @param dto
     */
    public void update(DogDto dto){
        DogEntity entity = new DogEntity();
        BeanUtils.copyProperties(dto,entity);
        repository.save(entity);
    }

    /**
     * 查询单个Dog
     * @param id
     * @return
     */
    public DogDto findById(Long id){
        Optional<DogEntity> optionalDogEntity = repository.findById(id);
        if (optionalDogEntity.isPresent()){
            return buildDto(optionalDogEntity.get());
        }
        return null;
    }

    /**
     * 查询Dog列表
     * @return
     */
    public List<DogDto> findAll(){
        List<DogEntity> dogEntities = repository.findAll();
        return dogEntities.stream().map((dogEntity)-> buildDto(dogEntity)).collect(Collectors.toList());
    }

    /**
     * 实体转dto
     * @param entity
     * @return
     */
    private DogDto buildDto(DogEntity entity){
        DogDto dto = new DogDto();
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }

    /**
     * dto转实体
     * @param dto
     * @return
     */
    private DogEntity buildEntity(DogDto dto){
        DogEntity entity = new DogEntity();
        BeanUtils.copyProperties(dto,entity);
        if (dto.getId() == null){
            entity.setId(UUID.randomUUID().getLeastSignificantBits() >>> 1);
        }
        return entity;
    }
}
