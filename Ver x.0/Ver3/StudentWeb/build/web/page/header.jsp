<%-- 
    Document   : header
    Created on : Dec 4, 2018, 8:51:06 AM
    Author     : admin
--%>

<%@page import="DAO.MarkDAO"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
        <%
            Student student = null;
            if(session.getAttribute("student") != null) {
                student = (Student) session.getAttribute("student");
            }
            
        %>
        <header id="header">
            <!-- Nav -->
            <div id="nav">
                <!-- Main Nav -->
                <div id="nav-fixed">
                    <div class="container">
                        <!-- logo -->
                        <div class="nav-logo">
                            <a href="${pageContext.request.contextPath}/page/index.jsp" class="logo">HỌC VIỆN CÔNG NGHỆ BƯU CHÍNH VIỄN THÔNG <br/></a>
                            
                        </div>
                        <!-- /logo -->

                        <!-- nav -->
                        <ul class="nav-menu nav navbar-nav">
                            <li class="cat-1"><a href="${pageContext.request.contextPath}/page/mark.jsp">Điểm</a></li>
                            <li class="cat-2"><a href="${pageContext.request.contextPath}/page/timeTable.jsp">TKB</a></li>
                            <li class="cat-3"><a href="${pageContext.request.contextPath}/page/studentInfo.jsp">TT Cá nhân</a></li>
                            <li class="cat-4"><a href="${pageContext.request.contextPath}/page/lichthi.jsp">Lịch thi</a></li>
                        </ul>
                        <!-- /nav -->

                        <!-- search & aside toggle -->
                        <div class="nav-btns">
                            <% if(student != null) { %>
                            <script type="text/javascript">
                                $(document).ready(function(){
                                    $('.login').remove();
                                });
                            </script>
                            <span id="welcome">Welcome <%=student.getLastName()%> <%=student.getFirstName()%></span>
                            <% } else { %>
                            <a class="primary-button" id = "login" onclick="location.href = '${pageContext.request.contextPath}/page/login.jsp';" > Đăng Nhập</a>
                            <% } %>
                            
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
                            <% if (student != null) {%>
                                <script type="text/javascript">
                                    $(document).ready(function(){
                                        $('.login-nav-side').remove();
                                    });
                                </script>
                                <li class="welcome-nav-aside">Welcome <%=student.getLastName()%> <%=student.getFirstName()%></li>
                                <li><a href="./index.jsp">Trang chủ</a></li>
                                <li><a href="${pageContext.request.contextPath}/page/timeTable.jsp">Thời khóa biểu</a></li>
                                <li><a href="${pageContext.request.contextPath}/page/mark.jsp">Điểm</a></li>
                                <li><a href="${pageContext.request.contextPath}/page/lichthi.jsp">Lịch thi</a></li>
                                <li><a href="${pageContext.request.contextPath}/page/studentInfo.jsp">Thông tin cá nhân</a></li>
                                <li><a href="${pageContext.request.contextPath}/page/logout.jsp">Đăng xuất</a></li>
                                <!-- Đăng ký nhận tin -->
                        </ul>
                    </div>
                    <div class="section-row nav-aside-menu">
                        <a class="welcome-nav-aside"href="${pageContext.request.contextPath}/page/registerEmail.jsp">Đăng ký nhận thông báo lịch học, lịch thi, tin tức</a>
                    </div>
                            <% } else { %>
                                <li><a href="${pageContext.request.contextPath}/page/timeTable.jsp">Thời khóa biểu</a></li>
                                <li><a href="${pageContext.request.contextPath}/page/mark.jsp">Điểm</a></li>
                                <li><a href="${pageContext.request.contextPath}/page/lichthi.jsp">Lịch thi</a></li>
                                <li class="cat-3"><a href="${pageContext.request.contextPath}/page/studentInfo.jsp">Thông tin cá nhân</a></li>
                                <li><a class=".login-nav-side" href="${pageContext.request.contextPath}/page/login.jsp">Đăng nhập</a></li>
                        </ul>
                    </div>      
                            <% }%>
                        
                    <!-- /nav -->
                    
                    
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
        </header>
        <!-- /Header -->

