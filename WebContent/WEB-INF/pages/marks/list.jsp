<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gotov
  Date: 30.10.2017
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Mark list</title>
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

<table class="table table-bordered">
    <tr>
        <th>Id</th>
        <th>Study Id</th>
        <th>Student Id</th>
        <th>Date</th>
        <th>Professor Id</th>
        <th>Mark</th>
        <th>Comments</th>
    </tr>

    <c:forEach items="${marks}" var="mark">
        <tr>
            <td>${mark.id}</td>
            <td>${mark.studyId}</td>
            <td>${mark.studentId}</td>
            <td>${mark.date}</td>
            <td>${mark.professorId}</td>
            <td>${mark.mark}</td>
            <td>${mark.comments}</td>
        </tr>
    </c:forEach>

</table>

<div class="container-fluid">
    <div class="row justify-content-between">
        <div class="col-2">
            <form action="MarkForm">
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
<script src="/resources/js/jquery-3.2.1.slim.min.js"></script>
<script src="/resources/js/popper.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>

