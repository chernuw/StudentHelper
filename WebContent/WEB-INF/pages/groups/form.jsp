<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gotov
  Date: 30.10.2017
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Group form</title>
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
    <form action="GroupSave" method="post">
        <input type="hidden" name="oldGroupNumber" value="${group.groupNumber}">

        <div class="col-4 form-group">
            <label for="number">Group</label>
            <input name="number" id="number" class="form-control" value="${group.groupNumber}">
        </div>

        <div class="col-4 form-group">
            <label for="avgMark">Avg mark</label>
            <input name="avgMark" id="avgMark" class="form-control" value="${group.avgMark}">
        </div>

        <input type="submit" class="btn btn-primary" value="Save">
    </form>
</div>



<c:if test="${group.groupNumber ne null}">
    <div class="container-fluid">
        <form action="GroupDelete">
            <input type="hidden" name="oldGroupNumber" value="${group.groupNumber}"><br>
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
