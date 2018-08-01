package com.aneon.controller;

import com.aneon.po.Student;
import com.aneon.service.StudentService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Index;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/addStudent.do",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String addStudent(String Snumber,String Sname,String Spass,HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        Student student = new Student(Snumber,Sname,Spass);
        String res = "添加失败";
        int row = studentService.moreStudent(student);
        if (row>0){
            res="添加成功";
        }

        return res;
    }
    @RequestMapping(value = "/changeStudent.do",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String changeStudent(String Snumber,String Sname,String Spass,HttpServletResponse response){
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        Student student = new Student(Snumber,Sname,Spass);
        String res = "修改失败";
        int row = studentService.changeStudent(student);
        if (row>0){
            res="修改成功";
        }

        return res;

    }



    @RequestMapping(value="/AllStudent.do",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String AllStudent(HttpServletResponse response){
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String jStudents;
        List<Student> lStudentInfo=studentService.qureyAllStudent();
        ObjectMapper mapper = new ObjectMapper();
        try {
            jStudents=mapper.writeValueAsString(lStudentInfo);
        }catch (IOException e){
            e.printStackTrace();
            return "[]";
        }
        return jStudents;
    }

    @RequestMapping (value="/findStuCnumberById.do",produces = "text/html;charset=UTF-8")
    public @ResponseBody String findStuCnumberById(String Snumber,HttpServletResponse response){
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String StuInfo;
        Student StuCnum = studentService.getStuCnumberById(Snumber);
        ObjectMapper mapper = new ObjectMapper();
        try {
            StuInfo=mapper.writeValueAsString(StuCnum);
        }catch (IOException e){
            e.printStackTrace();
            return "[]";
        }
        return StuInfo;
    }

    @RequestMapping(value = "/changeStuClass.do",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String changeStuClass(String Snumber,int Cnumber){

        String res = "修改失败";
        int row = studentService.changeStuClass(Snumber,Cnumber);
        if (row>0){
            res="修改成功";
        }
        return res;
    }

    @RequestMapping(value = "/changeStuGroup.do",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String changeStuGroup(String Snumber,int Gnumber){

        String res = "修改失败";
        int row = studentService.changeStuGroup(Snumber,Gnumber);
        if (row>0){
            res="修改成功";
        }
        return res;
    }

    @RequestMapping(value = "/selectStuByClassId.do",produces = "text/html;charset=UTF-8")
    public @ResponseBody String selectStuByClassId(int Cnumber,HttpServletResponse response){
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String jStuInfo;
        List<Student> lStuInfo = studentService.getStuByClassId(Cnumber);
        ObjectMapper mapper = new ObjectMapper();
        try {
            jStuInfo=mapper.writeValueAsString(lStuInfo);
        }catch (IOException e){
            e.printStackTrace();
            return "[]";
        }
        return jStuInfo;
    }

    @RequestMapping(value = "/findStuByIdOrName.do",produces = "text/html;charset=UTF-8")
    public @ResponseBody String findStuByIdOrName(String SnumOrSname,HttpServletResponse response){
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String jStuInfo;
        List<Student> lStuInfo = studentService.getStuByIdOrName(SnumOrSname);
        ObjectMapper mapper = new ObjectMapper();
        try {
            jStuInfo=mapper.writeValueAsString(lStuInfo);
        }catch (IOException e){
            e.printStackTrace();
            return "[]";
        }
        return jStuInfo;
    }
}
