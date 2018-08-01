package com.aneon.controller;

import com.aneon.po.Class;
import com.aneon.service.ClassService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class ClassController {
    @Autowired
    ClassService classService;

    @RequestMapping(value = "/addClass.do",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String addClass(String Cname,HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        Class cls=new Class(Cname);
        String res = "添加失败";

        int row = classService.moreClass(cls);
        if (row>0){
            res="添加成功";
        }
       return res;
    }

    @RequestMapping(value = "/changeClass.do",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String changeClass(int Cnumber,String Cname,HttpServletResponse response){
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        Class cls = new Class(Cnumber,Cname);
        /*Class cls = (Class) session.getAttribute("Class");*/
        String res = "修改失败";

        int row = classService.changeClass(cls);
        if (row>0){
            res="修改成功";
        }
        return res;

    }

    @RequestMapping(value = "/removeClass.do",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String removeClass(int Cnumber){
        String res = "删除失败";
        if(classService.remoClass(Cnumber)==1){
            res="删除成功";
        }
        return res;
    }


    @RequestMapping(value="/AllClass.do",produces = "text/html;charset=UTF-8")
    public @ResponseBody String AllStudent(HttpServletResponse response){
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String jCls;
        List<Class> lClsInfo=classService.qureyAllClass();
        ObjectMapper mapper = new ObjectMapper();
        try {
            jCls=mapper.writeValueAsString(lClsInfo);
        }catch (IOException e){
            e.printStackTrace();
            return "[]";
        }
        return jCls;
    }

    @RequestMapping(value="/getCnumberForG.do",produces = "text/html;charset=UTF-8")
    public @ResponseBody String getCnumberForG(HttpServletResponse response){
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String jCnum;
        List<Class> lCnum=classService.getClassId();
        ObjectMapper mapper = new ObjectMapper();
        try {
            jCnum=mapper.writeValueAsString(lCnum);
        }catch (IOException e){
            e.printStackTrace();
            return "[]";
        }
        return jCnum;
    }

    @RequestMapping(value="/findClassById.do",produces = "text/html;charset=UTF-8")
    public @ResponseBody String findClassById(int Cnumber,HttpServletResponse response){
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String jCls;
        List<Class> lCls=classService.getClassById(Cnumber);
        ObjectMapper mapper = new ObjectMapper();
        try {
            jCls=mapper.writeValueAsString(lCls);
        }catch (IOException e){
            e.printStackTrace();
            return "[]";
        }
        return jCls;
    }
}
