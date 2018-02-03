package com.fuxing.style.controller;

import com.fuxing.style.model.User;
import com.fuxing.style.service.impl.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService ;

    @RequestMapping("/insertUser")
    @ResponseBody
    public int insertUser(User user) {
        int i = userService.insert(user) ;
        return i;
    }

    @RequestMapping("/{user_id}")
    @ResponseBody
    public String findUserById(@PathVariable(value = "user_id") Integer user_id) {
        return userService.selectByPrimaryKey(user_id).toString();
    }

    @RequestMapping("/test")
    @ResponseBody
    public String findUserById() {
        return "test";
    }
}
