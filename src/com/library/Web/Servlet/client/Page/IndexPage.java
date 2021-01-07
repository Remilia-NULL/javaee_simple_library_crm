package com.library.Web.Servlet.client.Page;

import com.library.Domain.BookData;
import com.library.Domain.NormalUser;
import com.library.Service.BookDataService;
import com.library.Service.impl.BookDataImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class IndexPage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDataService bookData = new BookDataImpl();
        List<BookData> list = bookData.findAllBook();
        req.setAttribute("BookData", list);
        NormalUser normalUser = (NormalUser) req.getSession().getAttribute("USER_DATA");
        req.setAttribute("USER_DATA", normalUser);
        req.getRequestDispatcher("/client/index.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
