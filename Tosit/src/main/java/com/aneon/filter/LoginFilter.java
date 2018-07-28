package com.aneon.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        HttpServletResponse httpServletResponse = (HttpServletResponse)response;
        String url = httpServletRequest.getRequestURL().toString();

        if(url.contains("/index.jsp") || url.contains("/loginAction.do") || url.contains("/resources/")) {
            chain.doFilter(request, response);
            return;
        }

        if(httpServletRequest.getSession().getAttribute("User") == null) {
            httpServletResponse.sendRedirect("/index.jsp");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
