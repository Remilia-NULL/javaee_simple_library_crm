package com.library.Web.Servlet.Admin.Page;

import com.library.Domain.BorrowData;
import com.library.Service.BorrowService;
import com.library.Service.impl.BorrowImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BorrowBookPage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BorrowService borrow = new BorrowImpl();
        List<BorrowData> data = borrow.findAllBorrow();
        req.setAttribute("BorrowList", data);
        req.setAttribute("size", data.size());
        req.getRequestDispatcher("/root/borrow.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
