<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-03-04
  Time: 오후 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="crud_board.vo.Peed" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CRUD게시판 : 글 수정</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <jsp:include page="Header.jsp" />
    <jsp:useBean id="editPeed" scope="request" class="crud_board.vo.Peed" />


    <form action="edit.do" method="post">
        <div class="input-group mb-3">
            <input type="text" name="title" class="form-control" value="${requestScope.editPeed.getTitle()}" aria-describedby="button-addon2">
            <Button type="submit" class="btn btn-primary" id="button-addon2">등록</Button>
        </div>
        <div class="input-group">
            <span class="input-group-text">글쓰기</span>
            <textarea type="text" name="content" class="form-control">${requestScope.editPeed.getContent()}</textarea>
        </div>
        <input type="hidden" name="no" value="${requestScope.editPeed.getNo()}">
    </form>
    <form action="delete.do" method="post">
        <input type="hidden" name="no" value="${requestScope.editPeed.getNo()}">
        <input type="submit" class="btn btn-danger" value="삭제">
    </form>
</body>
</html>
