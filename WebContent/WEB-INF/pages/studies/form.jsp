<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gotov
  Date: 30.10.2017
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Studie form</title>
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
<br>

<div class="container-fluid">
    <form action="StudieSave" method="post">
        <input type="hidden" name="oldStudie" value="${studie.id}">

        <div class="col-4 form-group">
            <label for="name">Name</label>
            <input name="name" id="name" class="form-control" value="${studie.name}">
        </div>
        <div class="col-4 form-group">
            <label for="hours">Hours</label>
            <input name="hours" id="hours" class="form-control" value="${studie.hours}">
        </div>
        <div class="col-4 form-group">
            <label for="professorId">Professor Id</label>
            <%--<input name="professorId" id="professorId" class="form-control" value="${studie.professorId}">--%>
            <select class="form-control" name="professorId" id="professorId">
                <c:forEach items="${professors}" var="professor">
                    <option>${professor.id}</option>
                </c:forEach>
            </select>
        </div>
        <%--TODO: not allow input mark (will recalculate)--%>
        <div class="col-4 form-group">
            <label for="avgMark">Avg Mark</label>
            <input name="avgMark" id="avgMark" class="form-control" value="${studie.avgMark}">
        </div>

        <input type="submit" class="btn btn-primary" value="Save">
    </form>
</div>


<c:if test="${studie.id ne null}">
    <div class="container-fluid">
        <form action="StudieDelete">
            <input type="hidden" name="oldStudie" value="${studie.id}"><br>
            <input type="submit" class="btn btn-danger" value="Delete">
        </form>
    </div>
</c:if>
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
