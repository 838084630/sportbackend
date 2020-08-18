package com.example.demo.dao;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LoginDao {
        @Select("select * from user where username = #{username} and password = #{password}")
        User findUser(@Param("username") String username, @Param("password") String password);

        List<User> getAllUser(@Param("username") String username, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

        int getUserCounts(@Param("username") String username);
}
