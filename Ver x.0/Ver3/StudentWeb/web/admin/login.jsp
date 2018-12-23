

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>

    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link href="../css/mos-style.css" rel='stylesheet' type='text/css' />

</head>
<body>

    <div id="header">
        <div class="inHeaderLogin"></div>
    </div>

    <div id="loginForm">
        <div class="headLoginForm">
            Login Administrator
        </div>
        <div class="fieldLogin">
            <form method="POST" action="../AdminLoginServlet">
                <label>Username</label><br>
                <input name="username" type="text" class="login"><br>
                <label>Password</label><br>
                <input name="password" type="password" class="login"><br>
                <input type="submit" class="button" value="Login">
            </form>
        </div>
    </div>

</body>
</html>
