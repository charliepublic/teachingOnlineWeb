package com.aneon.service.Impl;

import com.aneon.po.Stu_file_lib;
import com.aneon.po.Teacher_file_lib;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aneon.service.*;
import com.aneon.mapper.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    Stu_file_libMapper stu_file_libMapper;
    @Autowired
    Teacher_file_libMapper teacher_file_libMapper;


    @Override
    public int addStudentFile(Stu_file_lib stu_file_lib) {
        return stu_file_libMapper.saveFile(stu_file_lib);

    }

    @Override
    public int updataStudentFile(String furl ,String newDetail) {
        Stu_file_lib stu_file_lib = this.getStudentFileByfurl(furl);
        stu_file_lib.setDetail(newDetail);
        return stu_file_libMapper.updateFile(stu_file_lib);
    }

    @Override
    public List<Stu_file_lib> getStudentFileBySnumber(String Snumber) {
        return stu_file_libMapper.getStudentFile(Snumber);
    }

    @Override
    public List<Stu_file_lib> findStudentFileByName(String filename) {
        return stu_file_libMapper.findFile(filename);
    }

    @Override
    public int deleteStudentFileByFurl(String furl) {
        return stu_file_libMapper.deleteFile(furl);
    }

    @Override
    public int addTeacherFile(Map<String, Object> a) {
        return teacher_file_libMapper.saveFile(a);
    }

    @Override
    public int updataTeacherFile(String furl,String newDetail) {
        Teacher_file_lib teacher_file_lib = this.getTeacherFileByFurl(furl);
        teacher_file_lib.setDetail(newDetail);
        return teacher_file_libMapper.updateFile(teacher_file_lib);
    }

    @Override
    public List<Teacher_file_lib> getTeacherFileByTnumber(String Tnumber) {
        return teacher_file_libMapper.getTeacherFile(Tnumber);
    }

    @Override
    public List<Teacher_file_lib> findTeacherFileByName(String filename) {
        Map<String, Object> a = new HashMap<>();
        a.put("filename", filename);
        return teacher_file_libMapper.findFile(a);
    }

    @Override
    public int deleteTeacherFileByFurl(String furl) {
        return teacher_file_libMapper.deleteFile(furl);
    }

    @Override
    public List<Teacher_file_lib> getAllTeacherFile() {
         return teacher_file_libMapper.getAllTeacherFile();
    }

    @Override
    public Teacher_file_lib getTeacherFileByFurl(String furl) {
        List<Teacher_file_lib> LTeacherFile = teacher_file_libMapper.getTeacherFileByFurl(furl);
        Teacher_file_lib teacher_file_lib = LTeacherFile.get(0);
        return teacher_file_lib;
    }

    @Override
    public Stu_file_lib getStudentFileByfurl(String furl) {
        List<Stu_file_lib> LStudentFile = stu_file_libMapper.getStudentFileByFurl(furl);
        Stu_file_lib student_file_lib = LStudentFile.get(0);
        return student_file_lib;
    }
}
