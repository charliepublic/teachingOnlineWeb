package com.aneon.mapper;

import com.aneon.po.Task;

import java.util.List;

public interface TaskMapper {
    int addTask(Task task);
    List<Task> getAllTask();
    Task getTaskByName(String TaskName);
    int deletTask(String TaskName);
    int updataTask(Task task);

}
