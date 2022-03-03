<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-03-02
  Time: 오후 4:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page
        contentType="text/html;charset=UTF-8"
        language="java"
        pageEncoding="UTF-8"
%>
<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
    <title>로그인</title>
</head>
<body>
    <h2>로그인</h2>
    <form action='login.do' method='post'>
        아이디: <input type="text" name="id"><br>
        비번: <input type="password" name="password"><br>
        <input type="submit" value="로그인">
    </form>
</body>
</html>
