package com.library.DAO;

import com.library.Domain.BookData;
import com.library.Domain.BorrowData;
import com.library.Domain.NormalUser;
import com.library.Utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowBookDAO {
    private QueryRunner queryRunner = new QueryRunner(DBUtils.getConnect());

    //得到所有借书信息
    public List<BorrowData> findAllBorrow() throws SQLException {
        String sql = "SELECT book_data.*,borrow_data.*,normal_user.* FROM book_data,normal_user,borrow_data WHERE book_data.book_uuid=borrow_data.book_uuid AND borrow_data.user_uuid=normal_user.nor_uuid";
        List<BorrowData> data = queryRunner.query(sql, new ResultSetHandler<List<BorrowData>>() {
            public List<BorrowData> handle(ResultSet resultSet) throws SQLException {
                List<BorrowData> list = new ArrayList<>();
                while (resultSet.next()) {
                    BorrowData borrowData = new BorrowData();
                    borrowData.setBorrow_id(resultSet.getInt("borrow_data.borrow_id"));
                    borrowData.setBook_uuid(resultSet.getString("borrow_data.book_uuid"));
                    borrowData.setUser_uuid(resultSet.getString("borrow_data.user_uuid"));
                    borrowData.setOut_time(resultSet.getDate("borrow_data.out_time"));
                    borrowData.setIn_time(resultSet.getString("borrow_data.in_time"));
                    borrowData.setBook_static(resultSet.getInt("borrow_data.book_static"));

                    NormalUser normalUser = new NormalUser();
                    normalUser.setNor_name(resultSet.getString("normal_user.nor_name"));
                    borrowData.setNormalUser(normalUser);

                    BookData bookData = new BookData();
                    bookData.setBook_name(resultSet.getString("book_data.book_name"));
                    borrowData.setBookData(bookData);

                    list.add(borrowData);
                }
                return list;
            }
        });
        return data;
    }

    public List<BorrowData> findBorrowByUser(String uuid) throws SQLException {
        String sql = "SELECT book_data.*,borrow_data.*,normal_user.* FROM book_data,borrow_data,normal_user WHERE borrow_data.book_uuid=book_data.book_uuid AND borrow_data.user_uuid=normal_user.nor_uuid AND normal_user.nor_uuid=?";
        List<BorrowData> data = queryRunner.query(sql, new ResultSetHandler<List<BorrowData>>() {
            public List<BorrowData> handle(ResultSet resultSet) throws SQLException {
                List<BorrowData> list = new ArrayList<>();
                while (resultSet.next()) {
                    BorrowData borrowData = new BorrowData();
                    borrowData.setBorrow_id(resultSet.getInt("borrow_data.borrow_id"));
                    borrowData.setUser_uuid(resultSet.getString("borrow_data.user_uuid"));
                    borrowData.setBook_static(resultSet.getInt("borrow_data.book_static"));
                    borrowData.setBook_uuid(resultSet.getString("borrow_data.book_uuid"));
                    borrowData.setOut_time(resultSet.getDate("borrow_data.out_time"));
                    borrowData.setIn_time(resultSet.getString("borrow_data.in_time"));
                    NormalUser normalUser = new NormalUser();
                    BookData bookData = new BookData();
                    bookData.setBook_name(resultSet.getString("book_data.book_name"));
                    borrowData.setBookData(bookData);
                    normalUser.setNor_name(resultSet.getString("normal_user.nor_name"));
                    borrowData.setNormalUser(normalUser);
                    list.add(borrowData);
                }
                return list;
            }
        }, uuid);
        return data;
    }

    //根据借还书的ID查询信息
    public BorrowData findBorrow(int id) throws SQLException {
        BorrowData bookData = queryRunner.query("SELECT * FROM borrow_data WHERE borrow_id = ?", new BeanHandler<>(BorrowData.class), new Object[]{id});
        return bookData;
    }

    //增加借书信息
    public boolean addBorrow(BorrowData borrowData) throws SQLException {
        int temp = queryRunner.update("INSERT INTO `borrow_data` (`book_uuid`,`user_uuid`, `book_static`) VALUES ( ?, ?, ?)"
                , new Object[]{borrowData.getBook_uuid(), borrowData.getUser_uuid(), borrowData.getBook_static()});
        return temp > 0;
    }

    //修改还书信息
    public boolean editBorrowStatic(BorrowData borrowData) throws SQLException {
        int temp = queryRunner.update("UPDATE `borrow_data` SET `in_time` = ?, `book_static` = '0' WHERE `borrow_data`.`borrow_id` = ?;",
                new Object[]{borrowData.getIn_time(), borrowData.getBorrow_id()});
        return temp > 0;
    }
}
