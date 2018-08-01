package com.aneon.mapper;
import com.aneon.po.Student;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    Student selectStudent(String Snumber);

    int addStudent(Student student);
    int updateStudent(Student student);
    List<Student> getAllStudent();

    Student selectStuCnumberById(String Snumber);
    int updateStuCnumber(Map a);

    int updateStuGnumber(Map a);

    List<Student> selectStuByClassId(Integer Cnumber);
    List<Student> selectStuByIdOrName(Map snumOrSnameMap);
}