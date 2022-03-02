<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-03-02
  Time: 오후 3:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
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

    <jsp:include page="../Header.jsp" />
    <c:forEach var="peed" items='${peeds}'>
        <div class="container">
            <div class="row">
                <div class="col">
                    ${peed.getNo()}
                </div>
                <div class="col-6">
                    ${peed.getTitle()}
                </div>
                <div class="col">
                    ${peed.getCreatedDate()}
                </div>
                <div class="col">
                    ${peed.getWriter()}
                </div>
            </div>
        </div>
    </c:forEach>
</body>
</html>
