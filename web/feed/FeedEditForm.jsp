<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-03-04
  Time: 오후 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="crud_board.vo.Feed" %>
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
    <jsp:useBean id="editFeed" scope="request" class="crud_board.vo.Feed" />


    <div class="row m-3">
        <div class="col-2">
        </div>
        <div class="card shadow-sm col-8 rounded">
            <div class="card-header" style="font-weight: bold;">
                <i class="bi bi-journal-plus"></i> 피드 수정하기
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">
                    <form action="edit.do" method="post">
                        <div class="row mb-3" >
                            <label for="inputTitle" class="col-sm-1 col-form-label" style="font-weight: bold;">제목</label>
                            <div class="col-sm-11">
                                <input type="text" class="form-control" id="inputTitle" name="title" value="${requestScope.editFeed.getTitle()}">
                            </div>
                        </div>
                        <div class="row mb-3" style="height: 400px;">
                            <label for="inputContent" class="col-sm-1 col-form-label" style="font-weight: bold;">내용</label>
                            <div class="col-sm-11">
                                <textarea class="form-control h-100" name="content" id="inputContent" rows="3">${requestScope.editFeed.getContent()}</textarea>
                            </div>
                        </div>
                        <input type="hidden" name="no" value="${requestScope.editFeed.getNo()}">
                        <div class="row mb-3" >
                            <label for="edit" class="col-sm-1 col-form-label" style="font-weight: bold;">수정</label>
                            <input type="submit" class="btn btn-primary col-sm-1" id="edit" value="수정">
                        </div>
                    </form>
                </li>
                <li class="list-group-item">
                    <div class="row">
                        <form action="delete.do" method="post">
                            <label for="delete" class="col-sm-1 col-form-label" style="font-weight: bold;">삭제하기</label>
                            <input type="hidden" name="no" value="${requestScope.editFeed.getNo()}">
                            <input type="submit" id ="delete" class="btn btn-danger" value="삭제">
                        </form>
                    </div>
                </li>
            </ul>
        </div>
        <div class="col-2">
            <jsp:include page="LoginInfo.jsp"/>
            <jsp:include page="RecentSearch.jsp"/>
        </div>
    </div>




</body>
</html>
