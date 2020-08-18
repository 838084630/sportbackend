package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.MenuDao;
import com.example.demo.pojo.MainMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuDao menuDao;

    @RequestMapping("/menus")
    public String getAllMenus(){

        HashMap<String,Object> data = new HashMap<>();
        int status = 404;
        List<MainMenu> menus = menuDao.getMenus();
        if (menus!=null){
            data.put("menus",menus);
            data.put("flag",200);
        }else {
            data.put("flag",400);
        }
        String s = JSON.toJSONString(data);
        return s;

    }
}
