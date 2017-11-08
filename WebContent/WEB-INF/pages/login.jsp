<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">

    <link rel="stylesheet" href="resources/css/signin.css">
</head>
<body>

${message}

<%--TODO: style for message--%>

<div class="container">

    <form action="Authenticate" method="post" class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input name="user" id="user" class="form-control" placeholder="Username" required="" autofocus="">
        <input type="password" name="password" id="password" class="form-control" placeholder="Password" required="">
        <%--TODO:realise remember-me--%>
        <%--<div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>--%>
        <input type="submit" class="btn btn-lg btn-primary btn-block" value="Sign in">
    </form>

</div> <!-- /container -->
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
