package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper //声明当前接口是一个mapper接口
public interface UserMapper  {
//    @Select("select * from users")
    public List<User> list();

//    @Insert("insert into users(username,age) values(#{username},#{age})")
    public boolean add(User user);

//    @Update("update users set username=#{username} age=#{age}")
    public boolean update(User user);

//    @Delete("delete from users where id=#{id}")
    public boolean delete(int id);
}
