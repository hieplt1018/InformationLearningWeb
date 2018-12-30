<%@page import="model.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Admin admin = null;
    if (session.getAttribute("admin") != null) {
        admin = (Admin) session.getAttribute("admin");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tài khoản Admin</title> 
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link href="${pageContext.request.contextPath}/admin/css/form.css" rel='stylesheet' type='text/css' />
    <script src="${pageContext.request.contextPath}/admin/js/form.js"></script>

</head>
<body>

    <div id="rightContent">
        <h3>Tài khoản Admin</h3>
        <div class="clear"></div>
        <div class="container">
            <form action="${pageContext.request.contextPath}/AdminInfoServlet" method="post" accept-charset="utf-8" id="form1" >
                <div class="row">
                    <div class="col-25"><label for="fname">Username</label></div>
                    <div class="col-75"><input type="text" name="username" value="<%=admin.getUsername()%>" ></div>
                </div>
                <div class="row">
                    <div class="col-25"><label for="fname">Password</label></div>
                    <div class="col-75"><input type="text" name="password" value="<%=admin.getPassword()%>" ></div>
                </div>
                <div class="row">
                    <div class="col-25"><label for="fname">Mã nhân viên</label></div>
                    <div class="col-75"><input type="text" name="maNV" value="<%=admin.getMaNV()%>"></div>
                </div>
                <div class="row">
                    <div class="col-25"><label for="fname">Họ</label></div>
                    <div class="col-75"><input type="text" name="ho" value="<%=admin.getHo()%>"></div>
                </div>
                <div class="row">
                    <div class="col-25"><label for="fname">Tên</label></div>
                    <div class="col-75"><input type="text" name="ten" value="<%=admin.getTen()%>"> </div>
                </div>
                <div class="row">
                    <div class="col-75"><input type="submit" value="Cập nhật" ></div>
                </div>
            </form>
            <%
                Object error = request.getAttribute("message");
                if ((error) != null) {
            %>
            <div class="row" style="color:Tomato;">
                <%=error%>
            </div>
            <% }%>
        </div>
    </div>
    <div class="clear"></div>        
</body>
</html>
