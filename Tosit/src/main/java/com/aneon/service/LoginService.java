package com.aneon.service;

import com.aneon.po.User;

public interface LoginService {
    User login(String username, String password);
}
