package com.coder520.user.dao;

import com.coder520.user.entity.User;

/**
 * @author fanbopeng
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    User selectByUsername(String username);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}