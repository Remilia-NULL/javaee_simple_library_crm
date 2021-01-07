package com.library.Web.Servlet.Admin.EditData;

import com.library.Domain.BookData;
import com.library.Domain.NormalUser;
import com.library.Service.AdminUserService;
import com.library.Service.impl.AdminImpl;
import com.library.Utils.MD5Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class EditUserIn extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NormalUser normalUser = new NormalUser();
        AdminUserService admin = new AdminImpl();
        normalUser.setNor_uuid(req.getParameter("uuid"));
        normalUser.setNor_name(req.getParameter("name"));
        normalUser.setNor_password(MD5Utils.encode(req.getParameter("password")));
        normalUser.setNor_email(req.getParameter("email"));
        normalUser.setNor_static(Integer.parseInt(req.getParameter("static")));

        admin.updateUser(normalUser);

        resp.sendRedirect("/Admin/AdminPage.html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
