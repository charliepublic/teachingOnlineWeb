package com.aneon.service;

import com.aneon.po.Project;
import com.aneon.po.Teacher_file_lib;

import java.util.List;

public interface ProjectManagementService {

    List<Project> getAllPassProject();

    List<Project> getAllUnpassProject();

    List<Project> getSearchProject(String projectName);

    boolean acceptUpdata(int projectnumber);

    boolean rejectUpdata(int projectnumber);

    boolean updataInfo(String projectInfo,int projectnumber);

    boolean deleteproject(int projectnumber);

    boolean newProject(String projectName, int projectUptime, String projectInfo);

    List<Teacher_file_lib> getProjectFile(Integer projectnumber);
}
