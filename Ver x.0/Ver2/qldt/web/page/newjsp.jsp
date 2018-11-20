<%-- 
    Document   : newjsp
    Created on : Nov 5, 2018, 4:37:57 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p><%
            String name = request.getParameter("username");
            out.print("welcome " + name);
            %>
        </p>
        <p>${username.name}</p>
    </body>
</html>
