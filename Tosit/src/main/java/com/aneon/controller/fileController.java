package com.aneon.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.aneon.service.*;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.aneon.po.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class fileController {
    @Autowired
    fileService fileService;

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

    @RequestMapping(value = "/onDelete.do", produces = "text/html;charset=UTF-8")
    public  @ResponseBody
    void deleteFiles(String furl,HttpServletResponse response,HttpSession httpSession){
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        User user = (User)httpSession.getAttribute("User");
        String userName = user.getUsername();
        if(userName.length() == 10 || userName.length() == 12)
            fileService.deleteTeacherFileByFurl(furl);
        if(userName.length() == 14)
            fileService.deleteStudentFileByFurl(furl);
    }


    ///onChangeDetail.do
    @RequestMapping(value = "/onChangeDetail.do", produces = "text/html;charset=UTF-8")
    public  @ResponseBody
    void changeDetail(String furl,String newDetail,HttpServletResponse response,HttpSession httpSession){
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        User user = (User)httpSession.getAttribute("User");
        String userName = user.getUsername();
        if(userName.length() == 10 || userName.length() == 12)
            fileService.updataTeacherFile(furl,newDetail);
        if(userName.length() == 14)
            fileService.updataStudentFile(furl,newDetail);

    }
}