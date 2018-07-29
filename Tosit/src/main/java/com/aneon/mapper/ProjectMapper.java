package com.aneon.mapper;
import com.aneon.po.Project;

import java.util.List;

public interface ProjectMapper {
    boolean addProject(Project project);
    boolean deleteProject(String Pnumber);
    boolean updateProject(Project project);
    Project selectProject(String Pnumber);
    List<Project> getAllProject();

}
