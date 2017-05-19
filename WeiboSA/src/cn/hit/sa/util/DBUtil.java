package cn.hit.sa.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;  
  
public class DBUtil { 
    public static Connection getConn() {  
        
        String driver = "com.mysql.jdbc.Driver";  
        String url = "jdbc:mysql://localhost:3306/weibo_db";  
        String username = "root";  
        String password = "root";  
        Connection conn = null;  
        try {  
            Class.forName(driver); //classLoader,加载对应驱动  
            conn = (Connection) DriverManager.getConnection(url, username, password);  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return conn;  
    }
    
    //添加用户
    public void addUser(String username, String email, String telephone, String password){
    	Connection conn = DBUtil.getConn();
    	int i = 0;  
        String sql = "insert into user (username,email,telephone,password) values(?,?,?,?)";  
        PreparedStatement pstmt;  
        try {  
            pstmt = (PreparedStatement) conn.prepareStatement(sql);  
            pstmt.setString(1, username);  
            pstmt.setString(2, email);  
            pstmt.setString(3, telephone);  
            pstmt.setString(4, password);
            i = pstmt.executeUpdate();  
            System.out.println(i);
            pstmt.close();  
            conn.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } 
    }
}