package com.aneon.service.Impl;

import com.aneon.mapper.UserMapper;
import com.aneon.po.*;
import com.aneon.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        User user = new User();
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        if(username.length() == 10) {
            Teacher teacher = userMapper.selectTeacher(params);
            if (teacher == null) {
                return null;
            }
            if (teacher.isAdmin())
                user.setIdentify(Identify.ROOT);
            else
                user.setIdentify(Identify.TEACHER);
            user.setUsername(teacher.getUsername());
            user.setName(teacher.getName());
            return user;
        }
        else if(username.length() == 12) {
            Student student = userMapper.selectStudent(params);
            if (student == null) {
                return null;
            }
            user.setUsername(student.getUsername());
            user.setName(student.getName());
            user.setIdentify(Identify.STUDENT);
            return user;
        }
        return null;
    }
}
