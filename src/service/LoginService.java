package service;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.LoginDb;
import Dao.MeaasgeDb;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import control.LoginControl;
import model.*;

@WebServlet(name = "Servlet")
public class LoginService extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        User l = (User) session.getAttribute("login1");
        String id = req.getParameter("id");
        String ps = req.getParameter("password");
        System.out.println(id);
        System.out.println(ps);
        String clientCheckcode = req.getParameter("validateCode");//接收客户端浏览器提交上来的验证码
        String serverCheckcode = (String) req.getSession().getAttribute("checkcode");//从服务器端的session中取出验证码
        if (l == null) {
            if (clientCheckcode.equals(serverCheckcode)) {
                System.out.println("验证成功");
                l = LoginDb.LoginCheck(id, ps);
            } else {
                System.out.println("验证失败");
                req.setAttribute("errorValidCode", "验证码错误");
                req.getRequestDispatcher("/login1.jsp").forward(req, resp);
                return;
            }
        }
        if(ps.equals(l.getPassword())) //成功
        {
            MeaasgeDb messageDb = new MeaasgeDb();
            ArrayList<Message> list =messageDb.queryById(id);
            int times =0;
            if(list==null)
            {
                times=0;
            }
            else
            {
                times=list.size();
            }
            System.out.println(times);
            String tm = String.valueOf(times);
            session.setAttribute("times", tm);
            req.setAttribute("times", tm);
            session.setAttribute("login", l);
            session.setAttribute("name", l.getName());
            System.out.println("111");

            req.getRequestDispatcher("/vip.jsp").forward(req, resp);
        }
        else
        {
            System.out.println("密码错误");
            req.setAttribute("errorPassword", "账号或密码错误");
            System.out.println(req.getSession().getAttribute("errorPassword"));
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
