package com.coder520.user.service.impl;

import com.coder520.common.utils.SecurityUtils;
import com.coder520.user.dao.UserMapper;
import com.coder520.user.entity.User;
import com.coder520.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

/**
 * @author: fanbopeng
 * @Date: 2018/9/5 11:45
 * @Description:
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User findUserByUsername(String username) {

        User user = userMapper.selectByUsername(username);
       return user;
    }

    @Override
    public void registerUser(User user) throws NoSuchAlgorithmException {
        user.setPassword(SecurityUtils.encrptyPassword(user.getPassword()));

          userMapper.insert(user);
    }
}
