<%-- 
    Document   : studentInfo
    Created on : Dec 16, 2018, 8:15:49 PM
    Author     : Administrator
--%>

<%@page import="DAO.StudentDAO"%>
<%@page import="model.Student"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>Thông tin cá nhân</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:700%7CNunito:300,600" rel="stylesheet"> 

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/page/css/bootstrap.min.css"/>

        <!-- Font Awesome Icon -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/page/css/font-awesome.min.css">

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/page/css/style.css"/>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/page/css/studentInfo.css"/>
        <!-- Custom Js -->
        <script src="${pageContext.request.contextPath}/page/js/jquery.min.js"></script>;

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
                      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
                      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
                    <![endif]-->

    </head>

    <body>

        <!-- Header -->
        <header id="header">
            <!-- Nav -->
            <div id="nav">
                <!-- Main Nav -->
                <div id="nav-fixed">
                    <div class="container">
                        <!-- logo -->
                        <div class="nav-logo">
                            <a href="index.html" class="logo"><img src="./img/logo.png" alt=""></a>
                        </div>
                        <!-- /logo -->

                        <!-- nav -->
                        <ul class="nav-menu nav navbar-nav">
                            <li><a href="category.html">Tin tức</a></li>
                            <!-- <li><a href="category.html"></a></li> -->
                            <li class="cat-1"><a href="category.html">Điểm</a></li>
                            <li class="cat-2"><a href="category.html">TKB</a></li>
                            <li class="cat-3"><a href="thongtincanhan.html">Thông tin cá nhân</a></li>
                            <li class="cat-4"><a href="category.html">Lịch thi</a></li>
                        </ul>
                        <!-- /nav -->

                        <!-- search & aside toggle -->
                        <div class="nav-btns">
                            <button class="primary-button " id="primary-button">Đăng Nhập</button>
                            <button class="aside-btn"><i class="fa fa-bars"></i></button>
                            <button class="search-btn"><i class="fa fa-search"></i></button>
                            <div class="search-form">
                                <input class="search-input" type="text" name="search" placeholder="Enter Your Search ...">
                                <button class="search-close"><i class="fa fa-times"></i></button>
                            </div>
                        </div>
                        <!-- /search & aside toggle -->
                    </div>
                </div>
                <!-- /Main Nav -->

                <!-- Aside Nav -->
                <div id="nav-aside">
                    <!-- nav -->
                    <div class="section-row">
                        <ul class="nav-aside-menu">
                            <li><a href="index.html">Home</a></li>
                            <li><a href="about.html">About Us</a></li>
                            <li><a href="#">Join Us</a></li>
                            <li><a href="#">Advertisement</a></li>
                            <li><a href="contact.html">Contacts</a></li>
                        </ul>
                    </div>
                    <!-- /nav -->

                    <!-- widget posts -->
                    <div class="section-row">
                        <h3>Recent Posts</h3>
                        <div class="post post-widget">
                            <a class="post-img" href="blog-post.html"><img src="./img/widget-2.jpg" alt=""></a>
                            <div class="post-body">
                                <h3 class="post-title"><a href="blog-post.html">Pagedraw UI Builder Turns Your Website Design Mockup Into Code Automatically</a></h3>
                            </div>
                        </div>

                        <div class="post post-widget">
                            <a class="post-img" href="blog-post.html"><img src="./img/widget-3.jpg" alt=""></a>
                            <div class="post-body">
                                <h3 class="post-title"><a href="blog-post.html">Why Node.js Is The Coolest Kid On The Backend Development Block!</a></h3>
                            </div>
                        </div>

                        <div class="post post-widget">
                            <a class="post-img" href="blog-post.html"><img src="./img/widget-4.jpg" alt=""></a>
                            <div class="post-body">
                                <h3 class="post-title"><a href="blog-post.html">Tell-A-Tool: Guide To Web Design And Development Tools</a></h3>
                            </div>
                        </div>
                    </div>
                    <!-- /widget posts -->

                    <!-- social links -->
                    <div class="section-row">
                        <h3>Follow us</h3>
                        <ul class="nav-aside-social">
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                            <li><a href="#"><i class="fa fa-pinterest"></i></a></li>
                        </ul>
                    </div>
                    <!-- /social links -->

                    <!-- aside nav close -->
                    <button class="nav-aside-close"><i class="fa fa-times"></i></button>
                    <!-- /aside nav close -->
                </div>
                <!-- Aside Nav -->
            </div>
            <!-- /Nav -->

            <!-- Page Header -->
            <div class="page-header">
                <div class="container">
                    <div class="row">
                        <div class="col-md-10">
                            <ul class="page-header-breadcrumb">
                                <li><a href="index.html">Home</a></li>
                                <li>Thông tin cá nhân</li>
                            </ul>
                            <h1>Thông tin cá nhân</h1>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /Page Header -->
        </header>
        <!-- /Header -->

        <!-- section -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- jumbotron -->
                ` <div class="jumbotron">
                    <%
                        //String masv = request.getParameter("username");
                        Student student = null;
                        if (session.getAttribute("student") != null) {
                            student = (Student) session.getAttribute("student");
                        }
                        String masv = student.getsId();
                        student = new StudentDAO().getStudent(masv);
                    %>
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
                                    <span class="text-muted" id="hotensv"><%=student.getLastName() + " " + student.getFirstName() %></span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between lh-condensed">
                                    <div>
                                        <h6 class="my-0">Mã Lớp</h6>
                                    </div>
                                    <span class="text-muted" id="malop"><%=student.getsClass() %></span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between bg-light">
                                    <div class="text">
                                        <h6 class="my-0">Ngày sinh</h6>
                                    </div>
                                    <span class="text" id="ngaysinh"><%=student.getDateOfBirth() %></span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between bg-light">
                                    <div class="text">
                                        <h6 class="my-0">Giới tính</h6>
                                    </div>
                                    <span class="text" id="gioitinh"><%=student.getSex() %></span>
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
                            <form class="needs-validation" novalidate>
                                <div class="row">
                                    <div class="col-md-6 mb-3">
                                        <label for="firstName">Họ</label>
                                        <input type="text" class="form-control" id="inputHo" placeholder="" value="">

                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <label for="lastName">Tên</label>
                                        <input type="text" class="form-control" id="inputTen" placeholder="" value="">

                                    </div>
                                </div>

                                <div class="mb-3">
                                    <label for="username">Ngày sinh</label>
                                    <div class="input-group">

                                        <input type="text" class="form-control" id="inputNgaysinh">

                                    </div>
                                    <label for="username">Giới tính</label>
                                    <div class="input-group">

                                        <input type="text" class="form-control" id="inputGioitinh">

                                    </div>
                                    <label for="username">Nơi sinh</label>
                                    <div class="input-group">

                                        <input type="text" class="form-control" id="inputNoisinh">

                                    </div>
                                    <label for="username">Nơi sinh</label>
                                    <div class="input-group">

                                        <input type="text" class="form-control" id="inputNoisinh">

                                    </div>

                                </div>
                                <hr class="mb-4">

                                <button class="btn btn-outline-primary primary-button" type="submit" id="button_update">Update</button>
                                <button class="btn btn-outline-primary primary-button" type="submit">Hủy</button>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- /row -->
            </div>
            <!-- /jumbotron -->
        </div>
        <!-- /container -->
    </div>
    <!-- /section -->

    <!-- Footer -->
    <footer id="footer">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <div class="col-md-5">
                    <div class="footer-widget">
                        <div class="footer-logo">
                            <a href="index.html" class="logo"><img src="./img/logo.png" alt=""></a>
                        </div>
                        <ul class="footer-nav">
                            <li><a href="#">Privacy Policy</a></li>
                            <li><a href="#">Advertisement</a></li>
                        </ul>
                        <div class="footer-copyright">
                            <span>&copy; <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></span>
                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="footer-widget">
                                <h3 class="footer-title">About Us</h3>
                                <ul class="footer-links">
                                    <li><a href="about.html">About Us</a></li>
                                    <li><a href="#">Join Us</a></li>
                                    <li><a href="contact.html">Contacts</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="footer-widget">
                                <h3 class="footer-title">Catagories</h3>
                                <ul class="footer-links">
                                    <li><a href="category.html">Web Design</a></li>
                                    <li><a href="category.html">JavaScript</a></li>
                                    <li><a href="category.html">Css</a></li>
                                    <li><a href="category.html">Jquery</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="footer-widget">
                        <h3 class="footer-title">Join our Newsletter</h3>
                        <div class="footer-newsletter">
                            <form>
                                <input class="input" type="email" name="newsletter" placeholder="Enter your email">
                                <button class="newsletter-btn"><i class="fa fa-paper-plane"></i></button>
                            </form>
                        </div>
                        <ul class="footer-social">
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                            <li><a href="#"><i class="fa fa-pinterest"></i></a></li>
                        </ul>
                    </div>
                </div>

            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </footer>
    <!-- /Footer -->

    <!-- jQuery Plugins -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>

</body>

</html>
