<%-- 
    Document   : contentHocKy
    Created on : Dec 30, 2018, 9:09:41 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link href="${pageContext.request.contextPath}/admin/css/form.css" rel='stylesheet' type='text/css' />
    <script src="${pageContext.request.contextPath}/admin/js/form.js"></script>

</head>
<body>
    <div id="rightContent">
        <h3></h3>
        <div class="clear"></div>
        <div id="smallRight">
            <div class="container">
                <form action="${pageContext.request.contextPath}/HocKyInfoServlet" method="post" accept-charset="utf-8" id="form1" >
                    <div class="row">
                        <div class="col-25"><label for="fname">Nhập mã học kỳ</label></div>
                        <div class="col-75"><input type="text" name="maHK" value="" ></div>
                    </div>
                    <div class="row">
                        <div class="col-25"><label for="fname">Ngày bắt đầu</label></div>
                        <div class="col-75"><input type="text" name="ngayBD" ></div>
                    </div>
                    <div class="row">
                        <div class="col-75"><input type="submit" value="Thêm" ></div>
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
    </div>
    <div class="clear"></div>  
</body>
</html>
