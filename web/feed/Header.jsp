<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-03-04
  Time: 오후 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<jsp:useBean id="loginUser" scope="session" class="java.lang.String" />

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="main.do" style="font-weight: bold;">생각없이 끄적이는 곳</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" href="#">${sessionScope.loginUser} 님, 입장</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="add.do">Add Feed</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="../auth/logout.do">Logout</a>
                </li>
            </ul>
            <form class="d-flex" action="main.do" method="get">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="text">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
