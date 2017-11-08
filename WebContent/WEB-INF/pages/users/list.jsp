<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gotov
  Date: 31.10.2017
  Time: 1:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>User list</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">


    <script type="text/javascript" src="js/test.js"></script>
</head>
<body>
<header class="header">
    <jsp:include page="/WEB-INF/pages/template/header.jsp"/>
</header>


<table class="table table-bordered">
    <tr>
        <th>User</th>
        <th>Password</th>
        <th>Role</th>
    </tr>

    <c:forEach items="${users}" var="user">
        <tr>
            <td><a href="UserForm?id=${user.user}"> ${user.user} </a></td>
            <td>${user.password}</td>
            <td>${user.role}</td>
        </tr>
    </c:forEach>

</table>

<div class="container-fluid">
    <div class="row justify-content-between">
        <div class="col-2">
            <form action="UserForm">
                <input type="submit" class="btn btn-success" value="New..">
            </form>
        </div>

        <div class="col-2">
            <form action="#">
                <input type="submit" class="btn btn-info" value="Recalculate">
            </form>
        </div>
    </div>
</div>

<footer class="footer">
    <jsp:include page="/WEB-INF/pages/template/footer.jsp"/>
</footer>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="resources/js/jquery-3.2.1.slim.min.js"></script>
<script src="resources/js/popper.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>

<script type="text/javascript">buildUserTable();</script>
</body>
</html>