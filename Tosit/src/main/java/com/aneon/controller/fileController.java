package com.aneon.controller;

import com.aneon.po.Stu_file_lib;
import com.aneon.po.Teacher_file_lib;
import com.aneon.po.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class fileController {
    @Autowired
    com.aneon.service.fileService fileService;
    @RequestMapping(value = "/searchTeacherFile.do", produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String searchTeacherFile(String fileName,HttpServletResponse response ) {
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String jTeachFiles;
        List<Teacher_file_lib> lTeachFiles = fileService.findTeacherFileByName(fileName);
        ObjectMapper mapper = new ObjectMapper();
        try {
            jTeachFiles = mapper.writeValueAsString(lTeachFiles);
        } catch (IOException e) {
            e.printStackTrace();
            return "[]";
        }
        return jTeachFiles;
    }

    @RequestMapping(value = "/onLoad.do", produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String onLoadFile(HttpServletResponse response ,HttpSession httpSession) {
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String Files = null;
        List<Teacher_file_lib> lTeachFiles = null;
        List<Stu_file_lib> lStuFile = null;
        User user = (User)httpSession.getAttribute("User");
        String userName = user.getUsername();
        ObjectMapper mapper = new ObjectMapper();
        try {
            if(userName.length() == 10){
                lTeachFiles = fileService.getAllTeacherFile();
                Files = mapper.writeValueAsString(lTeachFiles);
            }else if (userName.length() == 12){
                lTeachFiles = fileService.getTeacherFileByTnumber(userName);
                Files = mapper.writeValueAsString(lTeachFiles);
            }else  if (userName.length() == 14){
                lStuFile = fileService.getStudentFileBySnumber(userName);
                Files = mapper.writeValueAsString(lStuFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "[]";
        }
        return Files;
    }
}
