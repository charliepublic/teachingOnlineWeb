package com.aneon.mapper;
import com.aneon.po.Stu_file_lib;

import java.util.List;

public interface Stu_file_libMapper {
    void saveFile(Stu_file_lib sfl);

    boolean updateFile(Stu_file_lib sfl);

    boolean deleteFile(String furl);

    Stu_file_lib findFile(String furl);

    List<Stu_file_lib> getStudentFile(String Snumber);
}
