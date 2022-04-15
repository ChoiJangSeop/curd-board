<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-03-30
  Time: 오전 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<div class="list-group">
    <div class="list-group-item list-group-item-secondary" aria-current="true" style="font-weight: bold; text-align: center;">
        실시간 인기글
    </div>
    <c:forEach var="feed" items="${mostViewFeeds}">
        <a href="content.do?no=${feed.getNo()}" class="list-group-item list-group-item-action">${feed.getTitle()}</a>
    </c:forEach>
</div>

<div class="list-group mt-3">
    <div class="list-group-item list-group-item-secondary" aria-current="true" style="font-weight: bold; text-align: center;">
        실시간 많이 본 글
    </div>
    <c:forEach var="feed" items="${mostLikeFeeds}">
        <a href="content.do?no=${feed.getNo()}" class="list-group-item list-group-item-action">${feed.getTitle()}</a>
    </c:forEach>
</div>