/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.AdminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Admin;

/**
 *
 * @author Administrator
 */
public class AdminInfoServlet extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String maNV = request.getParameter("maNV");
        String ho = request.getParameter("ho");
        String ten = request.getParameter("ten");
        
        
        
        String url = "";
        HttpSession session = request.getSession();
        try {
            AdminDAO adminDAO = new AdminDAO();
            Admin admin = new Admin(username, password, maNV, ho, ten, maNV);
            boolean isSuccess = adminDAO.update(admin, maNV);
            System.out.println(admin);
            String message = "";
            if(isSuccess){
                url = "./admin/adminInfo.jsp";
                session.setAttribute("admin", admin);
                message = "Đã nhập xong!";
                request.setAttribute("message", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                dispatcher.forward(request, response);
            }
            else{
               url = "./admin/adminInfo.jsp";
                session.setAttribute("admin", admin);
                message = "Thất bại!";
                request.setAttribute("message", message);
                RequestDispatcher dispatcher =  request.getRequestDispatcher(url);
                dispatcher.forward(request, response);
            }
           
        }catch(Exception ex) {
            
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
