<%-- 
    Document   : registerEmail
    Created on : Dec 29, 2018, 10:53:56 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Đăng nhâp</title>
        <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:700%7CNunito:300,600" rel="stylesheet"> 

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/page/css/bootstrap.min.css"/>

        <!-- Font Awesome Icon -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/page/css/font-awesome.min.css">

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/page/css/style.css"/>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/page/css/login.css"/>
        <!-- Custom Js -->
        <script src="${pageContext.request.contextPath}/page/js/jquery.min.js"></script>;

    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <jsp:include page="banner.jsp"></jsp:include>
        <div class="section">
            <div class="container">
                <div class="col-md-6">
                    <div class="row">
                        <form action="${pageContext.request.contextPath}/RegisterEmailServlet"  method="post">
                            <div class="form-group">
                                <label for="exampleInputEmail1">Mã Sinh Viên</label>
                                <input name="username" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Nhập Mã Sinh Viên" value="" required autofocus>
                                <small id="emailHelp" class="form-text text-muted">We'll never share your account with anyone else.</small>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail11">Email</label>
                                <input name="email" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Nhập Email" value="" required autofocus>
                                <small id="emailHelp" class="form-text text-muted">We'll never share your account with anyone else.</small>
                            </div>
                            <button type="submit" class="btn btn-primary">Đăng kí</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
