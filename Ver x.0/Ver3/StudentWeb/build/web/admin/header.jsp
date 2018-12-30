
<%@page import="model.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Admin admin = null;
    if(session.getAttribute("admin") != null) {
        admin = (Admin) session.getAttribute("admin");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>header</title>
    </head>
    <body>

        <div id="header">
            <div class="inHeader">
                <% if(admin != null) { %>
                <div class="mosAdmin">
                    Welcome <%=admin.getHo()%> <%=admin.getTen()%>
                </div>
                <% } %>
                <div class="clear"></div>
            </div>
        </div> 

    </body>
</html>
