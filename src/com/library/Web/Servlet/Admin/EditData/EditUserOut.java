package com.library.Web.Servlet.Admin.EditData;

import com.library.Domain.NormalUser;
import com.library.Service.AdminUserService;
import com.library.Service.impl.AdminImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class EditUserOut extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data = req.getParameter("uuid");
        AdminUserService admin = new AdminImpl();

        NormalUser normalUser = admin.findUser(data);
        req.setAttribute("UserData", normalUser);

        req.getRequestDispatcher("/root/edituser.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
