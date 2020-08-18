package com.example.demo.dao;

import com.example.demo.pojo.MainMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface MenuDao {
    List<MainMenu> getMenus();
}
