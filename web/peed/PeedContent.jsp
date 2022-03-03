<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-03-03
  Time: 오후 1:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="crud_board.vo.Peed" %>
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
    <% Peed peed = (Peed)request.getAttribute("peed"); %>
    <h2>${requestScope.peed.getTitle()}</h2>
    <p>${requestScope.peed.getContent()}</p>
</body>
</html>
