<%--
  Created by IntelliJ IDEA.
  User: gotov
  Date: 27.10.2017
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Student list</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
</head>
<body>
<header class="header">
    <jsp:include page="/WEB-INF/pages/template/header.jsp"/>
</header>

<table class="table table-bordered">
    <tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Second Name</th>
        <th>Avg Mark</th>
        <th>Group Number</th>
    </tr>

    <c:forEach items="${students}" var="student">
        <tr>
            <td><a href="StudentForm?id=${student.id}"> ${student.id}</a></td>
            <td>${student.firstName}</td>
            <td>${student.secondName}</td>
            <td>${student.avgMark}</td>
            <td>${student.groupNumber}</td>
        </tr>
    </c:forEach>

</table>

<div class="container-fluid">
    <div class="row justify-content-between">
        <div class="col-2">
            <form action="StudentForm">
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
</body>
</html>
