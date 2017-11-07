<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gotov
  Date: 07.11.2017
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><c:if test="${message.title ne null}">Message: ${message.title}</c:if></title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<header class="header">
    <jsp:include page="/WEB-INF/pages/template/header.jsp"/>
</header>

<div class="container-fluid">
    <form action="MessageSend" method="post">

        <div class="col-4 form-group">
            <label for="messageTitle">Title</label>
            <input name="messageTitle" id="messageTitle" class="form-control" value="${message.title}">
        </div>
        <div class="col-4 form-group">
            <label for="messageText">Message text</label>
            <input name="messageText" id="messageText" class="form-control" value="${message.text}">
        </div>
        <input type="submit" class="btn btn-primary" value="Send">
    </form>
</div>

</body>
</html>
