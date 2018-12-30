
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>menu</title>
        <c:set var="root" value="${pageContext.request.contextPath}"/>
       
    </head>
    <body>

        <div id="leftBar">
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/adminInfo.jsp">Tài khoản</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/importData.jsp">Nhập dữ liệu</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/hocKyInfo.jsp">Thêm học kỳ</a></li>
                <li><a href="${pageContext.request.contextPath}/AdminLogoutServlet">Đăng Xuất</a></li>
            </ul>
        </div>

    </body>
</html>
