package com.example.demo3.service.impl;

import com.example.demo3.entry.User;
import com.example.demo3.mapper.UserMapper;
import com.example.demo3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Cacheable(cacheNames = "mycache")
    @Override
    public User getUserByID(int id) {
        return userMapper.getUserByID(id);
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean insertUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

}
