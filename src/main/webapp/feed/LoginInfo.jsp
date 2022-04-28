<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-03-30
  Time: 오후 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="loginUser" scope="session" class="java.lang.String" />

<div class="card mb-3 shadow-sm">
    <div class="card-body mb-sm-0" style="font-weight: bold;">
        <i class="bi bi-person-circle"></i> ${sessionScope.loginUser}
    </div>
</div>
