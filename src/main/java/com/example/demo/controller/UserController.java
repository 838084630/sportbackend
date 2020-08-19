package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.LoginDao;
import com.example.demo.pojo.QueryInfo;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private LoginDao loginDao;
    @RequestMapping("/allUser")
    public String getUserList(QueryInfo queryInfo){
        int numbers = loginDao.getUserCounts("%" + queryInfo.getQuery() + "%");
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        List<User> users = loginDao.getAllUser("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",users);
        String s = JSON.toJSONString(res);
        return s;
    }

    @RequestMapping("/userState")
    public String updateUserState(Integer id, Boolean state){
        int i = loginDao.updateState(id, state);
        return i >0 ?"success" : "error";
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user){
        System.out.println(user.getUsername());
        user.setState(false);
        int i = loginDao.addUser(user);
        return i >0?"success":"error";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(int id){
        int i = loginDao.deleteUser(id);
        return i>0?"success":"error";
    }

    @RequestMapping("/getUpdate")
    public String getUpdateUser(int id){
        User user = loginDao.getUpdateUser(id);
        String string = JSON.toJSONString(user);
        return string;
    }

    @RequestMapping("/editUser")
    public String editUser(@RequestBody User user){
        int i = loginDao.editUser(user);
        return i>0?"success":"error";
    }
}
