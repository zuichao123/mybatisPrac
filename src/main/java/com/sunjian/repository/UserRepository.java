package com.sunjian.repository;

import com.sunjian.entity.User;

import java.io.InputStream;
import java.util.List;

/**
 * @author sunjian
 * @date 2020/3/22 10:44
 */
public interface UserRepository {
    public User findUserById(Integer id);
    public User findUserByName(String name);
    public User findUserByIdAndName(int id, String name);
    public User findUserByUser(User user);

    public String findUsernameById(Integer id);

    public List<User> findAll();

    public void addUser(User user);

    public void deleteUser(Integer id);

    public void updateUser(User user);
}
