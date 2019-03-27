package service;

import Dao.MeaasgeDb;
import db.CloseDb;
import db.ConnectDb;
import model.Message;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet(name = "Servlet")
public class AddMessage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        User user = (User)session.getAttribute("user");
        Message message = new Message(content, user.getId(), title);
        //Message message = (Message)request.getSession().getAttribute("vip");
        MeaasgeDb meaasgeDb = new MeaasgeDb();
        System.out.println(message);
        boolean bl = meaasgeDb.addMessage(message);
        if (bl == true)
        {
            ArrayList<Message> list = meaasgeDb.queryById(user.getId());
            int times = 0;
            if (list == null)
            {
                times = 0;
            }
            else
            {
                times= list.size();
            }
            String tm = String.valueOf(times);
            session.setAttribute("times", tm);
            request.setAttribute("MessageSuc", "留言成功");
            request.getRequestDispatcher("/vip.jsp").forward(request, response);

        }
        else
        {
            request.setAttribute("MessageFail", "留言失败");
            request.getRequestDispatcher("/vip.jsp").forward(request, response);
        }
    }
}
