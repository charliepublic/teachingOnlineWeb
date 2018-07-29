package com.aneon.mapper;

import com.aneon.po.Stu_file_lib;
import com.aneon.po.Teacher_file_lib;

import java.util.List;

public interface fileService {

    int addStudentFile (Stu_file_lib stu_file_lib);
    int updataStudentFile (Stu_file_lib stu_file_lib);
    List<Stu_file_lib> getStudentFileBySnumber(String Snumber);
    List<Stu_file_lib> findStudentFileByName(String filename);
    int deleteStudentFileByFurl(String furl);

    int addTeacherFile (Teacher_file_lib teacher_file_lib);
    int updataTeacherFile (Teacher_file_lib teacher_file_lib);
    List<Teacher_file_lib> getTeacherFileByTnumber(String Tnumber);
    List<Teacher_file_lib> findTeacherFileByName(String filename);
    int deleteTeacherFileByFurl(String furl);
    List<Teacher_file_lib> getAllTeacherFile();

}
