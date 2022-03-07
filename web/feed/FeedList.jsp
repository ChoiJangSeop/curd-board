<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-03-02
  Time: 오후 3:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CRUD게시판 : 메인</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <jsp:include page="Header.jsp" />

    <table class="table">
        <thead>
        <tr>
            <th scope="col-xs-1">#</th>
            <th scope="col-xs-7">Title</th>
            <th scope="col-xs-2">Created Date</th>
            <th scope="col-xs-2">Writer</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="feed" items='${feeds}' varStatus="status">
            <tr>
                <th scope="row"><c:out value="${status.count}" /></th>
                <td><a href="content.do?no=${feed.getNo()}">${feed.getTitle()}</a></td>
                <td>${feed.getCreatedDate()}</td>
                <td>${feed.getWriter()}</td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</body>
</html>