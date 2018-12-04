<%-- 
    Document   : aside
    Created on : Dec 4, 2018, 9:23:15 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- section -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <div class="col-md-8">
                        <div class="row">
                            <!-- post -->
                            <div class="select">
                                <select id="select-menu-diem">
                                    <option value="20171" id="muathu2017">Kỳ 1 năm 2017</option>
                                    <option value="20172" id="muahe2017" selected="selected">Kỳ 2 năm 2017</option>
                                </select>
                            </div>
                            <div class="select">
                                <select id="select-menu-hienthidiem">
                                    <option value="generalMark" id="generalMark">Xem điểm tổng quan</option>
                                    <option value="detailMark" id="detailMark" selected="selected">Xem điểm cụ thể</option>
                                </select>
                            </div>

                            <table class="table table-striped table-bordered mt-3 mb-0">
                                <thead class="thead-dark">
                                    <tr id="theadTable">
                                    </tr>
                                </thead>
                                <tbody class="table table-striped" id="showdiem">
                                </tbody>
                            </table>
                        </div>	
                    </div>


                    <div class="col-md-4">
                        <!-- ad -->
                        <div class="aside-widget text-center">
                            <a href="#" style="display: inline-block;margin: auto;">
                                <img class="img-responsive" src="./img/ad-1.jpg" alt="">
                            </a>
                        </div>
                        <!-- /ad -->

                        <!-- post widget -->
                        <div class="aside-widget">
                            <div class="section-title">
                                <h2>Most Read</h2>
                            </div>

                            <div class="post post-widget">
                                <a class="post-img" href="blog-post.html"><img src="./img/widget-1.jpg" alt=""></a>
                                <div class="post-body">
                                    <h3 class="post-title"><a href="blog-post.html">Tell-A-Tool: Guide To Web Design And Development Tools</a></h3>
                                </div>
                            </div>

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
                        <!-- /post widget -->

                        <!-- catagories -->
                        <div class="aside-widget">
                            <div class="section-title">
                                <h2>Catagories</h2>
                            </div>
                            <div class="category-widget">
                                <ul>
                                    <li><a href="#" class="cat-1">Web Design<span>340</span></a></li>
                                    <li><a href="#" class="cat-2">JavaScript<span>74</span></a></li>
                                    <li><a href="#" class="cat-4">JQuery<span>41</span></a></li>
                                    <li><a href="#" class="cat-3">CSS<span>35</span></a></li>
                                </ul>
                            </div>
                        </div>
                        <!-- /catagories -->

                        <!-- tags -->
                        <div class="aside-widget">
                            <div class="tags-widget">
                                <ul>
                                    <li><a href="#">Chrome</a></li>
                                    <li><a href="#">CSS</a></li>
                                    <li><a href="#">Tutorial</a></li>
                                    <li><a href="#">Backend</a></li>
                                    <li><a href="#">JQuery</a></li>
                                    <li><a href="#">Design</a></li>
                                    <li><a href="#">Development</a></li>
                                    <li><a href="#">JavaScript</a></li>
                                    <li><a href="#">Website</a></li>
                                </ul>
                            </div>
                        </div>
                        <!-- /tags -->

                        <!-- archive -->
                        <div class="aside-widget">
                            <div class="section-title">
                                <h2>Archive</h2>
                            </div>
                            <div class="archive-widget">
                                <ul>
                                    <li><a href="#">Jan 2018</a></li>
                                    <li><a href="#">Feb 2018</a></li>
                                    <li><a href="#">Mar 2018</a></li>
                                </ul>
                            </div>
                        </div>
                        <!-- /archive -->
                    </div>
                </div>
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /section -->
    </body>
</html>
