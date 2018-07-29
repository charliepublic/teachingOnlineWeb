package com.aneon.mapper;

import com.aneon.po.RootManager;
import com.aneon.po.Student;
import com.aneon.po.Teacher;

import java.util.Map;

public interface UserMapper {
    Student selectStudent();
    Teacher selectTeacher();
    RootManager selectAdmin(Map<String, Object> a);
}
