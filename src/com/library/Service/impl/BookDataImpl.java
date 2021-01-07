package com.library.Service.impl;

import com.library.DAO.BookDataDAO;
import com.library.Domain.BookData;
import com.library.Service.BookDataService;

import java.awt.print.Book;
import java.sql.SQLException;
import java.util.List;

public class BookDataImpl implements BookDataService {
    BookDataDAO bookDataDAO = new BookDataDAO();

    @Override
    public List<BookData> findAllBook() {
        try {
            return bookDataDAO.findAllBook();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BookData findBook(String uuid) {
        try {
            return bookDataDAO.findBook(uuid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean outBook(int id, String uuid) {
        try {
            return bookDataDAO.outBook(id, uuid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
