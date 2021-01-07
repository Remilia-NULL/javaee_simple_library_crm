package com.library.Web.Servlet.Admin;

import com.library.Domain.AdminUser;
import com.library.Service.AdminUserService;
import com.library.Service.impl.AdminImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AdminLoginCheck extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminUserService admin = new AdminImpl();
        String username = req.getParameter("username");
        String passwd = req.getParameter("passwd");

        AdminUser adminUser = admin.checkAdminLogin(username, passwd);
        if (adminUser != null) {
            req.getSession().setAttribute("ADMIN_USER", adminUser);
            resp.sendRedirect("/Admin/AdminPage.html");
        } else {
            String temp = "账号或密码错误！";
            req.setAttribute("msg", temp);
            req.getRequestDispatcher("/root/login.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
