package com.aneon.mapper;
import com.aneon.po.Project;
import com.aneon.po.Teacher_file_lib;

import java.util.List;
import java.util.Map;

public interface ProjectMapper {
    boolean deleteProject(Map delete);
    boolean updateProject(int Pnumber);
    boolean updateUnpassProject(int Pnumber);
    List<Project> selectProject(Map search);
    List<Project> getAllProject();
    List<Project> getAllPassProject();
    List<Project> getAllUnpassProject();

    boolean updateProjectInfo(Map change);
    boolean newProject(Map newproject);

    List<Teacher_file_lib> getProjectFileUrl(Map projectFile);
}
