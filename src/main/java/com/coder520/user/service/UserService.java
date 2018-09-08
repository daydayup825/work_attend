package com.coder520.user.service;

import com.coder520.user.entity.User;

import java.security.NoSuchAlgorithmException;

/**
 * @author: fanbopeng
 * @Date: 2018/9/5 11:45
 * @Description:
 */
public interface UserService {


    User findUserByUsername(String username);

    void registerUser(User user) throws NoSuchAlgorithmException;
}
