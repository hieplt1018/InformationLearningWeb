<%-- 
    Document   : contentLichThi
    Created on : Dec 30, 2018, 12:08:29 PM
    Author     : Admin
--%>

<%@page import="model.LichThi"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Student"%>
<%@page import="DAO.LichThiDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Student student = null;
    LichThiDAO lichThiDao = new LichThiDAO();
    String studentId;
    ArrayList<LichThi> lichThi1 = null;

    int maHK = 20172;
    // Nếu có khách login thành công
    if (session.getAttribute("student") != null) {
        student = (Student) session.getAttribute("student");
        studentId = student.getsId();
        
%>
<!-- section -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-8">
                <div class="row">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered mt-3 mb-0">
                            <thead class="thead-dark">
                                <tr id="theadTable">
                                    <th>STT</th>
                                    <th>Mã môn</th>
                                    <th>Tên môn</th>
                                    <th>Nhóm</th>
                                    <th>Ngày thi</th>
                                    <th>Phòng thi</th>
                                    <th>Giờ thi</th>
                                </tr>
                            </thead>
                            <tbody>

                                <%
                                    lichThi1 = lichThiDao.getLichThi(studentId);
                                    int count = 0;
                                    for (LichThi lt : lichThi1) {
                                        count++;
                                %>
                                <tr>
                                    <td class="data"><%=count%></td>
                                    <td class="data"><%=lt.getMaMH()%></td>
                                    <td class="data"><%=lt.getTenMH()%></td>
                                    <td class="data"><%=lt.getMaNhom()%></td>
                                    <td class="data"><%=lt.getNgayThi()%></td>
                                    <td class="data"><%=lt.getPhongThi()%></td>
                                    <td class="data"><%=lt.getGioBD()%></td>
                                </tr>
                            </tbody>
                            <%
                                    }
                                }

            
                                    else { // Nếu không có ai login
                            %> 
                            <!-- section -->
                            <div class="section">
                                <!-- container -->
                                <div class="container">
                                    <!-- row -->
                                    <div class="row">
                                        <div class="col-md-8">
                                            <div class="row">
                                                <div class="table-responsive">
                                                    <table class="table table-striped table-bordered mt-3 mb-0">
                                                        <thead class="thead-dark">
                                                            <tr id="theadTable">
                                                                <th>STT</th>
                                                                <th>Mã môn</th>
                                                                <th>Tên môn</th>
                                                                <th>Nhóm</th>
                                                                <th>Ngày thi</th>
                                                                <th>Phòng thi</th>
                                                                <th>Giờ thi</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td class="data"></td>
                                                                <td class="data"></td>
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
                            </div>