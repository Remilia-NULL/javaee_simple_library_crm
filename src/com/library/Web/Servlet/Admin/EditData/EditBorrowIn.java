package com.library.Web.Servlet.Admin.EditData;

import com.library.Domain.BorrowData;
import com.library.Service.BorrowService;
import com.library.Service.impl.BorrowImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditBorrowIn extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BorrowService borrowImplb = new BorrowImpl();
        int id = Integer.parseInt(req.getParameter("id"));
        borrowImplb.editBorrowStatic(id);
        resp.sendRedirect("/Admin/borrow.html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
