package com.aneon.mapper;
import com.aneon.po.Project;

import java.util.List;

public interface ProjectMapper {
    int addProject(Project project);
    int deleteProject(String Pnumber);
    int updateProject(Project project);
    Project selectProject(String Pnumber);
    List<Project> getAllProject();

}
