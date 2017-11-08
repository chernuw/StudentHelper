<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gotov
  Date: 30.10.2017
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>User form</title>
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
<br>

<div class="container-fluid">
    <form action="UserSave" method="post">
        <input type="hidden" name="oldUser" value="${user.user}">

        <div class="col-4 form-group">
            <label for="user">User</label>
            <input name="user" id="user" class="form-control" value="${user.user}">
        </div>

        <div class="col-4 form-group">
            <label for="password">Password</label>
            <input name="password" id="password" class="form-control" value="${user.password}">
        </div>

        <div class="col-4 form-group">
            <label for="role">Role</label>
            <select class="form-control" name="role" id="role">
                <option>STUDENT</option>
                <option>ADMIN</option>
                <option>PROFESSOR</option>
            </select>
        </div>

        <input type="submit" class="btn btn-primary" value="Save">
    </form>
</div>


<c:if test="${user.user ne null}">
    <div class="container-fluid">
        <form action="UserDelete">
            <input type="hidden" name="oldUser" value="${user.user}">
            <input type="submit" class="btn btn-danger" value="Delete">
        </form>
    </div>
</c:if>
<footer class="footer">
    <jsp:include page="/WEB-INF/pages/template/footer.jsp"/>
</footer>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="/resources/js/jquery-3.2.1.slim.min.js"></script>
<script src="/resources/js/popper.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
