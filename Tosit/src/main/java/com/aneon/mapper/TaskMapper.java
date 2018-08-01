package com.aneon.mapper;

import com.aneon.po.Task;

import java.util.List;

public interface TaskMapper {
    boolean addTask(Task task);
    List<Task> getAllTask();
    Task getTaskByName(String TaskName);
    boolean deletTask(String TaskName);
    boolean updataTask(Task task);

}
