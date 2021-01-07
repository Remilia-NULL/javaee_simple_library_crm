package com.library.Web.Servlet.Admin.Page;

import com.library.Domain.BookData;
import com.library.Utils.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddBookPage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookData bookData = new BookData();
        bookData.setBook_uuid(UUIDUtils.make());
        req.setAttribute("BookData", bookData);
        req.getRequestDispatcher("/root/addbook.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
