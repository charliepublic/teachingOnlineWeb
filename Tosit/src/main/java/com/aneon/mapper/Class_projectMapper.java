package com.aneon.mapper;

import com.aneon.po.*;

import java.util.List;

public interface Class_projectMapper {
    List<Class_project> getAllClass_project();
    List<Class_project> getProjetByClass(String Cnumber);
    List<Class_project> getClassByProject(String Pnumber);
    int addClass_project(Class_project class_project);
}