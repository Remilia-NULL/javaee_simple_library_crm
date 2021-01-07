package com.library.DAO;

import com.library.Domain.BookData;
import com.library.Utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDataDAO {
    private QueryRunner queryRunner = new QueryRunner(DBUtils.getConnect());

    public List<BookData> findAllBook() throws SQLException {
        String sql = "SELECT * FROM `book_data`";
        List<BookData> list = queryRunner.query(sql, new BeanListHandler<>(BookData.class));
        return list;
    }

    public BookData findBook(String uuid) throws SQLException {
        BookData bookData = queryRunner.query("SELECT * FROM book_data WHERE book_uuid = ?", new BeanHandler<>(BookData.class), new Object[]{uuid});
        return bookData;
    }

    public boolean outBook(int bookData, String uuid) throws SQLException {
        int temp = queryRunner.update("UPDATE `book_data` SET `book_remsining` = ? WHERE `book_data`.`book_uuid` = ?", new Object[]{bookData - 1, uuid});
        return temp > 0;
    }

}
