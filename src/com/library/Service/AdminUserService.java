package com.library.Service;

import com.library.Domain.AdminUser;
import com.library.Domain.BookData;
import com.library.Domain.NormalUser;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface AdminUserService {
    boolean addUser(NormalUser normalUser);

    boolean deleteUser(String id);

    boolean updateUser(NormalUser normalUser);

    List<NormalUser> findAllUser();

    NormalUser findUser(String id);

    AdminUser checkAdminLogin(String userName, String passWd);

    List<BookData> findAllBook();

    BookData findBook(String id);

    boolean updateBook(BookData bookData);

    boolean deleteBook(String uuid);

    boolean addBook(BookData bookData);
}
