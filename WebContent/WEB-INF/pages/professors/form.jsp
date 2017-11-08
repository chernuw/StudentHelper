<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gotov
  Date: 30.10.2017
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Professor form</title>
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
    <form action="ProfessorSave" method="post">
        <input type="hidden" name="oldProfessor" value="${professor.id}">

        <div class="col-4 form-group">
            <label for="firstName">First Name</label>
            <input name="firstName" id="firstName" class="form-control" value="${professor.firstName}">
        </div>
        <div class="col-4 form-group">
            <label for="secondName">Second Name</label>
            <input name="secondName" id="secondName" class="form-control" value="${professor.secondName}">
        </div>
        <div class="col-4 form-group">
            <label for="fatherName">Father Name</label>
            <input name="fatherName" id="fatherName" class="form-control" value="${professor.fatherName}">
        </div>
        <div class="col-4 form-group">
            <label for="birthDate">Birth date</label>
            <input name="birthDate" id="birthDate" class="form-control" value="${professor.birthDate}"
                   placeholder="YYYY-MM-DD">
        </div>
        <div class="col-4 form-group">
            <label for="avgMark">Avg mark</label>
            <input name="avgMark" id="avgMark" class="form-control" value="${professor.avgMark}">
        </div>
        <input type="submit" class="btn btn-primary" value="Save">
    </form>
</div>


<c:if test="${professor.id ne null}">
    <div class="container-fluid">
        <form action="ProfessorDelete">
            <input type="hidden" name="oldProfessor" value="${professor.id}">
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