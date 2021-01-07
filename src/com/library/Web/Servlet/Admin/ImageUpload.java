package com.library.Web.Servlet.Admin;

import com.library.Domain.BookData;
import com.library.Utils.FileUploadUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class ImageUpload extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String value = "";
            BookData bookData = new BookData();
            DiskFileItemFactory factory = new DiskFileItemFactory();
            File file = new File(FileUploadUtils.uploadPath());
            if (!file.exists()) {
                file.mkdirs();
            }
            factory.setRepository(file);
            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            fileUpload.setHeaderEncoding("utf-8");
            List<FileItem> fileItems = fileUpload.parseRequest(req);
            PrintWriter writer = resp.getWriter();
            for (FileItem fileItem : fileItems) {
                String filename = fileItem.getName();
                if (fileItem.isFormField()) {
                    String uuid = fileItem.getFieldName();
                    if (uuid.equals("uuid")) {
                        if (!fileItem.getString().equals("")) {
                            value = fileItem.getString("utf-8");
                        }
                    }
                } else {
                    String filename1 = fileItem.getName();
                    if (filename1 != null && !filename1.equals("")) {
                        filename1 = value + ".png";
                        String webUrl = "/productImg/";
                        String filePath = getServletContext().getRealPath(webUrl + filename1);
                        File file1 = new File(filePath);
                        file1.getParentFile().mkdirs();
                        file1.createNewFile();

                        InputStream inputStream = fileItem.getInputStream();
                        FileOutputStream fileOutputStream = new FileOutputStream(file1);

                        byte buffer[] = new byte[1024];
                        int len;
                        while ((len = inputStream.read(buffer)) > 0) {
                            fileOutputStream.write(buffer, 0, len);
                        }
                        inputStream.close();
                        fileOutputStream.close();
                        fileItem.delete();
                    }
                }

            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/Admin/editbook.html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
