<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link rel="stylesheet" href="/StudentHelper/resources/css/font-awesome.css">
</head>
<nav class="navbar navbar-expand-lg navbar-light bg-light justify-content-md-center">
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="Welcome">Home <!--<span class="sr-only">(current)</span>--></a>
            </li>
            <c:if test="${userLogin.role eq 'ADMIN' || userLogin.role eq 'PROFESSOR' }">
                <li class="nav-item">
                    <a class="nav-link" href="MarkList">Marks</a>
                </li>
            </c:if>
            <c:if test="${userLogin.role eq 'ADMIN'}">
                <li class="nav-item">
                    <a class="nav-link" href="UserList">Users</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="StudentList">Students</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="GroupList">Groups</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ProfessorList">Professors</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="StudieList">Studies</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Read messages</a>
                </li>
            </c:if>
            <c:if test="${userLogin.role ne 'ADMIN'}">
                <li class="nav-item">
                    <a class="nav-link" href="#">Send message</a>
                </li>
            </c:if>
        </ul>
    </div>
    <form action="Logout" class="form-inline float-right" method="post">
        <button class="btn btn-light">Logout (${userLogin.user}) <i class='fa fa-sign-out'></i></button>
    </form>
</nav>