package com.library.Web.Servlet.Admin.Page;

import com.library.Domain.AdminUser;
import com.library.Domain.NormalUser;
import com.library.Service.AdminUserService;
import com.library.Service.impl.AdminImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminPage extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminUser adminUser = (AdminUser) req.getSession().getAttribute("ADMIN_USER");
        AdminUserService admin = new AdminImpl();
        List<NormalUser> list = null;

        list = admin.findAllUser();

        req.setAttribute("sysUserSize", list.size());
        String userState = adminUser.getAdmin_static() == 1 ? "可用" : "不可用";
        req.setAttribute("userState", userState);
        req.setAttribute("sysList", list);
        req.getRequestDispatcher("/root/users.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
