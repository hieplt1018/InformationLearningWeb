<%-- 
    Document   : contentIndex
    Created on : Dec 4, 2018, 8:54:44 AM
    Author     : admin
--%>

<%@page import="controller.DateControl"%>
<%@page import="model.News"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.NewsUpdateControl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <%
            NewsUpdateControl newsCtr = new NewsUpdateControl();
            newsCtr.start(); //Chuyển nó sang admin.jsp để không khởi tạo quá nhiều luồng
            
            ArrayList<News> newsListPost = newsCtr.getNewsPost();
            ArrayList<News> newsGiaoVuList = newsCtr.getNewsGiaoVu();
            ArrayList<News> newsTTKTList = newsCtr.getNewsTTKT();
            DateControl dateCtr = new DateControl();
            String toDay = dateCtr.getToday();
            String thongBao = "";
            if (session.getAttribute("email") != null) { 
                thongBao = (String) session.getAttribute("email");
            } else if (session.getAttribute("thongBao") != null) {
                thongBao = (String) session.getAttribute("thongBao");
            } else {
                thongBao = "";
            }
        %>
        <!-- section -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                    <!-- post -->
                    <div class="row">
                        <marquee id="thongBao"><%=thongBao%></marquee>     
                        <marquee id="hot"><span style=\"color:red; text-transform: uppercase\">HOT!!! </span> <a href=\"registerEmail.jsp\"> Click để đăng ký nhận thông báo lịch học, lịch thi, tin tức qua email tại đây!!!!</a></marquee>      
                    <div class="col-md-6">
                        <div class="post">
                            <a class="post-img" href="<%=newsListPost.get(0).getUrl()%>"><img src="<%=newsListPost.get(0).getImage()%>" alt=""></a>
                            <div class="post-body">
                                <div class="post-meta">
                                    <a class="post-category cat-2" href="#"><%=newsListPost.get(0).getCategory()%></a>
                                </div>
                                <h3 class="post-title"><a href="<%=newsListPost.get(0).getUrl()%>"><%=newsListPost.get(0).getTitle()%></a></h3>
                            </div> 
                        </div>
                           
                    </div>
                    <!-- /post -->

                    <!-- post -->
                    <div class="col-md-6">
                        <div class="post">
                            <a class="post-img" href="<%=newsListPost.get(1).getUrl()%>"><img src="<%=newsListPost.get(1).getImage()%>" alt=""></a>
                            <div class="post-body">
                                <div class="post-meta">
                                    <a class="post-category cat-2" href="#"><%=newsListPost.get(1).getCategory()%></a>
                                </div>
                                <h3 class="post-title"><a href="blog-post.html"><%=newsListPost.get(1).getTitle()%></a></h3>
                            </div>
                        </div>
                    </div>
                    <!-- /post -->
                </div>
                <!-- /row -->

                <!-- row -->
                <div class="row">
                    <div class="col-md-12">
                        <div class="section-title">
                            <h2>Tin tức</h2>
                        </div>
                    </div>

                    <!-- post -->
                    <div class="col-md-4">
                        <div class="post">
                            <div class="post">
                                <a class="post-img" href="<%=newsListPost.get(0).getUrl()%>"><img src="<%=newsListPost.get(0).getImage()%>" alt=""></a>
                                <div class="post-body">
                                    <div class="post-meta">
                                        <a class="post-category cat-2" href="#"><%=newsListPost.get(0).getCategory()%></a>
                                    </div>
                                    <h3 class="post-title"><a href="<%=newsListPost.get(0).getUrl()%>"><%=newsListPost.get(0).getTitle()%></a></h3>
                                </div> 
                            </div>
                        </div>
                    </div>
                    <!-- /post -->

                    <!-- post -->
                    <div class="col-md-4">
                        <div class="post">
                            <a class="post-img" href="<%=newsListPost.get(1).getUrl()%>"><img src="<%=newsListPost.get(1).getImage()%>" alt=""></a>
                            <div class="post-body">
                                <div class="post-meta">
                                    <a class="post-category cat-2" href="#"><%=newsListPost.get(1).getCategory()%></a>
                                </div>
                                <h3 class="post-title"><a href="blog-post.html"><%=newsListPost.get(1).getTitle()%></a></h3>
                            </div>
                        </div>
                    </div>
                    <!-- /post -->

                    <!-- post -->
                    <div class="col-md-4">
                        <div class="post">
                            <a class="post-img" href="<%=newsListPost.get(2).getUrl()%>"><img src="<%=newsListPost.get(2).getImage()%>" alt=""></a>
                            <div class="post-body">
                                <div class="post-meta">
                                    <a class="post-category cat-2" href="#"><%=newsListPost.get(2).getCategory()%></a>
                                </div>
                                <h3 class="post-title"><a href="blog-post.html"><%=newsListPost.get(2).getTitle()%></a></h3>
                            </div>
                        </div>
                    </div>
                    <!-- /post -->

                    <div class="clearfix visible-md visible-lg"></div>

                    <!-- post -->
                    <div class="col-md-4">
                        <div class="post">
                            <a class="post-img" href="<%=newsListPost.get(3).getUrl()%>"><img src="<%=newsListPost.get(3).getImage()%>" alt=""></a>
                            <div class="post-body">
                                <div class="post-meta">
                                    <a class="post-category cat-2" href="#"><%=newsListPost.get(3).getCategory()%></a>
                                </div>
                                <h3 class="post-title"><a href="<%=newsListPost.get(3).getUrl()%>"><%=newsListPost.get(3).getTitle()%></a></h3>
                            </div> 
                        </div>
                    </div>
                    <!-- /post -->

                    <!-- post -->
                    <div class="col-md-4">
                        <div class="post">
                            <a class="post-img" href="<%=newsListPost.get(4).getUrl()%>"><img src="<%=newsListPost.get(4).getImage()%>" alt=""></a>
                            <div class="post-body">
                                <div class="post-meta">
                                    <a class="post-category cat-2" href="#"><%=newsListPost.get(4).getCategory()%></a>
                                </div>
                                <h3 class="post-title"><a href="<%=newsListPost.get(4).getUrl()%>"><%=newsListPost.get(4).getTitle()%></a></h3>
                            </div> 
                        </div>
                    </div>
                    <!-- /post -->

                    <!-- post -->
                    <div class="col-md-4">
                        <div class="post">
                            <a class="post-img" href="<%=newsListPost.get(5).getUrl()%>"><img src="<%=newsListPost.get(5).getImage()%>" alt=""></a>
                            <div class="post-body">
                                <div class="post-meta">
                                    <a class="post-category cat-2" href="#"><%=newsListPost.get(5).getCategory()%></a>
                                </div>
                                <h3 class="post-title"><a href="<%=newsListPost.get(5).getUrl()%>"><%=newsListPost.get(5).getTitle()%></a></h3>
                            </div> 
                        </div>
                    </div>
                    <!-- /post -->
                </div>
                <!-- /row -->

                <!-- row -->
                <div class="row">
                    <div class="col-md-12">
                        <div class="section-title">
                            <h2>Giáo vụ</h2>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="row">
                            <!-- post -->
                            <div class="col-md-12">
                                <div class="post post-thumb">
                                    <a class="post-img" href="<%=newsGiaoVuList.get(0).getUrl()%>"><img src="<%=newsGiaoVuList.get(0).getImage()%>" alt=""></a>
                                    <div class="post-body">
                                        <div class="post-meta">
                                            <a class="post-category cat-3" href="#"><%=newsGiaoVuList.get(0).getCategory()%></a>
                                        </div>
                                        <h3 class="post-title"><a href="<%=newsGiaoVuList.get(0).getUrl()%>"><%=newsGiaoVuList.get(0).getTitle()%></a></h3>
                                    </div>
                                </div>
                            </div>
                            <!-- /post -->

                            <!-- post -->
                            <div class="col-md-6">
                                <div class="post">
                                    <a class="post-img" href="<%=newsGiaoVuList.get(1).getUrl()%>"><img src="<%=newsGiaoVuList.get(1).getImage()%>" alt=""></a>
                                    <div class="post-body">
                                        <div class="post-meta">
                                            <a class="post-category cat-3" href="#"><%=newsGiaoVuList.get(1).getCategory()%></a>
                                        </div>
                                        <h3 class="post-title"><a href="<%=newsGiaoVuList.get(1).getUrl()%>"><%=newsGiaoVuList.get(1).getTitle()%></a></h3>
                                    </div>
                                </div>
                            </div>
                            <!-- /post -->

                            <!-- post -->
                            <div class="col-md-6">
                                <div class="post">
                                    <a class="post-img" href="<%=newsGiaoVuList.get(2).getUrl()%>"><img src="<%=newsGiaoVuList.get(2).getImage()%>" alt=""></a>
                                    <div class="post-body">
                                        <div class="post-meta">
                                            <a class="post-category cat-3" href="#"><%=newsGiaoVuList.get(1).getCategory()%></a>
                                        </div>
                                        <h3 class="post-title"><a href="<%=newsGiaoVuList.get(2).getUrl()%>"><%=newsGiaoVuList.get(2).getTitle()%></a></h3>
                                    </div>
                                </div>
                            </div>
                            <!-- /post -->

                            <div class="clearfix visible-md visible-lg"></div>

                            <!-- post -->
                            <div class="col-md-6">
                                <div class="post">
                                    <a class="post-img" href="<%=newsGiaoVuList.get(3).getUrl()%>"><img src="<%=newsGiaoVuList.get(3).getImage()%>" alt=""></a>
                                    <div class="post-body">
                                        <div class="post-meta">
                                            <a class="post-category cat-3" href="#"><%=newsGiaoVuList.get(3).getCategory()%></a>
                                        </div>
                                        <h3 class="post-title"><a href="<%=newsGiaoVuList.get(3).getUrl()%>"><%=newsGiaoVuList.get(3).getTitle()%></a></h3>
                                    </div>
                                </div>
                            </div>
                            <!-- /post -->

                            <!-- post -->
                            <div class="col-md-6">
                                <div class="post">
                                    <a class="post-img" href="<%=newsGiaoVuList.get(4).getUrl()%>"><img src="<%=newsGiaoVuList.get(4).getImage()%>" alt=""></a>
                                    <div class="post-body">
                                        <div class="post-meta">
                                            <a class="post-category cat-3" href="#"><%=newsGiaoVuList.get(4).getCategory()%></a>
                                        </div>
                                        <h3 class="post-title"><a href="<%=newsGiaoVuList.get(4).getUrl()%>"><%=newsGiaoVuList.get(4).getTitle()%></a></h3>
                                    </div>
                                </div>
                            </div>
                            <!-- /post -->

                            <div class="clearfix visible-md visible-lg"></div>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <!-- post widget -->
                        <div class="aside-widget">
                            <div class="section-title">
                                <h2>Đọc nhiều nhất</h2>
                            </div>
                            <div class="post post-thumb">
                                <a class="post-img" href="<%=newsListPost.get(0).getUrl()%>"><img src="<%=newsListPost.get(0).getImage()%>" alt=""></a>
                                    <div class="post-body">
                                        <div class="post-meta">
                                            <a class="post-category cat-2" href="#"><%=newsListPost.get(0).getCategory()%></a>
                                        </div>
                                        <h3 class="post-title"><a href="<%=newsListPost.get(0).getUrl()%>"><%=newsListPost.get(0).getTitle()%></a></h3>
                                    </div>
                                </div>
                            </div>

                            <div class="post post-thumb">
                                <a class="post-img" href="<%=newsTTKTList.get(0).getUrl()%>"><img src="<%=newsTTKTList.get(0).getImage()%>" alt=""></a>
                                <div class="post-body">
                                    <div class="post-meta">
                                        <a class="post-category cat-4" href="#"><%=newsTTKTList.get(0).getCategory()%></a>
                                    </div>
                                    <h3 class="post-title"><a href="<%=newsTTKTList.get(0).getUrl()%>"><%=newsTTKTList.get(0).getTitle()%></a></h3>
                                </div>
                            </div>
                            </div>
                        </div>
                        <!-- /post widget -->

                        <!-- ad -->
                        <div class="aside-widget text-center">
                            <a href="#" style="display: inline-block;margin: auto;">
                                <img class="img-responsive" src="${pageContext.request.contextPath}/page/img/ad-1.jpg" alt="">
                            </a>
                        </div>
                        <!-- /ad -->
                    </div>
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /section -->

        <!-- section -->
        <div class="section section-grey">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <div class="col-md-12">
                        <div class="section-title text-center">
                            <h2>Trung tâm khảo thí</h2>
                        </div>
                    </div>

                    <!-- post -->
                    <div class="col-md-4">
                        <div class="post">
                            <a class="post-img" href="<%=newsTTKTList.get(0).getUrl()%>"><img src="<%=newsTTKTList.get(0).getImage()%>" alt=""></a>
                            <div class="post-body">
                                <div class="post-meta">
                                    <a class="post-category cat-4" href="#"><%=newsTTKTList.get(0).getCategory()%></a>
                                </div>
                                <h3 class="post-title"><a href="<%=newsTTKTList.get(0).getUrl()%>"><%=newsTTKTList.get(0).getTitle()%></a></h3>
                            </div>
                        </div>
                    </div>
                    
                    <!-- /post -->

                    <!-- post -->
                    <div class="col-md-4">
                        <div class="post">
                            <a class="post-img" href="<%=newsTTKTList.get(1).getUrl()%>"><img src="<%=newsTTKTList.get(1).getImage()%>" alt=""></a>
                            <div class="post-body">
                                <div class="post-meta">
                                    <a class="post-category cat-4" href="#"><%=newsTTKTList.get(1).getCategory()%></a>
                                </div>
                                <h3 class="post-title"><a href="<%=newsTTKTList.get(1).getUrl()%>"><%=newsTTKTList.get(1).getTitle()%></a></h3>
                            </div>
                        </div>
                    </div>
                    <!-- /post -->

                    <!-- post -->
                    <div class="col-md-4">
                        <div class="post">
                            <a class="post-img" href="<%=newsTTKTList.get(2).getUrl()%>"><img src="<%=newsTTKTList.get(2).getImage()%>" alt=""></a>
                            <div class="post-body">
                                <div class="post-meta">
                                    <a class="post-category cat-4" href="#"><%=newsTTKTList.get(2).getCategory()%></a>
                                </div>
                                <h3 class="post-title"><a href="<%=newsTTKTList.get(2).getUrl()%>"><%=newsTTKTList.get(2).getTitle()%></a></h3>
                            </div>
                        </div>
                    </div>
                    <!-- /post -->
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /section -->
        