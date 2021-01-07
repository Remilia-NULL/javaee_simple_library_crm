package com.library.Service.impl;

import com.library.DAO.BorrowBookDAO;
import com.library.Domain.BorrowData;
import com.library.Service.BorrowService;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BorrowImpl implements BorrowService {
    BorrowBookDAO borrowBookDAO = new BorrowBookDAO();
    BorrowData borrowData = new BorrowData();

    @Override
    public List<BorrowData> findAllBorrow() {
        try {
            return borrowBookDAO.findAllBorrow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BorrowData findBorrow(int id) {
        try {
            return borrowBookDAO.findBorrow(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addBorrow(BorrowData borrowData) {
        try {
            return borrowBookDAO.addBorrow(borrowData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editBorrowStatic(int id) {
        borrowData.setBorrow_id(id);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        borrowData.setIn_time(simpleDateFormat.format(new Date(System.currentTimeMillis())));
        try {
            return borrowBookDAO.editBorrowStatic(borrowData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<BorrowData> findBorrowByUser(String uuid) {
        try {
            return borrowBookDAO.findBorrowByUser(uuid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
