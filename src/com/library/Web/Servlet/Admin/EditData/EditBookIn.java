package com.library.Web.Servlet.Admin.EditData;

import com.library.Domain.BookData;
import com.library.Service.AdminUserService;
import com.library.Service.impl.AdminImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class EditBookIn extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookData bookData = new BookData();
        AdminUserService admin = new AdminImpl();
        bookData.setBook_uuid(req.getParameter("uuid"));
        bookData.setBook_name(req.getParameter("name"));
        bookData.setBook_isbn(req.getParameter("isbn"));
        bookData.setBook_author(req.getParameter("author"));
        bookData.setBook_price(req.getParameter("price"));
        bookData.setBook_remarks(req.getParameter("remarks"));
        bookData.setBook_static(Integer.parseInt(req.getParameter("bookstatic")));
        bookData.setBook_remsining(Integer.parseInt(req.getParameter("remsining")));
        admin.updateBook(bookData);
        resp.sendRedirect("/Admin/imageuploadpage.html?uuid=" + bookData.getBook_uuid());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
