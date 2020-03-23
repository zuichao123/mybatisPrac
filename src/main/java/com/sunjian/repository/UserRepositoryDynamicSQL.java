package com.sunjian.repository;

import com.sunjian.entity.User;

import java.util.List;

/**
 * @author sunjian
 * @date 2020/3/22 10:44
 */
public interface UserRepositoryDynamicSQL {
    public User findUserByUser(User user);
    public void updateUser(User user);
    public List<User> findAllByUser(User user);
}
