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
    <title>Mark form</title>
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
    <form action="MarkSave" method="post">

        <%--TODO: show name without id--%>
        <div class="col-4 form-group">
            <label for="studieId">Studie Id</label>
            <select class="form-control" name="studieId" id="studieId">
                <c:forEach items="${studies}" var="studie">
                    <option>${studie.id}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-4 form-group">
            <label for="studentId">Student Id</label>
            <select class="form-control" name="studentId" id="studentId">
                <c:forEach items="${students}" var="student">
                    <option>${student.id}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-4 form-group">
            <label for="date">Date</label>
            <input name="date" id="date" class="form-control" value="${mark.date}" placeholder="YYYY-MM-DD">
        </div>
        <div class="col-4 form-group">
            <label for="professorId">Professor Id</label>
            <select class="form-control" name="professorId" id="professorId">
                <c:forEach items="${professors}" var="professor">
                    <option>${professor.id}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-4 form-group">
            <label for="markMark">Mark</label>
            <input name="markMark" id="markMark" class="form-control" value="${mark.mark}">
        </div>
        <div class="col-4 form-group">
            <label for="comments">Comments</label>
            <input name="comments" id="comments" class="form-control" value="${mark.comments}">
        </div>
        <input type="submit" class="btn btn-primary" value="Save">
    </form>
</div>

<%--TODO: footer hide button... do something... for exmpl make  footer moving--%>
<footer class="footer">
    <%--<jsp:include page="/WEB-INF/pages/template/footer.jsp"/>--%>
</footer>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="resources/js/jquery-3.2.1.slim.min.js"></script>
<script src="resources/js/popper.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>