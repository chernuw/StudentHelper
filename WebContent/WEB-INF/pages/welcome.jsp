<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Welcome</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="resources/css/welcome.css">
</head>
<body>


<header class="header">
    <jsp:include page="/WEB-INF/pages/template/header.jsp"/>
</header>
<div class="vcenter">
    <div class="container">
        <div class="row justify-content-center">
            <c:if test="${userLogin.role eq 'ADMIN'}">
            <div class="col-3">
                <a href="UserList">
                    <div class="card text-center bg-light">
                        <div class="card-body">
                            <h3 class="card-title">Users</h3>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-3">
                <a href="StudentList">
                    <div class="card text-center bg-light">
                        <div class="card-body">
                            <h3 class="card-title">Students</h3>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-3">
                <a href="GroupList">
                    <div class="card text-center bg-light">
                        <div class="card-body">
                            <h3 class="card-title">Groups</h3>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-3">
                <a href="ProfessorList">
                    <div class="card text-center bg-light">
                        <div class="card-body">
                            <h3 class="card-title">Professors</h3>
                        </div>
                    </div>
                </a>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-3">
                <a href="StudieList">
                    <div class="card text-center bg-light">
                        <div class="card-body">
                            <h3 class="card-title">Studies</h3>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-3">
                <a href="#">
                    <div class="card text-center bg-primary   text-light">
                        <div class="card-body">
                            <h3 class="card-title">Read Messages</h3>
                        </div>
                    </div>
                </a>
            </div>
            </c:if>
            <c:if test="${userLogin.role eq 'ADMIN' || userLogin.role eq 'PROFESSOR' }">
                <div class="col-3">
                    <a href="MarkList">
                        <div class="card text-center bg-light">
                            <div class="card-body">
                                <h3 class="card-title">Marks</h3>
                            </div>
                        </div>
                    </a>
                </div>
            </c:if>
            <c:if test="${userLogin.role ne 'ADMIN'}">
                <div class="col-3">
                    <a href="#">
                        <div class="card text-center bg-primary   text-light">
                            <div class="card-body">
                                <h3 class="card-title">Send message</h3>
                            </div>
                        </div>
                    </a>
                </div>
            </c:if>
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
