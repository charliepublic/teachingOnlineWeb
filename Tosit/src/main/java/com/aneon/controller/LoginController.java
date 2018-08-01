package com.aneon.controller;

import com.aneon.po.User;

import com.aneon.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/loginAction.do")
    public @ResponseBody String login1(String zh, String mm, HttpServletRequest request) {
        String res = "登录失败";
        User user = loginService.login(zh, mm);
        HttpSession session = request.getSession();
        if(user != null) {
            res = user.getName();
            session.setAttribute("User", user);
        }
        return res;
    }


}
