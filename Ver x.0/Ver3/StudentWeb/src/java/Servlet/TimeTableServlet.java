/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.TimeTableDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Student;
import model.TimeTable;

/**
 *
 * @author Nam Anh
 */
public class TimeTableServlet extends HttpServlet {
    
    TimeTableDAO timeTableDao = new TimeTableDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Student student = null;
        String studentId = "";
        if (session.getAttribute("student") != null) {
            student = (Student) session.getAttribute("student");
            studentId = student.getsId();
        }
        try {
            if (studentId != null) {
                ArrayList<TimeTable> timeTable = timeTableDao.getPersonalTimeTable(studentId);
                String json = new Gson().toJson(timeTable);

                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);
            }
        } catch (Exception ex) {
            System.out.println("Error in TImeTableServlet");
            System.err.println(ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
