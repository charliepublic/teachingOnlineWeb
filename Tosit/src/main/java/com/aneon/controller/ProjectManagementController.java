package com.aneon.controller;

import com.aneon.po.Project;
import com.aneon.po.Teacher_file_lib;
import com.aneon.service.ProjectManagementService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProjectManagementController {


    @Autowired
    ProjectManagementService projectManagementService;

    @RequestMapping(value = "/loadProjectDisplay", produces = "text/html;charset=UTF-8")
    public @ResponseBody String loadprojectdisplay(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String jprojects;
        List<Project> lProject = projectManagementService.getAllPassProject();
        ObjectMapper mapper = new ObjectMapper();
        try {
            jprojects = mapper.writeValueAsString(lProject);
        } catch (IOException e) {
            e.printStackTrace();
            return "[]";
        }
        return jprojects;
    }


    @RequestMapping(value = "/loadApplyManagement.do", produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String loadApplyprojectdisplay(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String jprojects;
        List<Project> lProject = projectManagementService.getAllUnpassProject();
        ObjectMapper mapper = new ObjectMapper();
        try {
            jprojects = mapper.writeValueAsString(lProject);
        } catch (IOException e) {
            e.printStackTrace();
            return "[]";
        }
        return jprojects;
    }

    @RequestMapping(value = "/acceptApply.do", produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String acceptApply(int projectnumber) {


        String res = "申请失败";
        if (projectManagementService.acceptUpdata(projectnumber))
            res = "申请成功";
        return res;
    }

    @RequestMapping(value = "/rejectApply.do", produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String rejectApply(int projectnumber) {
        String res = "申请失败";
        if (projectManagementService.rejectUpdata(projectnumber))
            res = "申请成功";
        return res;
    }

    @RequestMapping(value = "/changeSubmit.do", produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String changeSubmit(String projectInfo,int projectnumber) {
        String res = "修改失败";

        if (projectManagementService.updataInfo(projectInfo,projectnumber))
            res = "修改成功";
        return res;
    }

    @RequestMapping(value = "/deleteProject.do", produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String deleteProject(int projectnumber) {
        String res = "删除失败";
        if (projectManagementService.deleteproject(projectnumber))
            res = "删除成功";
        return res;
    }

    @RequestMapping(value = "/newProject.do", produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String newProject(String projectName,int projectUptime,String projectInfo) {
        String res = "新建项目失败";
        if (projectManagementService.newProject(projectName,projectUptime,projectInfo))
            res = "新建项目成功";
        return res;
    }


    @RequestMapping(value = "/searchProject.do", produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String searchProject(String projectName,HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String jprojects;
        List<Project> lProject = projectManagementService.getSearchProject(projectName);
        ObjectMapper mapper = new ObjectMapper();
        try {
            jprojects = mapper.writeValueAsString(lProject);
        } catch (IOException e) {
            e.printStackTrace();
            return "[]";
        }
        return jprojects;
    }

    @RequestMapping(value = "/getFileUrl.do", produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String getFileUrl(Integer projectnumber,HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String jprojectfiles;
        List<Teacher_file_lib> lProjectfile = projectManagementService.getProjectFile(projectnumber);
        ObjectMapper mapper = new ObjectMapper();
        try {
            jprojectfiles = mapper.writeValueAsString(lProjectfile);
        } catch (IOException e) {
            e.printStackTrace();
            return "[]";
        }
        return jprojectfiles;
    }

}