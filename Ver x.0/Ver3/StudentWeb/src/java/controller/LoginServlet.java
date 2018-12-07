package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieHandler;
import java.net.CookieManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Student;

/**
 *
 * @author Administrator
 */
public class LoginServlet extends HttpServlet {
    StudentDAO studentDAO = new StudentDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Để hiển thị Tiếng Việt
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        //-----------
        PrintWriter out1 = response.getWriter();
   
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String result = "Đăng nhập sai :(";
        String url = "";
        HttpSession session = request.getSession();
        
        
        try {
            String mainQLDT = "http://qldt.ptit.edu.vn/";
            String defaultQLDT = "http://qldt.ptit.edu.vn/default.aspx";
            
            out1.print(url + " Hello");
            LoginControl http = new LoginControl();
            CookieHandler.setDefault(new CookieManager());
            http.GetCookie(mainQLDT);
            String postParams = http.getFormParams(username, password);
            http.sendPost(defaultQLDT, postParams);
            if(http.checkLogin(username)){
                Student student = studentDAO.getStudent(username);
                url = "./page/index.jsp";
                session.setAttribute("student", student);
            }
            else{
                url = "./page/login.jsp";
                out1.print(url + " goodbye");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
//            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
//            rd.forward(request, response);
        } catch (Exception ex) {
            out1.println("<h1> WRONG " + request.getContextPath() + "</h1>");
        }
        
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
