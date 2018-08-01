package com.aneon.service;

import com.aneon.po.Student;

import java.util.List;


public interface StudentService {
    public Student getStudent(String Snumber);
    public int moreStudent(Student student);
    public int changeStudent(Student student);
    public List<Student> qureyAllStudent();

    public Student getStuCnumberById(String Snumber);
    public int changeStuClass(String Snumber,int Cnumber);

    public int changeStuGroup(String Snumber,int Gnumber);

    public List<Student> getStuByClassId(int Cnumber);
    List<Student> getStuByIdOrName(String snumOrSname);
}
