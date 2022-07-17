package com.codo.integrador.config;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class SqlConnectionConfig {

    private static Connection connection;
    private static BasicDataSource dataSource;

    private SqlConnectionConfig(){}


    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }


}
