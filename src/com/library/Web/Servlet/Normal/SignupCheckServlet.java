package com.library.Web.Servlet.Normal;

import com.library.Domain.NormalUser;
import com.library.Service.UserService;
import com.library.Service.impl.UserImpl;
import com.library.Utils.MD5Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignupCheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NormalUser normalUser = new NormalUser();
        UserService user = new UserImpl();
        String username = req.getParameter("username");
        String passwd = req.getParameter("passwd");
        String email = req.getParameter("email");
        normalUser.setNor_name(username);
        normalUser.setNor_password(MD5Utils.encode(passwd));
        normalUser.setNor_email(email);
        if (user.addNormalUser(normalUser)) {
            resp.sendRedirect("/client/login.html");
        } else {
            resp.setHeader("Refresh", "5;/client/signup.html");
            resp.getWriter().print("ERROR!");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
