package com.aneon.mapper;
import com.aneon.po.Student;

import java.util.List;

public interface StudentMapper {
    Student selectStudent(String Snumber);
    int addStudent(Student student);
    int updateStudent(Student student);
    List<Student> getAllStudent();
 }
