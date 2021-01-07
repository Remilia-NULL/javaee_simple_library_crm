package com.library.Service.impl;

import com.library.DAO.AdminUserDAO;
import com.library.Domain.AdminUser;
import com.library.Domain.BookData;
import com.library.Domain.NormalUser;
import com.library.Service.AdminUserService;
import com.library.Utils.MD5Utils;
import com.library.Utils.UUIDUtils;

import java.sql.SQLException;
import java.util.List;

public class AdminImpl implements AdminUserService {
    private AdminUserDAO adminUserDAO = new AdminUserDAO();

    @Override
    public boolean addUser(NormalUser normalUser) {
        normalUser.setNor_uuid(UUIDUtils.make());
        try {
            return adminUserDAO.addUser(normalUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUser(String id) {
        try {
            return adminUserDAO.deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUser(NormalUser normalUser) {
        try {
            return adminUserDAO.updateUser(normalUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<NormalUser> findAllUser() {
        try {
            return adminUserDAO.findAllUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public NormalUser findUser(String id) {
        try {
            return adminUserDAO.findUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AdminUser checkAdminLogin(String userName, String passWd) {
        try {
            return adminUserDAO.checkAdminLogin(userName, MD5Utils.encode(passWd));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<BookData> findAllBook() {
        try {
            return adminUserDAO.findAllBook();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BookData findBook(String id) {
        try {
            return adminUserDAO.findBook(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateBook(BookData bookData) {
        try {
            return adminUserDAO.updateBook(bookData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteBook(String uuid) {
        try {
            return adminUserDAO.deleteBook(uuid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addBook(BookData bookData) {
        try {
            return adminUserDAO.addBook(bookData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
