package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.LoginDao;
import com.example.demo.pojo.QueryInfo;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private LoginDao loginDao;
    @RequestMapping("/alluser")
    public String getUserList(QueryInfo queryInfo){
        int numbers = loginDao.getUserCounts("%" + queryInfo.getQuery() + "%");
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        List<User> users = loginDao.getAllUser("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("unumber",numbers);
        res.put("data",users);
        String s = JSON.toJSONString(res);
        return s;
    }
}
