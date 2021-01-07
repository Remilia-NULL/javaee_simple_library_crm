package com.library.DAO;

import com.library.Domain.NormalUser;
import com.library.Utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class NormalUserDAO {
    private QueryRunner queryRunner = new QueryRunner(DBUtils.getConnect());

    //用户登入检查
    public NormalUser checkLogin(String userName, String passWord) throws SQLException {
        NormalUser data = queryRunner.query("SELECT * FROM normal_user WHERE nor_name=? AND nor_password=?", new BeanHandler<>(NormalUser.class), new Object[]{userName, passWord});
        return data;
    }

    //注册新用户
    public boolean addNewUser(NormalUser normalUser) throws SQLException {
        int temp = queryRunner.update("INSERT INTO normal_user(nor_uuid, nor_name, nor_password, nor_email, nor_static) VALUES (?,?,?,?,?)", new Object[]{
                normalUser.getNor_uuid(), normalUser.getNor_name(), normalUser.getNor_password(), normalUser.getNor_email(), normalUser.getNor_static()
        });
        return temp > 0;
    }

    //用户更新信息
    public boolean updateUser(NormalUser normalUser) throws SQLException {
        int temp = queryRunner.update("UPDATE normal_user SET nor_uuid=?,nor_name=?,nor_password=?,nor_email=?,nor_static=? WHERE nor_uuid=?"
                , new Object[]{normalUser.getNor_uuid(), normalUser.getNor_name(), normalUser.getNor_name(),
                        normalUser.getNor_email(), normalUser.getNor_static(), normalUser.getNor_uuid()
                });
        return temp > 0;
    }
}
