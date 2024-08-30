package com.example.demo.service.impl;

import com.example.demo.dao.dto.DogDto;
import com.example.demo.dao.dto.PersonDto;
import com.example.demo.dao.entity.DogEntity;
import com.example.demo.dao.entity.PersonEntity;
import com.example.demo.dao.repository.IPersonRepository;
import com.example.demo.service.IPersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Author LiuFeng
 */
@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonRepository repository;

    /**
     * 新增一只人
     * @param dto
     */
    public PersonDto add(PersonDto dto){
        PersonEntity entity = buildEntity(dto);
        dto.setId(entity.getId());
        repository.save(entity);
        return dto;
    }

    /**
     * 根据id删除一只人
     * @param id
     */
    public void deleteById(Long id){
        repository.deleteById(id);
    }

    /**
     * 修改一只人
     * @param dto
     */
    public void update(PersonDto dto){
        PersonEntity entity = buildEntity(dto);
        deleteById(entity.getId());
        repository.save(entity);
    }

    /**
     * 查询单个person
     * @param id
     * @return
     */
    public PersonDto findById(Long id){
        Optional<PersonEntity> optionalPersonEntity = repository.findById(id);
        if (optionalPersonEntity.isPresent()){
            return buildDto(optionalPersonEntity.get());
        }
        return null;
    }

    /**
     * 查询person列表
     * @return
     */
    public List<PersonDto> findAll(){
        List<PersonEntity> personEntities = repository.findAll();
        return personEntities.stream().map((PersonEntity)-> buildDto(PersonEntity)).collect(Collectors.toList());
    }

    /**
     * 实体转dto
     * @param entity
     * @return
     */
    private PersonDto buildDto(PersonEntity entity){
        PersonDto dto = new PersonDto();
        BeanUtils.copyProperties(entity,dto);
        dto.setDogs(entity.getDogs().stream().map((dogEntity -> buildDogDto(dogEntity))).collect(Collectors.toList()));
        return dto;
    }

    /**
     * dto转实体
     * @param dto
     * @return
     */
    private PersonEntity buildEntity(PersonDto dto){
        PersonEntity entity = new PersonEntity();
        BeanUtils.copyProperties(dto,entity);
        if (dto.getId() == null){
            entity.setId(UUID.randomUUID().getLeastSignificantBits() >>> 1);
        }
        if (dto.getDogs() != null){
            entity.setDogs(dto.getDogs().stream().map((dogDto)->buildDogEntity(dogDto)).collect(Collectors.toList()));
        }
        return entity;
    }

    /**
     * 实体转dto
     * @param entity
     * @return
     */
    private DogDto buildDogDto(DogEntity entity){
        DogDto dto = new DogDto();
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }

    /**
     * dto转实体
     * @param dto
     * @return
     */
    private DogEntity buildDogEntity(DogDto dto){
        DogEntity entity = new DogEntity();
        BeanUtils.copyProperties(dto,entity);
        if (dto.getId() == null){
            entity.setId(UUID.randomUUID().getLeastSignificantBits() >>> 1);
        }
        return entity;
    }
}
