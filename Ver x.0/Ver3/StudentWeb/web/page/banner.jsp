<%-- 
    Document   : banner
    Created on : Dec 4, 2018, 9:18:49 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="page-header">
            <div class="container">
                <div class="row">
                    <div class="col-md-10">
                        <ul class="page-header-breadcrumb">
                            <li><a href="index.html">Home</a></li>
                            <% 
                                String url[] = request.getRequestURL().toString().split("/");
                                String jsp = url[url.length-1];
                                if (jsp.equals("timeTable.jsp")){
                                %>
                                    <li>Thời Khóa Biểu</li>
                                <%} else {%>
                                    <li>Sai</li>
                                <%}%>
                        </ul>
                        <h1><%if (jsp.equals("timeTable.jsp")) {%>
                            Thời Khóa Biểu
                            <%}%>
                        </h1>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
