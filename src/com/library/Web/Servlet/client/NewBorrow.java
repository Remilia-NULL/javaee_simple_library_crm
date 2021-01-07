package com.library.Web.Servlet.client;

import com.library.Domain.BorrowData;
import com.library.Domain.NormalUser;
import com.library.Service.BookDataService;
import com.library.Service.BorrowService;
import com.library.Service.impl.BookDataImpl;
import com.library.Service.impl.BorrowImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewBorrow extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDataService bookData = new BookDataImpl();
        NormalUser normalUser = (NormalUser) req.getSession().getAttribute("USER_DATA");
        String uuid = req.getParameter("uuid");
        String id = req.getParameter("id");
        if (normalUser == null) {
            resp.setHeader("Refresh", "5;/client/login.html");
            resp.getWriter().print("您还没有登入，5秒后跳转至登入界面！");
            return;
        }
        BorrowData borrowData = new BorrowData();
        borrowData.setBook_uuid(uuid);
        borrowData.setUser_uuid(normalUser.getNor_uuid());
        borrowData.setBook_static(1);
        BorrowService borrow = new BorrowImpl();
        borrow.addBorrow(borrowData);
        if (Integer.parseInt(id) != 0) {
            bookData.outBook(Integer.parseInt(id), uuid);
            resp.sendRedirect("/client/userborrow.html");
        } else {
            resp.setHeader("Refresh", "5;/client/userborrow.html");
            resp.getWriter().print("抱歉没有存量了！");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
