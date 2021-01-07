package com.library.DAO;

import com.library.Domain.AdminUser;
import com.library.Domain.BookData;
import com.library.Domain.BorrowData;
import com.library.Domain.NormalUser;
import com.library.Utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AdminUserDAO {
    private QueryRunner queryRunner = new QueryRunner(DBUtils.getConnect());

    //用户登入检查
    public AdminUser checkAdminLogin(String userName, String passWord) throws SQLException {
        AdminUser data = queryRunner.query("SELECT * FROM admin_user WHERE admin_name=? AND admin_password=?", new BeanHandler<>(AdminUser.class), new Object[]{userName, passWord});
        return data;
    }

    //得到所有用户
    public List<NormalUser> findAllUser() throws SQLException {
        List<NormalUser> data = queryRunner.query("SELECT * FROM normal_user",
                new BeanListHandler<>(NormalUser.class));
        return data;
    }

    //删除指定UUID的用户
    public boolean deleteUser(String data) throws SQLException {
        int temp = queryRunner.update("DELETE FROM normal_user WHERE nor_uuid = ?", data);
        return temp > 0;
    }

    //得到所有书籍的信息
    public List<BookData> findAllBook() throws SQLException {
        List<BookData> data = queryRunner.query("SELECT * FROM book_data", new BeanListHandler<>(BookData.class));
        return data;
    }

    //根据UUID查询书籍信息
    public BookData findBook(String uuid) throws SQLException {
        BookData bookData = queryRunner.query("SELECT * FROM book_data WHERE book_uuid = ?", new BeanHandler<>(BookData.class), new Object[]{uuid});
        return bookData;
    }

    //修改书籍信息
    public boolean updateBook(BookData bookData) throws SQLException {
        int temp = queryRunner.update("UPDATE `book_data` SET `book_name` = ?, `book_author` = ?, `book_isbn` = ?, `book_price` = ?, `book_remarks` = ?, `book_static` = ?, `book_remsining` = ? WHERE `book_data`.`book_uuid` = ?;"
                , new Object[]{bookData.getBook_name(), bookData.getBook_author(), bookData.getBook_isbn(), bookData.getBook_price(), bookData.getBook_remarks(), bookData.getBook_static(), bookData.getBook_remsining(), bookData.getBook_uuid()
                });
        return temp > 0;
    }

    //根据uuid删除书籍
    public boolean deleteBook(String uuid) throws SQLException {
        int temp = queryRunner.update("DELETE FROM book_data WHERE book_uuid = ?", uuid);
        return temp > 0;
    }

    //添加书籍
    public boolean addBook(BookData bookData) throws SQLException {
        int temp = queryRunner.update("INSERT INTO `book_data` (`book_uuid`, `book_name`, `book_author`, `book_isbn`, `book_price`, `book_remarks`, `book_static`, `book_remsining`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);"
                , new Object[]{bookData.getBook_uuid(), bookData.getBook_name(), bookData.getBook_author(), bookData.getBook_isbn()
                        , bookData.getBook_price(), bookData.getBook_remarks(), bookData.getBook_static(),
                        bookData.getBook_remsining()});
        return temp > 0;
    }

    //得到所有订单信息
    public List<BorrowData> findAllBorrow() throws SQLException {
        List<BorrowData> data = queryRunner.query("SELECT * FROM borrow_data", new BeanListHandler<>(BorrowData.class));
        return data;
    }

    //根据UUID查询用户
    public NormalUser findUser(String id) throws SQLException {
        NormalUser normalUser = queryRunner.query("SELECT * FROM normal_user WHERE nor_uuid = ?", new BeanHandler<>(NormalUser.class), new Object[]{id});
        return normalUser;
    }

    //更新用户信息
    public boolean updateUser(NormalUser normalUser) throws SQLException {
        int temp = queryRunner.update("UPDATE normal_user SET nor_uuid=?,nor_name=?,nor_password=?,nor_email=?,nor_static=? WHERE nor_uuid=?"
                , new Object[]{normalUser.getNor_uuid(), normalUser.getNor_name(), normalUser.getNor_password(),
                        normalUser.getNor_email(), normalUser.getNor_static(), normalUser.getNor_uuid()
                });
        return temp > 0;
    }

    //添加用户
    public boolean addUser(NormalUser normalUser) throws SQLException {
        int temp = queryRunner.update("INSERT INTO normal_user (`nor_uuid`, `nor_name`, `nor_password`, `nor_email`, `nor_static`) VALUES (?, ?, ?, ?, ?)"
                , new Object[]{normalUser.getNor_uuid(), normalUser.getNor_name(), normalUser.getNor_password(),
                        normalUser.getNor_email(), normalUser.getNor_static()});
        return temp > 0;
    }
}
