package com.aneon.mapper;
import com.aneon.po.Stu_file_lib;

import java.util.List;

public interface Stu_file_libMapper {
    int saveFile(Stu_file_lib sfl);

    int updateFile(Stu_file_lib sfl);

    int deleteFile(String furl);

    List<Stu_file_lib> findFile(String fileName);

    List<Stu_file_lib> getStudentFile(String Snumber);

    List<Stu_file_lib> getStudentFileByFurl(String furl);
}
