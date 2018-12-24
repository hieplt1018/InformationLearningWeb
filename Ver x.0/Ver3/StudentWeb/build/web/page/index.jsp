<%-- 
    Document   : index
    Created on : Dec 4, 2018, 8:54:04 AM
    Author     : admin
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" 
   pageEncoding="UTF-8"%>
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
    </head>
    <body>
        <%
            if (session.getAttribute("thongBao") != null) {
                String thongBao = (String) session.getAttribute("thongBao");
        %>
        <jsp:include page="header.jsp"></jsp:include>
        <jsp:include page="contentIndex.jsp"></jsp:include>
        <jsp:include page="footer.jsp"></jsp:include>
        
        <script src="${pageContext.request.contextPath}/page/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/page/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/page/js/main.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script>
            if(document.getElementById('thongBao') != null) {
                swal({
                   title: "Lịch Thi",
                   text: "<%=thongBao%>"});
            } else {
            }
        </script> 
        <%}%>
    </body>
</html>
