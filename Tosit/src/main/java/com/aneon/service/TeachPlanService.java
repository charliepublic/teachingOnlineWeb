package com.aneon.service;

import com.aneon.po.TeachPlan;

import java.util.List;

public interface TeachPlanService {
    List<TeachPlan> getAllTeachPlan();
    int updatePlan(String username, String url);
    int deletePlan(String id);
}
