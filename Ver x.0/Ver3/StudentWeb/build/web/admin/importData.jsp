
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nhập dữ liệu</title>

        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="${pageContext.request.contextPath}/admin/css/mos-style.css" rel='stylesheet' type='text/css' />

    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

            <jsp:include page="contentImport.jsp"></jsp:include>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>

    </body>
</html>
