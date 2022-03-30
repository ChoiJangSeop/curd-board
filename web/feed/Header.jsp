<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-03-04
  Time: 오후 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<jsp:useBean id="loginUser" scope="session" class="java.lang.String" />

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid row">
        <a class="navbar-brand col-2" href="main.do" style="font-weight: bold;">생각없이 끄적이는 곳</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="col-8">
            <form class="d-flex my-0" action="main.do" method="get">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="text">
                <button class="btn btn-success" type="submit"><i class="bi bi-search"></i></button>
            </form>
        </div>
        <div class="collapse navbar-collapse row col-2 mx-0" id="navbarSupportedContent">

            <ul class="navbar-nav me-auto mb-2 mb-lg-0 col-12">
                <li class="nav-item align-middle">
                    <a class="nav-link btn btn-outline-secondary rounded" href="add.do"><i class="bi bi-journal-plus"></i> Add Feed</a>
                </li>
            </ul>

        </div>
    </div>
</nav>
