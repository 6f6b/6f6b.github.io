package com.example.mybatis.mybatisdemo.mapper;

import com.example.mybatis.mybatisdemo.entity.Author;

import java.util.HashMap;
import java.util.List;

public interface AuthorMapper {
    HashMap<String,Object> selectAuthor(Integer id);

    List<Author> selectAuthors();
}
