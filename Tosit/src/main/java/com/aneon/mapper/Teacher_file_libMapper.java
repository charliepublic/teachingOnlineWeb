package com.aneon.mapper;
import com.aneon.po.Teacher_file_lib;

import java.util.List;
import java.util.Map;

public interface Teacher_file_libMapper {
    void saveFile(Teacher_file_lib tfl);

    boolean updateFile(Teacher_file_lib tfl);

    boolean deleteFile(String furl);

    Teacher_file_lib findFile(String furl);

    List<Teacher_file_lib> getTeacherFile(String Tnumber);

}
