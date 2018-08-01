package com.aneon.controller;

import com.aneon.po.TeachPlan;
import com.aneon.po.User;
import com.aneon.service.TeachPlanService;
import com.aneon.utils.FileUtils;
import org.apache.commons.fileupload.MultipartStream;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class TeachPlanController {
    @Autowired
    TeachPlanService teachPlanService;

    @RequestMapping("/loadPlan.do")
    public @ResponseBody String loadPlan(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String jTeachPlans;
        List<TeachPlan> lTeachPlan = teachPlanService.getAllTeachPlan();
        ObjectMapper mapper = new ObjectMapper();
        try {
            jTeachPlans = mapper.writeValueAsString(lTeachPlan);
        } catch (IOException e) {
            e.printStackTrace();
            return "[]";
        }
        return jTeachPlans;
    }

    @RequestMapping("/createPlan.do")
    @ResponseBody
    public String createPlan(HttpServletRequest request, HttpSession session) {
        User user = (User)session.getAttribute("User");
        String teachPlan = FileUtils.fileUpload(request, session, "/files/teachPlan");
        if(!teachPlan.equals(""))
            if(teachPlanService.updatePlan(user.getUsername(), teachPlan) == 1)
                return "教学计划创建成功！";
        return "上传失败！";
    }

    @RequestMapping("/deletePlan.do")
    @ResponseBody
    public String deletePlan(String id) {
        String result = "删除失败！";
        if(teachPlanService.deletePlan(id) == 1) {
            result = "删除成功！";
        }
        return result;
    }
}
