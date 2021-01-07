package com.library.Web.Filter;

import com.library.Domain.AdminUser;
import com.library.Domain.NormalUser;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 拦截非管理员用户进入管理界面，统一重定向到404页面。
* */
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String path = request.getServletPath();
        AdminUser adminUser = (AdminUser) request.getSession().getAttribute("ADMIN_USER");
        if (path.indexOf("/Admin/login") == 0) {
            chain.doFilter(request, response);
            return;
        } else {
            if (adminUser != null) {
                chain.doFilter(request, response);
                return;
            }
            response.sendRedirect("/ERROR/404.html");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
