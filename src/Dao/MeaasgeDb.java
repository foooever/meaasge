package Dao;

import com.mysql.cj.xdevapi.SqlDataResult;
import db.CloseDb;
import db.ConnectDb;
import model.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MeaasgeDb {
    public static Connection conn = null;
    public static PreparedStatement ps = null;
    public static ResultSet rs = null;
    public boolean addMessage(Message mg) {
        boolean bl = false;
        conn = ConnectDb.getConn();
        String sql = "insert into Content(id, title, message) value(?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, mg.getId());
            ps.setString(2, mg.getTitle());
            ps.setString(3, mg.getContent());
            int f = ps.executeUpdate();
            if (f > 0)
            {
                bl = true;
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally {
            CloseDb.close(conn, ps);
        }
        return  bl;
    }

    public ArrayList<Message> queryById(String id) {
        ArrayList<Message> ans = new ArrayList<Message>();
        conn = ConnectDb.getConn();
        String sql = "select * from content where id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Message tmp = new Message();
                tmp.setContent(rs.getString("message"));
                tmp.setId(rs.getString("id"));
                tmp.setTitle(rs.getString("title"));
                tmp.setDate(rs.getString("cdata"));
                ans.add(tmp);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            CloseDb.allClose(conn, ps, rs);
        }
        return ans;
    }
}
