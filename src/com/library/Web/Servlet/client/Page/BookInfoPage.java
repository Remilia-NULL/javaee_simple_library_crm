package com.library.Web.Servlet.client.Page;

import com.library.Domain.BookData;
import com.library.Service.BookDataService;
import com.library.Service.impl.BookDataImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookInfoPage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDataService bookData = new BookDataImpl();
        String uuid = req.getParameter("uuid");
        BookData bookData1 = bookData.findBook(uuid);
        req.setAttribute("BootData", bookData1);
        req.getRequestDispatcher("/client/bookinfo.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
