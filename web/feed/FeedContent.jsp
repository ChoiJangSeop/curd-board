<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-03-03
  Time: 오후 1:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="crud_board.vo.Feed" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CRUD게시판 : Content</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <jsp:useBean id="feed" scope="request" class="crud_board.vo.Feed" />
    <jsp:include page="Header.jsp" />

    <div class="card">
        <div class="card-header">
            ${requestScope.feed.getTitle()}
        </div>
        <div class="card-body">
            <p class="card-text">${requestScope.feed.getContent()}</p>
            <a href="edit.do?no=${requestScope.feed.getNo()}" class="btn btn-danger">수정</a>
            <a href="main.do" class="btn btn-primary">목록</a>
        </div>
    </div>
</body>
</html>
