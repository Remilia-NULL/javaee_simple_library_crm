package com.library.Service;

import com.library.Domain.NormalUser;

import java.sql.SQLException;

public interface UserService {
    NormalUser checkLogin(String userName, String passWd);

    boolean addNormalUser(NormalUser normalUser);

    boolean updateNormalUser(NormalUser normalUser);
}
