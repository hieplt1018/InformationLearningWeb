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
                            <form action="${pageContext.request.contextPath}/MarksServlet"  method="post">
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
                        <jsp:include page="newsSide.jsp"></jsp:include>
                    </div>
                </div>
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /section -->

