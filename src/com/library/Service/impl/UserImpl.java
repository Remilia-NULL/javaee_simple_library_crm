package com.library.Service.impl;

import com.library.DAO.NormalUserDAO;
import com.library.Domain.NormalUser;
import com.library.Service.UserService;
import com.library.Utils.MD5Utils;
import com.library.Utils.UUIDUtils;

import java.sql.SQLException;

public class UserImpl implements UserService {
    private NormalUserDAO normalUserDAO = new NormalUserDAO();

    @Override
    public NormalUser checkLogin(String userName, String passWd) {
        try {
            return normalUserDAO.checkLogin(userName, MD5Utils.encode(passWd));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addNormalUser(NormalUser normalUser) {
        normalUser.setNor_uuid(UUIDUtils.make());
        normalUser.setNor_static(1);
        try {
            return normalUserDAO.addNewUser(normalUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateNormalUser(NormalUser normalUser) {
        try {
            return normalUserDAO.updateUser(normalUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
