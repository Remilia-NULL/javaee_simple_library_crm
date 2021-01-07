package com.library.Web.Servlet.client;

import com.library.Service.BorrowService;
import com.library.Service.impl.BorrowImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SetBookStatic extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int temp = Integer.parseInt(id);
        BorrowService borrow = new BorrowImpl();
        borrow.editBorrowStatic(temp);
        response.sendRedirect("/client/userborrow.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
