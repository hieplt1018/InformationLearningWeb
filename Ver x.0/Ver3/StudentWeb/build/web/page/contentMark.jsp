<%-- 
    Document   : aside
    Created on : Dec 4, 2018, 9:23:15 AM
    Author     : admin
--%>

<%@page import="model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.MarkDAO"%>
<%@page import="model.Mark"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <%
            Student student = null;
            MarkDAO markDAO = new MarkDAO();
            String studentId;
            ArrayList<Mark> mark1 = null;
            
            int maHK = 20172;
            // Nếu có khách login thành công
            if(session.getAttribute("student") != null) { 
                student = (Student) session.getAttribute("student");
                studentId = student.getsId();
                if( session.getAttribute("mark")!= null) {
                    mark1 = (ArrayList<Mark>) session.getAttribute("mark");
                    maHK = mark1.get(0).getSemesterID();
                }
        %>
        <!-- section -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <div class="col-md-8">
                        <div class="row">
<!--                             post -->
                            <form action="${pageContext.request.contextPath}/MarkServlet"  method="post">
                                <div class="form-group">
                                    <label for="inputSemester">Nhập học kỳ xem điểm thi (ví dụ: 20171): </label>
                                    <input name="maHK" type="text" class="form-control" id="inputSemester" aria-describedby="" placeholder="Nhập học kỳ" value="" required autofocus>
                                    <input style="visibility:hidden" name="maSV" type="text" class="form-control" id="inputmaSV" aria-describedby="" placeholder="" value="<%=studentId%>" required autofocus>
                                    <small id="maHK_help" class="form-text text-muted">20171: Học kỳ 1 năm học 2017-2018</small>
                                </div>
                                <button type="submit" class="btn btn-primary">Xem điểm</button>
                            </form>
                            <h3 class="text-center">Điểm học kỳ: <%=maHK%></h3>
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered mt-3 mb-0">
                                    <thead class="thead-dark">
                                        <tr id="theadTable">
                                            <th>STT</th>
                                            <th>Mã môn</th>
                                            <th>Tên môn</th>
                                            <th>Điểm TK</th>
                                            <th>Điểm chữ</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        
                                    <%
                                        ArrayList<Mark> listMark = markDAO.getMark(studentId, maHK);
                                            int count = 0;
                                            for (Mark mark : listMark) {
                                                count++;
                                    %>
                                        <tr>
                                            <td class="data"><%=count%></td>
                                            <td class="data"><%=mark.getSubjectID()%></td>
                                            <td class="data"><%=mark.getSubjectName()%></td>
                                            <td class="data"><%=mark.getDiemTK()%></td>
                                            <td class="data"><%=mark.getDiemChu()%></td>
                                        </tr>
                                    </tbody>
        <%
                }
            } else { // Nếu không có ai login
        %> 
        <!-- section -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <div class="col-md-8">
                        <div class="row">
                            <!--                             post -->
                            <form action=".${pageContext.request.contextPath}/page/MarkServlet"  method="post">
                                <div class="form-group">
                                    <label for="inputSemester">Nhập học kỳ xem điểm thi (ví dụ: 20171): </label>
                                    <input name="maHK" type="text" class="form-control" id="inputSemester" aria-describedby="" placeholder="Nhập học kỳ" value="" required autofocus>
                                    <input style="visibility:hidden" name="maSV" type="text" class="form-control" id="inputmaSV" aria-describedby="" placeholder="" value="" required autofocus>
                                    <small id="maHK_help" class="form-text text-muted">20171: Học kỳ 1 năm học 2017-2018</small>
                                </div>
                                <button type="submit" class="btn btn-primary">Xem điểm</button>
                            </form>
                            <h3 class="text-center">Điểm học kỳ: <%=maHK%></h3>
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered mt-3 mb-0">
                                    <thead class="thead-dark">
                                        <tr id="theadTable">
                                            <th>STT</th>
                                            <th>Mã môn</th>
                                            <th>Tên môn</th>
                                            <th>Điểm TK</th>
                                            <th>Điểm chữ</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td class="data"></td>
                                            <td class="data"></td>
                                            <td class="data"></td>
                                            <td class="data"></td>
                                            <td class="data"></td>
                                        </tr>
                                    </tbody>
        <%
            }
        %>
                                </table>
                            </div>
                        </div>	
                    </div>

                    <div class="col-md-4">
                        <!-- ad -->
                        <div class="aside-widget text-center">
                            <a href="#" style="display: inline-block;margin: auto;">
                                <img class="img-responsive" src="${pageContext.request.contextPath}/page/img/ad-1.jpg" alt="">
                            </a>
                        </div>
                        <!-- /ad -->

                        <!-- post widget -->
                        <div class="aside-widget">
                            <div class="section-title">
                                <h2>Most Read</h2>
                            </div>

                            <div class="post post-widget">
                                <a class="post-img" href="blog-post.html"><img src="${pageContext.request.contextPath}/page/img/widget-1.jpg" alt=""></a>
                                <div class="post-body">
                                    <h3 class="post-title"><a href="blog-post.html">Tell-A-Tool: Guide To Web Design And Development Tools</a></h3>
                                </div>
                            </div>

                            <div class="post post-widget">
                                <a class="post-img" href="blog-post.html"><img src="${pageContext.request.contextPath}/page/img/widget-2.jpg" alt=""></a>
                                <div class="post-body">
                                    <h3 class="post-title"><a href="blog-post.html">Pagedraw UI Builder Turns Your Website Design Mockup Into Code Automatically</a></h3>
                                </div>
                            </div>

                            <div class="post post-widget">
                                <a class="post-img" href="blog-post.html"><img src="${pageContext.request.contextPath}/page/img/widget-3.jpg" alt=""></a>
                                <div class="post-body">
                                    <h3 class="post-title"><a href="blog-post.html">Why Node.js Is The Coolest Kid On The Backend Development Block!</a></h3>
                                </div>
                            </div>

                            <div class="post post-widget">
                                <a class="post-img" href="blog-post.html"><img src="${pageContext.request.contextPath}/page/img/widget-4.jpg" alt=""></a>
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

