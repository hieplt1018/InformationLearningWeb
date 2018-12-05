package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieHandler;
import java.net.CookieManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String result = "Đăng nhập sai :(";
//       
//        try {
//            String mainQLDT = "http://qldt.ptit.edu.vn/";
//            String defaultQLDT = "http://qldt.ptit.edu.vn/default.aspx";
//             
//            LoginControl http = new LoginControl();
//            
//            CookieHandler.setDefault(new CookieManager());
//            http.GetCookie(mainQLDT);
//            String postParams = http.getFormParams(username, password);
//            http.sendPost(defaultQLDT, postParams);
//            if(http.checkLogin(username)){
//                RequestDispatcher dispatcher = request.getRequestDispatcher("./page/index.jsp");
//                        dispatcher.forward(request, response);
//                      //  request.setAttribute("username", username);
////                response.sendRedirect("./pag"e/newjsp.jsp");
//            }
//            else{
//                response.sendRedirect("./page/login.jsp");
//            }
//            
//        } catch (Exception ex) {
//            
//        }
//        
//        
//    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out1 = response.getWriter();
        
            /* TODO output your page here. You may use following sample code. */
            
            out1.println("kkk");
        
        
        
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String result = "Đăng nhập sai :(";
       
        try {
            String mainQLDT = "http://qldt.ptit.edu.vn/";
            String defaultQLDT = "http://qldt.ptit.edu.vn/default.aspx";
             
            LoginControl http = new LoginControl();
            out1.println("hELLO " + request.getContextPath());
            CookieHandler.setDefault(new CookieManager());
            out1.println("hELLO1 " + request.getContextPath());
            http.GetCookie(mainQLDT);
            out1.println("hELLO2 " + username+password);
            String postParams = http.getFormParams(username, password);
            out1.println("hELLO3 " + request.getContextPath());
            http.sendPost(defaultQLDT, postParams);
            out1.println("hELLO4 " + request.getContextPath());
            if(http.checkLogin(username)){
                out1.println("hELLO "+username);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/page/index.jsp");
                        dispatcher.forward(request, response);
                        out1.println("hELLO2 "+username);
                      //  request.setAttribute("username", username);
//                response.sendRedirect("./pag"e/newjsp.jsp");
            }
            else{
                out1.println("no "+username);
                response.sendRedirect("../page/login.jsp");
            }
            
        } catch (Exception ex) {
            out1.println("<h1>wRONG " + ex.getMessage() + "</h1>");
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
