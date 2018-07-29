package com.aneon.controller;

import com.aneon.po.TeachPlan;
import com.aneon.po.User;
import com.aneon.service.TeachPlanService;
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
        String result = "上传失败";
        User user = (User)session.getAttribute("User");

        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            // 获取上传的文件
            Map<String, MultipartFile> fileMap = multipartHttpServletRequest.getFileMap();
            for(Map.Entry<String, MultipartFile> entry : fileMap.entrySet()){
                // 对文件进处理
                MultipartFile multipartFile = entry.getValue();
                if (multipartFile != null) {
                    String path = request.getServletContext().getRealPath("/files/teachPlan") + "\\" + user.getUsername();
                    String filePath = path + "\\" + multipartFile.getOriginalFilename();
                    File dir = new File(path);
                    if (!dir.exists())
                        dir.mkdirs();
                    File file = new File(filePath);
                    if (file.exists())
                        file.delete();
                    try {
                        file.createNewFile();
                        multipartFile.transferTo(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    int test = teachPlanService.updatePlan(user.getUsername(), "\\files\\teachPlan\\" + user.getUsername() + "\\" + multipartFile.getOriginalFilename());
                    if (test == 1) {
                        result = "教学计划创建成功！！";
                    }
                }
            }
        }
        return result;
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
