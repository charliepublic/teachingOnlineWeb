package com.aneon.controller;

import com.aneon.po.TeachPlan;
import com.aneon.service.TeachPlanService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class TeachPlanController {
    @Autowired
    TeachPlanService teachPlanService;

    @RequestMapping(value = "/loadPlan.do", produces = "text/html;charset=UTF-8")
    public @ResponseBody String loadPlan(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String jTeachPlans;
        List<TeachPlan> lTeachPlan = teachPlanService.getAllTeachPlan();
        ObjectMapper mapper = new ObjectMapper();
        try {
            jTeachPlans = mapper.writeValueAsString(lTeachPlan);
        } catch (IOException e) {
            e.printStackTrace();
            return "[]";
        }
        return jTeachPlans;
    }
}
