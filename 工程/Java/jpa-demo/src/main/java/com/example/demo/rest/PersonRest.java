package com.example.demo.rest;

import com.example.demo.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author LiuFeng
 */
@RestController
@RequestMapping(value = "person")
public class PersonRest {

    @Autowired
    private IPersonService personService;
}
