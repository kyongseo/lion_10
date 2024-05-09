package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
    public static void main(String[] args) {

        //1.필요한 객체를 선언한다.
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            //3. 접속
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost/exampledb";
            String user = "root1234";
            String password = "root1234";
            conn = DriverManager.getConnection(dbUrl,user,password);
            //4. 쿼리작성
            String sql = "insert into dept(deptno,dname,loc) values (60,'인사부','수원')";
            ps = conn.prepareStatement(sql);
            //5. 실행.
            int count = ps.executeUpdate();
            System.out.println(count+" insert!!");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //2. 닫아준다.
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