package db;
import jdk.nashorn.internal.runtime.regexp.joni.SearchAlgorithm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CloseDb {
    public static void allClose(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        try {
            if (pstmt != null)
            {
                pstmt.close();
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        try {
            if (conn != null)
            {
                conn.close();
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public static void close(Connection conn, PreparedStatement pstmt)
    {
        try {
            if (pstmt != null)
            {
                pstmt.close();
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        try {
            if (conn != null)
            {
                conn.close();
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
