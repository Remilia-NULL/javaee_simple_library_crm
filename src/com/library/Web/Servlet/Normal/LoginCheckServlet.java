package com.library.Web.Servlet.Normal;

import com.library.Domain.NormalUser;
import com.library.Service.UserService;
import com.library.Service.impl.UserImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginCheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService user = new UserImpl();
        String username = req.getParameter("username");
        String passwd = req.getParameter("passwd");

        NormalUser normalUser = user.checkLogin(username, passwd);
        if (normalUser != null) {
            req.getSession().setAttribute("USER_DATA", normalUser);
            resp.sendRedirect("/client/index.html");
        } else {
            String temp = "账号或密码错误！";
            req.setAttribute("msg", temp);
            req.getRequestDispatcher("/normal/login.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
