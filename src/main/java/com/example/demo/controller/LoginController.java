package com.example.demo.controller;


import com.alibaba.fastjson.JSON;
import com.example.demo.dao.LoginDao;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class LoginController {

    @Autowired
    private LoginDao loginDao;
    @RequestMapping("/login")
    public String login(@RequestBody User user){
        System.out.println(user);
        String username = user.getUsername();
        String password = user.getPassword();
        User result = loginDao.findUser(username, password);
        HashMap<String, Object> map = new HashMap<>();
        if (result!=null){
            map.put("code","200");
            map.put("user",result);
        }else{
            map.put("code","400");
            map.put("user",result);
        }
        String res = JSON.toJSONString(map);
        return res;
    }
}
