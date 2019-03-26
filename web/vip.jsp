<%--
  Created by IntelliJ IDEA.
  User: forever
  Date: 2019/3/21
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>会员界面</title>
</head>
<body>
<div>
    欢迎会员用户!
    <form action="/message/AddMessage" method="get">
        <input type="text" name="message" value="留言"><br>
        <input type="reset" value="重置">
        <input type="submit" value="提交">
    </form>
</div>
</body>
</html>
