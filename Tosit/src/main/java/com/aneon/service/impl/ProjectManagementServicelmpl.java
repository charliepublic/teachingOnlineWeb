package com.aneon.service.Impl;

import com.aneon.mapper.ProjectMapper;
import com.aneon.po.Project;
import com.aneon.po.Teacher;
import com.aneon.po.Teacher_file_lib;
import com.aneon.service.ProjectManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectManagementServicelmpl implements ProjectManagementService {



    @Autowired
    ProjectMapper projectMapper;

    @Override
    public List<Project> getAllPassProject() {

        List<Project> result = new ArrayList<>();

        List<Project> projects = projectMapper.getAllPassProject();

        if(projects!=null){
            for (Project project : projects){
                result.add(new Project(project.getPnumber(),project.getPname(),project.getUpTime(),project.getInfo()));
            }
            return result;
        }
        return null;
    }

    @Override
    public List<Project> getAllUnpassProject() {

        List<Project> result = new ArrayList<>();

        List<Project> projects = projectMapper.getAllUnpassProject();

        if (projects != null) {
            for (Project project : projects) {
                result.add(new Project(project.getPnumber(), project.getPname(), project.getUpTime(), project.getInfo()));
            }
            return result;
        }
        return null;

    }

    @Override
    public List<Project> getSearchProject(String projectName) {

        List<Project> result = new ArrayList<>();
        Map<String,Object> search = new HashMap<>();
        search.put("projectname",projectName);
        List<Project> projects = projectMapper.selectProject(search);

        if (projects != null) {
            for (Project project : projects) {
                result.add(new Project(project.getPnumber(), project.getPname(), project.getUpTime(), project.getInfo()));
            }
            return result;
        }
        return null;

    }

    @Override
    public boolean acceptUpdata(int projectnumber) {
        if (projectMapper.updateProject(projectnumber)) {
            return true;
        }
        ;
        return false;
    }

    @Override
    public boolean rejectUpdata(int projectnumber) {
        if (projectMapper.updateUnpassProject(projectnumber)) {
            return true;
        }

        return false;
    }

    @Override
    public boolean updataInfo(String projectInfo,int projectnumber) {
        Map<String,Object> change = new HashMap<>();
        change.put("projectInfo",projectInfo);
        change.put("projectnumber",projectnumber);
        if (projectMapper.updateProjectInfo(change)){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteproject(int projectnumber) {
        Map<String,Object> delete = new HashMap<>();
        delete.put("projectnumber",projectnumber);
        if (projectMapper.deleteProject(delete)){
            return true;
        }
        return false;
    }

    @Override
    public boolean newProject(String projectName, int projectUptime, String projectInfo) {
        Map<String,Object> newproject = new HashMap<>();
        newproject.put("projectname",projectName);
        newproject.put("projectuptime",projectUptime);
        newproject.put("projectinfo",projectInfo);
        if (projectMapper.newProject(newproject)){
            return true;
        }
        return false;
    }

    @Override
    public List<Teacher_file_lib> getProjectFile(Integer projectnumber) {

        List<Teacher_file_lib> result = new ArrayList<>();
        Map<String,Object> projectFile = new HashMap<>();
        projectFile.put("projectnumber",projectnumber);
        List<Teacher_file_lib> teacher_file_libs = projectMapper.getProjectFileUrl(projectFile);
        if (teacher_file_libs != null)
            for (Teacher_file_lib teacher_file_lib :teacher_file_libs){
                result.add(new Teacher_file_lib(teacher_file_lib.getFilename(),teacher_file_lib.getFurl(),teacher_file_lib.getTnumber(),teacher_file_lib.getPnumber(),teacher_file_lib.getDetail()));
                return result;
        }
        return null;

    }


}
