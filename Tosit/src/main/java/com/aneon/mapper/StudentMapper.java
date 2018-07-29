package com.aneon.mapper;
import com.aneon.po.Student;

import java.util.List;

public interface StudentMapper {
    Student selectStudent(String Snumber);
    boolean addStudent(Student student);
    boolean updateStudent(Student student);
    List<Student> getAllStudent();
 }
