<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-03-30
  Time: 오후 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<div class="list-group mb-3 shadow-sm">
    <div class="list-group-item list-group-item-secondary" aria-current="true" style="font-weight: bold;">
        최근 검색 기록
    </div>

    <c:forEach var="searchText" items="${searchLog}">
        <a href="main.do?text=${searchText}&record=false" class="list-group-item list-group-item-action">${searchText}</a>
    </c:forEach>

</div>