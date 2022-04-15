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

    <!-- Bootstrap icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">

</head>
<body style="background-color: #e9ecef;">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <jsp:useBean id="feed" scope="request" class="crud_board.vo.Feed" />
    <jsp:useBean id="counts" scope="request" class="java.lang.String" />
    <jsp:useBean id="authority" scope="request" class="java.lang.String" />
    <jsp:useBean id="alert" scope="request" class="java.lang.String"/>
    <jsp:include page="Header.jsp" />

    <div class="row m-3">
        <div class="col-2">
            <jsp:include page="SideBar.jsp" />
        </div>
        <div class="col-8">
            <div class="card mb-3 shadow-sm">
                <div class="card-header" >
                    <div style="font-weight: bold; font-size: 20px;">${requestScope.feed.getTitle()}</div>
                    <div style="align-content: end;">${requestScope.feed.getWriter()} at ${requestScope.feed.getCreatedDate()}</div>
                </div>
                <div class="card-body" style="height: 400px;">
                    <p class="card-text">${requestScope.feed.getContent()}</p>
                </div>
                <form action="content.do" method="post" class="row g-3 m-3">
                    <div class="col-auto">
                        <input type="password" name="password" class="form-control" value="default" ${requestScope.authority}>
                    </div>
                    <div class="col-auto">
                        <input type="hidden" name="no" class="form-control" value="${requestScope.feed.getNo()}">
                        <input type="submit" class="btn btn-danger" value="수정">
                    </div>
                    <div class="col-auto">
                        <a href="main.do" class="btn btn-primary">목록</a>
                    </div>
                    <div class="col-auto">
                        <p style="color: red;">${requestScope.alert}</p>
                    </div>
                </form>
                <form action="content.do" method="post">
                    <input type="hidden" name="likeClick" value="true">
                    <input type="hidden" name="no" value="${requestScope.feed.getNo()}">
                    <input type="submit" class="btn btn-warning" value="LIKE">
                </form>
            </div>

            <form acction="content.do" method="post">
                <div class="input-group shadow-sm">
                    <input type="hidden" name="no" value="${feed.getNo()}">
                    <input type="text" class="form-control" name="comment" id="inputComment">
                    <button class="btn btn-primary" type="submit" id="button-addon2">등록</button>
                </div>
            </form>

            <div>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col-xs-2">댓글 ${requestScope.counts}개</th>
                        <th scope="col-xs-7"></th>
                        <th scope="col-xs-2"></th>
                        <th scope="col-xs-1"></th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="comment" items='${comments}' varStatus="status">
                        <tr>
                            <td>${comment.getWriter()}</td>
                            <td>${comment.getContent()}</td>
                            <td>${comment.getCreatedDate()}</td>
                            <td>
                                <form action="comment_delete.do" method="post">
                                    <input type="hidden" name="cno" value="${comment.getNo()}">
                                    <input type="hidden" name="fno" value="${feed.getNo()}">

                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-2">
            <jsp:include page="LoginInfo.jsp"/>
            <jsp:include page="RecentSearch.jsp"/>
        </div>
    </div>



</body>
</html>
