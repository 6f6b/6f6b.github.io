package com.example.demo.rest;

import com.example.demo.service.IDogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 狗rest
 * @Author LiuFeng
 */
@RestController
@RequestMapping(value = "dog")
public class DogRest {

    @Autowired
    private IDogService dogService;
}
