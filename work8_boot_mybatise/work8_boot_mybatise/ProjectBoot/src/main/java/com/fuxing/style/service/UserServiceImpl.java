package com.fuxing.style.service;


import com.fuxing.style.model.User;

public interface UserServiceImpl {

    User selectByPrimaryKey(Integer id);

    int insert(User user);

}
