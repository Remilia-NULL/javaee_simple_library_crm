package com.library.Utils;


import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class DBUtils {
    private static DataSource dataSource = null;
    private final static String sqlUrl = "jdbc:mysql://127.0.0.1:3306/library?characterEncoding=utf8";
    private final static String sqlUserName = "JavaWeb";
    private final static String sqlPasswd = "00000000";

    public static DataSource getConnect() {
        if (dataSource == null) {
            BasicDataSource basicDataSource = new BasicDataSource();
            basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
            basicDataSource.setUrl(sqlUrl);
            basicDataSource.setUsername(sqlUserName);
            basicDataSource.setPassword(sqlPasswd);
            dataSource = basicDataSource;
        }
        return dataSource;
    }
}
