package com.coldsink.service;

import com.coldsink.entity.User;

import java.util.List;

public interface UserService {
    public List<User> list();

    public User login(User emp);
}
