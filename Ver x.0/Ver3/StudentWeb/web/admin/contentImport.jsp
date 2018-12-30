<%-- 
    Document   : contentImport
    Created on : Dec 25, 2018, 5:07:27 PM
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
            <h3>Nhập cơ sở dữ liệu</h3>
            <div class="clear"></div>
            <div class="container">
                <form action="${pageContext.request.contextPath}/ImportDataServlet" method="post" accept-charset="utf-8" id="form1"  enctype="multipart/form-data" >
                    <div class="row">
                        <div class="col-25"><label>Chọn nội dung nhập:</label></div>
                        <div class="col-75"><input id="fileselector" type="file" name="file" accept=".xlsx"></div>
                    </div>
                    <div class="row">
                        <div class="col-25"><label>Chọn file</label></div>
                        <div class="col-75">
                            <select id="select1" name="select" onchange="selectOption('select1', 'div1')">
                                <option>Chọn</option>
                                <option value="diem">Điểm</option>
                                <option value="thongtincanhan">Thông tin sinh viên</option>
                                <option value="tkb">Thời khóa biểu</option>
                                <option value="lichthi">Lịch thi</option>
                                <option value="dangkymonhoc">Đăng ký môn học</option>
                                <option value="hocky">Học kỳ</option>
                            </select>
                        </div>
                    </div>
                    <div id="div1">
                        
                    </div>
                </form>
                <% 
                    Object error = request.getAttribute("message");
                    if((error) != null){ 
                %>
                <div class="row" style="color:Tomato;">
                    <%=error %>
                </div>
                <% } %>
            </div>
        </div>
        <div class="clear"></div>        
    </body>
</html>
<!--            <form action="${pageContext.request.contextPath}/ImportDataServlet" method="post" accept-charset="utf-8" id="form1"  enctype="multipart/form-data">
                            <p>Chọn file: </p>
                            <input id="fileselector" type="file" name="file" accept=".xlsx">
                            <p>Chọn nội dung nhập: </p>
                            <select id="select1" name="select" onchange="selectOption('select1', 'div1')">
                                <option>Chọn</option>
                                <option value="diem">Điểm</option>
                                <option value="thongtincanhan">Thông tin sinh viên</option>
                                <option value="tkb">Thời khóa biểu</option>
                                <option value="lichthi">Lịch thi</option>
                            </select>
                            <hr/>
                            <div id="div1">
            
                            </div>-->
<!--<input type="submit" value="Submit">-->
<!--</form>-->

