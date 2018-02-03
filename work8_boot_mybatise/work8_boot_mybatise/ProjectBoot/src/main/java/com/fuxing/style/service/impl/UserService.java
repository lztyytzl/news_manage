package com.fuxing.style.service.impl;

import com.fuxing.style.dao.UserMapper;
import com.fuxing.style.model.User;
import com.fuxing.style.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserServiceImpl {

    @Autowired
    private UserMapper userMapper ;

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 说明针对Exception异常也进行回滚，如果不标注，则Spring 默认只有抛出 RuntimeException才会回滚事务
     * try  catch  必须抛出异常 throw e; 不然事务是不会回滚的
     */
    @Override
    @Transactional(rollbackFor = Exception.class,timeout=36000)
    public int insert(User user) {
        int i = userMapper.insert(user);
        try {
//            int b = 1 / 0;
        }catch (Exception e){
            throw e;
        }
        return i;
    }
}
