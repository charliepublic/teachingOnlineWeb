package com.aneon.service.Impl;

import com.aneon.mapper.StudentMapper;
import com.aneon.po.Student;
import com.aneon.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public Student getStudent(String Snumber) {
        return studentMapper.selectStudent(Snumber);
    }

    @Override
    public int moreStudent(Student student) {
        Map<String,Object> add = new HashMap<>();
        add.put("Snumber",student.getUsername());
        add.put("Sname",student.getName());
        add.put("Spass", student.getSpass());
        return studentMapper.addStudent(add);
    }

    @Override
    public int changeStudent(Student student) {
        Map<String,Object> changeStu=new HashMap<>();
        changeStu.put("Snumber",student.getUsername());
        changeStu.put("Sname",student.getName());
        changeStu.put("Spass", student.getSpass());
        return studentMapper.updateStudent(changeStu);
    }

    @Override
    public List<Student> qureyAllStudent() {
        return studentMapper.getAllStudent();
    }

    @Override
    public Student getStuCnumberById(String Snumber) {
        /*if((studentMapper.selectStuCnumberById(Snumber))=="null"){
            return 0;
        }*/
        return studentMapper.selectStuCnumberById(Snumber);
    }

    @Override
    public int changeStuClass(String Snumber, int Cnumber) {
        Map<String,Object> a=new HashMap<>();
        a.put("Snumber",Snumber);
        a.put("Cnumber",Cnumber);
        return studentMapper.updateStuCnumber(a);
    }

    @Override
    public int changeStuGroup(String Snumber, int Gnumber) {
        Map<String,Object> a=new HashMap<>();
        a.put("Snumber",Snumber);
        a.put("Gnumber",Gnumber);
        return studentMapper.updateStuGnumber(a);
    }

    @Override
    public List<Student> getStuByClassId(int Cnumber) {
        return studentMapper.selectStuByClassId(Cnumber);
    }

    @Override
    public List<Student> getStuByIdOrName(String snumOrSname) {
        Map<String,Object> snumOrSnameMap = new HashMap<>();
        snumOrSnameMap.put("snumOrSname",snumOrSname);
        return studentMapper.selectStuByIdOrName(snumOrSnameMap);
    }
}

