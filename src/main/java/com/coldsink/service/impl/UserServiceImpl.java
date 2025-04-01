package com.coldsink.service.impl;

import com.coldsink.mapper.UserMapper;
import com.coldsink.entity.User;
import com.coldsink.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        return null;
    }

    @Override
    public User login(User user) {
        return userMapper.geyByUsernameAndPassword(user);
    }
}
