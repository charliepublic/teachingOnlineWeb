package com.aneon.service;

import com.aneon.po.User;

public interface UserService {
    public User login(String username, String password);
}
