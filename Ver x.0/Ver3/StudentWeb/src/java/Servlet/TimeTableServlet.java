/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.TimeTableDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        String maSV = request.getParameter("maSV");
        HttpSession session = request.getSession();
        String url = "";
        try {
            if(maSV != null) {
                ArrayList<TimeTable> timeTable = timeTableDao.getTimeTable(maSV);
                session.setAttribute("timeTable", timeTable);
                url = "./page/index.jsp";
            } else {
                url = "./page/index.jsp";
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            System.out.println("Error in TImeTableServlet");
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
