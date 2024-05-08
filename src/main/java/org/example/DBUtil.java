package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {
    //DB 접속 하는 일을 하는 메서드
    public static Connection getConnection() throws Exception {
        Connection conn = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String dbUrl = "jdbc:mysql://localhost/exampledb";
        String user = "root";
        String password = "";
        conn = DriverManager.getConnection(dbUrl, user, password);

        return conn;
    }

    public static Connection getConnection(String dbUrl, String user, String password) {
        Connection conn = null;
        return conn;
    }
    public void close(Connection conn, PreparedStatement ps){

    }
    public void close(Connection conn, PreparedStatement ps, ResultSet rs){

    }



    // DB close 하는 메서드
}
