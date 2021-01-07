package com.library.Web.Servlet.Admin;

import com.library.Domain.BookData;
import com.library.Service.AdminUserService;
import com.library.Service.impl.AdminImpl;
import com.library.Utils.UUIDUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class AddBook extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookData bookData = new BookData();
        AdminUserService admin = new AdminImpl();
        bookData.setBook_name(req.getParameter("name"));
        bookData.setBook_isbn(req.getParameter("isbn"));
        bookData.setBook_price(req.getParameter("price"));
        bookData.setBook_author(req.getParameter("author"));
        bookData.setBook_remarks(req.getParameter("remarks"));
        bookData.setBook_uuid(req.getParameter("uuid"));
        String bookstatic = req.getParameter("bookstatic");
        String remsining = req.getParameter("remsining");
        bookData.setBook_static(Integer.parseInt(bookstatic));
        bookData.setBook_remsining(Integer.parseInt(remsining));
        admin.addBook(bookData);

        resp.sendRedirect("/Admin/imageuploadpage.html?uuid=" + bookData.getBook_uuid());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
