package com.thepreksha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static Connection conn = null;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if(conn==null){
        	Class.forName("com.mysql.jdbc.Driver");
        	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=dinga");
        }
        return conn;
    }
}
