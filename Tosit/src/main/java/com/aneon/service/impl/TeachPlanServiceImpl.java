package com.aneon.service.Impl;

import com.aneon.mapper.TeacherMapper;
import com.aneon.po.TeachPlan;
import com.aneon.po.Teacher;
import com.aneon.service.TeachPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeachPlanServiceImpl implements TeachPlanService {
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public List<TeachPlan> getAllTeachPlan() {
        List<TeachPlan> teachPlans = new ArrayList<>();
        List<Teacher> teachers = teacherMapper.getAllTeachers();
        if(teachers != null) {
            String planName;
            for (Teacher teacher: teachers) {
                if(teacher.getTeachFile() != null) {
                    String temp[] = teacher.getTeachFile().split("/");
//                    StringTokenizer tz = new StringTokenizer(teacher.getTeachFile(), "\\");
//                    int i = 0;
//                    while (i < tz.countTokens() - 1)
//                        tz.nextToken();
//                    planName = tz.nextToken();
                    planName = temp[temp.length - 1];
                    teachPlans.add(new TeachPlan(teacher.getUsername(), planName, teacher.getName(), teacher.getTeachFile()));
                }
            }
            return teachPlans;
        }
        return null;
    }

    @Override
    public int updatePlan(String username, String url) {
        Map<String ,Object> plan = new HashMap<>();
        plan.put("username", username);
        plan.put("url", url);
        return teacherMapper.updatePlan(plan);
    }

    @Override
    public int deletePlan(String id) {
        Map<String, Object> delete = new HashMap<>();
        delete.put("username", id);
        return teacherMapper.deletePlan(delete);
    }
}
