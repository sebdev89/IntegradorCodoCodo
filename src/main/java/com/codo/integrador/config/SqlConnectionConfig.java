package com.codo.integrador.config;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class SqlConnectionConfig {

    private static Connection connection;
    private static BasicDataSource dataSource;

    private SqlConnectionConfig(

    ){}


    public static DataSource getDataSource() {
        if (dataSource == null) {
            try{
                String URL = "jdbc:mysql://root:password1234@localhost:3306/integradordb?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
                dataSource = new BasicDataSource();
                dataSource.setUrl(URL);
                dataSource.setInitialSize(50);
            }catch (Exception ex){
                throw new RuntimeException("Error connecting to DB", ex);
            }
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = getDataSource().getConnection();
        return connection;
    }


}
