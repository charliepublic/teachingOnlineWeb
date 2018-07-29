package com.aneon.mapper;

import com.aneon.po.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherMapper {
    List<Teacher> getAllTeachers();
    int updatePlan(Map<String, Object> a);
    int deletePlan(Map<String, Object> a);
}
