package com.aneon.mapper;
import com.aneon.po.Teacher_file_lib;

import java.util.List;
import java.util.Map;

public interface Teacher_file_libMapper {
//    int saveFile(Teacher_file_lib tfl);
    int saveFile(Map<String, Object> a);

    int updateFile(Teacher_file_lib tfl);

    int deleteFile(String furl);

    List<Teacher_file_lib> findFile(Map<String, Object> a);

    List<Teacher_file_lib> getTeacherFile(String Tnumber);

    List<Teacher_file_lib> getAllTeacherFile();

    List<Teacher_file_lib> getTeacherFileByFurl(String furl);
}
