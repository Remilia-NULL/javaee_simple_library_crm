package com.library.Web.Servlet.client.Page;

import com.library.Domain.BorrowData;
import com.library.Domain.NormalUser;
import com.library.Service.BorrowService;
import com.library.Service.impl.BorrowImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserBorrowPage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NormalUser normalUser = (NormalUser) req.getSession().getAttribute("USER_DATA");
        if (normalUser == null) {
            resp.sendRedirect("/client/login.html");
            return;
        }
        BorrowService borrow = new BorrowImpl();
        List<BorrowData> data = borrow.findBorrowByUser(normalUser.getNor_uuid());
        req.setAttribute("Borrow_Data", data);
        req.getRequestDispatcher("/client/userborrow.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
