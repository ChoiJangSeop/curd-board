<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-03-02
  Time: 오후 4:20
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
    <title>CRUD게시판 : 로그인</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <jsp:include page="../feed/Header.jsp" />

    <form action='login.do' method='post' style="margin-left:25%; margin-right:25%;">
        <div class="mb-3">
            <label for="formGroupExampleInput" class="form-label">아이디 ID</label>
            <input type="text" name="id" class="form-control" id="formGroupExampleInput">
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label">비밀번호 PASSWORD</label>
            <input type="password" name="password" class="form-control" id="formGroupExampleInput2">
        </div>

        <div class="mb-3">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="anonymous" id="gridRadios1" value="true">
                <label class="form-check-label" for="gridRadios1">
                    익명으로 시작
                </label>
            </div>
        </div>

        <div class="mb-3">
            <input type="submit" class="btn btn-primary" value="로그인">
            <a href="join.do" class="btn btn-secondary">회원가입</a>
        </div>
    </form>
</body>
</html>
