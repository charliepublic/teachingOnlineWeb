package com.aneon.service;

import com.aneon.po.*;

import java.util.List;

public interface fileService {

    int addStudentFile (Stu_file_lib stu_file_lib);
    int updataStudentFile (String furl);
    List<Stu_file_lib> getStudentFileBySnumber(String Snumber);
    List<Stu_file_lib> findStudentFileByName(String filename);
    int deleteStudentFileByFurl(String furl);

    int addTeacherFile (Teacher_file_lib teacher_file_lib);
    int updataTeacherFile (String furl);
    List<Teacher_file_lib> getTeacherFileByTnumber(String Tnumber);
    List<Teacher_file_lib> findTeacherFileByName (String filename);
    int deleteTeacherFileByFurl(String furl);
    List<Teacher_file_lib> getAllTeacherFile();
    Teacher_file_lib getTeacherFileByFurl(String furl);
    Stu_file_lib getStudentFileByfurl(String furl);

}
