<%--
  Created by IntelliJ IDEA.
  User: forever
  Date: 2019/2/28
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<html>
<head>
    <title>登陆界面</title>
</head>
<body bgcolor = "#ddd" style="font-family:Microsoft YaHei">
<div style="text-align:center;margin-top:120px">
    <h1>请登录</h1>
    <form action="/message/LoginService" method="=post">
        <table style="margin-left: 40%">
            <caption>用户登录</caption>
            <tr>
                <td>登录名：</td>
                <td><input name="name" type="text" size="20"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input name="password" type="password" size="21"></td>
            </tr>
        </table>
        <input type="submit" value="登录">
        <input type="reset" value="重置">
    </form>
</div>

</body>
</html>
