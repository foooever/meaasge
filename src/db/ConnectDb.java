package db;
import java.util.*;
import java.sql.*;
import java.io.*;

public class ConnectDb {
    public static Connection getConn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("加载成功mysql");
        }catch(ClassNotFoundException e)
        {
            System.out.println("没有找到mysql驱动");
        }
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&useSSL=false";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, "root", "123456");

        }catch(SQLException e) {
            System.out.println("连接失败");
            e.printStackTrace();
        }
        return conn;
    }

}
