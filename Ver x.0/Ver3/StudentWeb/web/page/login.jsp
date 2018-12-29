<%-- 
    Document   : login
    Created on : Dec 4, 2018, 9:37:07 AM
    Author     : admin
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
        <script src="${pageContext.request.contextPath}/page/js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <jsp:include page="banner.jsp"></jsp:include>
        <%
            Object error = request.getAttribute("errorMessage");
        %>
        <div class="section">
            <div class="container">
                <div class="col-md-6">
                    <div class="row">
                        <form action="${pageContext.request.contextPath}/LoginServlet"  method="post">
                            <div class="form-group">
                                <label for="exampleInputEmail1">Tên đăng nhập</label>
                                <input name="username" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Nhập Mã Sinh Viên" value="" required autofocus>
                                <small id="emailHelp" class="form-text text-muted">We'll never share your account with anyone else.</small>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Mật khẩu</label>
                                <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Mật khẩu" value="" required>
                            </div>
                            <div class="form-check">
                                <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                <label class="form-check-label" for="exampleCheck1">Remember me</label>
                            </div>
                            <%
                                if (error != null) {%>
                                    <div style ="color:tomato; margin-bottom: 5px;">
                                        <%=error%>
                                    </div>
                                <%}
                            %>
                            <button type="submit" class="btn btn-primary">Đăng nhập</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
        <script src="${pageContext.request.contextPath}/page/js/main.js"></script>
    </body>
</html>
