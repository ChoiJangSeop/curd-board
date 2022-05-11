<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-03-04
  Time: 오전 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CRUD게시판 : 글쓰기</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <!-- Bootstrap icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">

</head>
<body style="background-color: #e9ecef;">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <jsp:include page="Header.jsp" />
    <jsp:useBean id="authority" scope="request" class="java.lang.String" />

    <div class="row m-3">
        <div class="col-2">
        </div>
        <div class="card shadow-sm col-8 p-0">
            <div class="card-header" style="font-weight: bold;">
                <i class="bi bi-journal-plus"></i> 피드 생성하기
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">
                    <form action="add.do" method="post">
                        <div class="row mb-3" >
                            <label for="inputTitle" class="col-1 col-form-label" style="font-weight: bold;">제목</label>
                            <div class="col-11">
                                <input type="text" class="form-control" id="inputTitle" name="title">
                            </div>
                        </div>
                        <div class="row mb-3" style="height: 400px;">
                            <label for="inputContent" class="col-sm-1 col-form-label" style="font-weight: bold;">내용</label>
                            <div class="col-sm-11">
                                <textarea class="form-control h-100" name="content" id="inputContent" rows="3"></textarea>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label for="inputPassword" class="col-sm-1 col-form-label" style="font-weight: bold;">비번</label>
                            <div class="col-sm-3">
                                <input type="password" name="password" class="form-control" id="inputPassword" ${requestScope.authority}>
                            </div>
                            <button type="submit" class="btn btn-primary col-sm-1">생성</button>
                        </div>
                    </form>
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
