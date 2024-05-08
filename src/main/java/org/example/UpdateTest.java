package org.example;

import java.sql.*;

public class UpdateTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/examplesdb";
            String user = "sangjin";
            String password = "sangjin";

            conn = DriverManager.getConnection(dbUrl, user, password);

            String sql = "update dept set loc = '서울' where deptno = 40";
            ps = conn.prepareStatement(sql);

            int count = ps.executeUpdate();
            System.out.println(count + "건 입력했습니다.");

        } catch (Exception e){

        } finally {
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}