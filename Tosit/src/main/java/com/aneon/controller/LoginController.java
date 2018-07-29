package com.aneon.controller;

import com.aneon.po.User;

import com.aneon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/loginAction.do")
    public ModelAndView login(String zh, String mm, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.login(zh, mm);
        HttpSession session = request.getSession();
        if(user != null) {
            session.setAttribute("User", user);
            session.removeAttribute("CorrectUser");
            try {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else {
            session.setAttribute("CorrectUser", "false");
            try {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } catch (IOException | ServletException e) {
                e.printStackTrace();
            }
        }
        return modelAndView;
    }
}
