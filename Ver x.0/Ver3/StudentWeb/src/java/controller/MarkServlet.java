/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.MarkDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Mark;
import model.Student;

/**
 *
 * @author admin
 */
public class MarkServlet extends HttpServlet {
    MarkDAO markDao = new MarkDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        PrintWriter out1 = response.getWriter();
        
        String maHKtext = request.getParameter("maHK");
        String maSV = request.getParameter("maSV");
        String url = "";
        out1.print(maSV);
        int maHK = Integer.parseInt(maHKtext);
        HttpSession session = request.getSession();
        
        try {
            if(maHKtext != null) {
                ArrayList<Mark> mark = markDao.getMark(maSV, maHK);
                session.setAttribute("mark", mark);
                url = "./page/mark.jsp";
            } else {
                url = "./page/index.jsp";
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            out1.println("<h1> WRONG " + ex + " Hello" + "</h1>");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
