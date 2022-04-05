<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-03-02
  Time: 오후 3:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<jsp:useBean id="alert" scope="request" class="java.lang.String"/>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CRUD게시판 : 메인</title>
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

    <div class="row m-3">
        <div class="col-2">
            <jsp:include page="SideBar.jsp" />
        </div>
        <div class="col-8">
            <div class="mb-3" style="text-align: center;">${alert}</div>
            <c:forEach var="feed" items="${feeds}" varStatus="status">
                <div class="card mb-3 shadow-sm rounded">
                    <div class="card-body">
                        <h5 class="card-title mb-3" style="font-weight: bold;">
                            <a href="content.do?no=${feed.getNo()}" style="text-decoration : none;">${feed.getTitle()}</a>
                        </h5>
                        <h6 class="card-subtitle mb-4 text-muted"><i class="bi bi-pencil-square"></i> ${feed.getWriter()}</h6>
                        <p class="card-text">
                            <i class="bi bi-heart"></i> ${feed.getLikes()} <i class="bi bi-binoculars"></i> ${feed.getViews()}
                        </p>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="col-2">
            <jsp:include page="LoginInfo.jsp"/>
            <jsp:include page="RecentSearch.jsp"/>
        </div>
    </div>





</body>
</html>
