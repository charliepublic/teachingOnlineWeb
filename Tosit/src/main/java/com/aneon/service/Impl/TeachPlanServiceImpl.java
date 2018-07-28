package com.aneon.service.Impl;

import com.aneon.mapper.TeacherMapper;
import com.aneon.po.TeachPlan;
import com.aneon.po.Teacher;
import com.aneon.service.TeachPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
                if(!teacher.getTeachFile().equals("")) {
                    StringTokenizer tz = new StringTokenizer(teacher.getTeachFile(), "/");
                    int i = 0;
                    while (i < tz.countTokens() - 1)
                        tz.nextToken();
                    planName = tz.nextToken();
                    teachPlans.add(new TeachPlan(planName, teacher.getName(), teacher.getTeachFile()));
                }
            }
            return teachPlans;
        }
        return null;
    }
}
