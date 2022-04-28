<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-04-22
  Time: 오후 7:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page
        contentType="text/html;charset=UTF-8"
        language="java"
        pageEncoding="UTF-8"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CRUD게시판 : 시작</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body style="margin-right: 25%; margin-left:25%; margin-top: 10%;">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<div>
    <div class="mb-3" style="font-weight: bold"><h1>No Think, Only Write</h1></div>
    <div class="mb-3"><h3>생각없이 끄적이는 곳</h3></div>
    <div>
        <p>
            누구나 글을 쓸수 있습니다. 익명으로 써도되고, 회원 가입을 해 닉네임을 가지고 활동할 수도 있습니다.<br>
            부담없이 아무런 글이나 작성하고 다른 사람들과 대화를 나누세요. No Think, Only Write
        </p>
    </div>
    <div>
        <form action="start.do" method="post">
            <input type="hidden" name="start" value="anonymous">
            <button type="submit" class="btn btn-primary">익명으로 시작</button>
            <a href="login.do" class="btn btn-success">회원 로그인</a>
            <a href="join.do" class="btn btn-secondary">회원 가입</a>
        </form>

    </div>
</div>

</body>
</html>
