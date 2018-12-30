<%-- 
    Document   : studentInfo
    Created on : Dec 16, 2018, 8:15:49 PM
    Author     : Administrator
--%>

<%@page import="DAO.StudentDAO"%>
<%@page import="model.Student"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Điểm</title>
        <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:700%7CNunito:300,600" rel="stylesheet"> 

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/page/css/bootstrap.min.css"/>

        <!-- Font Awesome Icon -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/page/css/font-awesome.min.css">

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/page/css/style.css"/>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/page/css/studentInfo.css"/>
        <!-- Custom Js -->
        <script src="${pageContext.request.contextPath}/page/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/page/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/page/js/main.js"></script>

    </head>
    <body>  


        <jsp:include page="header.jsp"></jsp:include>
        <jsp:include page="banner.jsp"></jsp:include>



        <%
            //String masv = request.getParameter("username");
            Student student = null;
            if (session.getAttribute("student") != null) {
                student = (Student) session.getAttribute("student");
                String masv = student.getsId();
                student = new StudentDAO().getStudent(masv);
            }

        %>
        <!-- section -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- jumbotron -->
                <div class="jumbotron">


                    <!-- row -->
                    <div class="row">
                        <div class="col-md-4 order-md-2 mb-4">
                            <h4 class="d-flex justify-content-between align-items-center mb-3">
                                <span class="text-muted">Thông tin hiện tại</span>
                            </h4>
                            <ul class="list-group mb-3">
                                <li class="list-group-item d-flex justify-content-between lh-condensed">
                                    <div>
                                        <h6 class="my-0">Mã sinh viên</h6>
                                    </div>
                                    <span class="text-muted" id="masv"><%=student.getsId()%></span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between lh-condensed">
                                    <div>
                                        <h6 class="my-0">Họ tên</h6>
                                    </div>
                                    <span class="text-muted" id="hotensv"><%=student.getLastName() + " " + student.getFirstName()%></span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between lh-condensed">
                                    <div>
                                        <h6 class="my-0">Mã Lớp</h6>
                                    </div>
                                    <span class="text-muted" id="malop"><%=student.getsClass()%></span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between bg-light">
                                    <div class="text">
                                        <h6 class="my-0">Ngày sinh</h6>
                                    </div>
                                    <span class="text" id="ngaysinh"><%=student.getDateOfBirth()%></span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between bg-light">
                                    <div class="text">
                                        <h6 class="my-0">Giới tính</h6>
                                    </div>
                                    <span class="text" id="gioitinh"><%=student.getSex()%></span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between bg-light">
                                    <div class="text">
                                        <h6 class="my-0">Nơi sinh</h6>
                                    </div>
                                    <span class="text" id="noisinh"><%=student.getPlaceOfBirth()%></span>
                                </li>
                            </ul>
                        </div>
                        <div class="col-md-8 order-md-1">
                            <h2 class="mb-3">Cập nhật thông tin</h2>
                            <form action="${pageContext.request.contextPath}/StudentInfoServlet" method="post" accept-charset="utf-8" id="form1">
                                <div class="row">
                                    <div class="col-md-6 mb-3">
                                        <label for="firstName">Tên</label>
                                        <input name="ten" type="text" class="form-control" id="inputHo" placeholder="" value="<%=student.getLastName()%>">

                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <label for="lastName">Họ</label>
                                        <input name="ho" type="text" class="form-control" id="inputTen" placeholder="" value="<%=student.getFirstName()%>">

                                    </div>
                                </div>

                                <div class="mb-3">
                                    <label for="username">Ngày sinh</label>
                                    <div class="input-group">

                                        <input name="ngaysinh" type="text" class="form-control" id="inputNgaysinh" value="<%=student.getDateOfBirth()%>">

                                    </div>
                                    <label for="username">Giới tính</label>
                                    <div class="input-group">

                                        <input name="gioitinh" type="text" class="form-control" id="inputGioitinh" value="<%=student.getSex()%>">

                                    </div>
                                    <label for="username">Nơi sinh</label>
                                    <div class="input-group">

                                        <input name="noisinh" type="text" class="form-control" id="inputNoisinh" value="<%=student.getPlaceOfBirth()%>">

                                    </div>
                                </div>
                                <hr class="mb-4">
                                <input type="hidden" name="maSV" value="<%=student.getsId()%>">
                                <input class="btn btn-outline-primary primary-button" type="submit" id="button_update" value="Update">

                            </form>
                        </div>
                    </div>
                </div>
                <!-- /row -->
            </div>
            <!-- /jumbotron -->
        </div>
        <jsp:include page="footer.jsp"></jsp:include>           
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>

    </body>

</html>
