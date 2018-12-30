<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Home</title>
        <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:700%7CNunito:300,600" rel="stylesheet"> 

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/page/css/bootstrap.min.css"/>

        <!-- Font Awesome Icon -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/page/css/font-awesome.min.css">

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/page/css/style.css"/>

    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link href="../css/mos-style.css" rel='stylesheet' type='text/css' />
    <link href="${pageContext.request.contextPath}/admin/css/login.css" rel='stylesheet' type='text/css' />
</head>
<body id="LoginForm">
    <div class="container">
        <h1 class="form-heading">login Form</h1>
        <div class="login-form">
            <div class="main-div">
                <div class="panel">
                    <h2>Admin Login</h2>
                    <p>Please enter your username and password</p>
                </div>
                <form id="Login" method="POST" action="${pageContext.request.contextPath}/AdminLoginServlet">

                    <div class="form-group">


                        <input name="username" type="text" class="form-control" id="inputEmail" placeholder="Username">

                    </div>

                    <div class="form-group">

                        <input name="password" type="password" class="form-control" id="inputPassword" placeholder="Password">

                    </div>
                    <%
                        Object error = request.getAttribute("errorMessage");
                        if (error != null) {
                    %>
                    <div style="color:Tomato;">
                        <%=error%>
                    </div>
                    <% }%>
                    <button type="submit" class="btn btn-primary">Login</button>

                </form>
            </div>
            <p class="botto-text"> </p>
        </div></div></div>


</body>
<!--<body>

    <div id="header">
        <div class="inHeaderLogin"></div>
    </div>

    <div id="loginForm">
        <div class="headLoginForm">
            Login Administrator
        </div>
        <div class="fieldLogin">
            <form method="POST" action="../AdminLoginServlet">
                <div class="row">
                    <div class="col-25"><label for="fname">Username</label></div>
                    <div class="col-75"><input type="text" name="username" ></div>
                </div>
                <div class="row">
                    <div class="col-25"><label for="fname">Password</label></div>
                    <div class="col-75"><input type="text" name="password"  ></div>
                </div>

<input type="submit" class="button" value="Login">
</form>
</div>
</div>

</body>
--></html>
