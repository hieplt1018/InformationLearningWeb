/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class RegisterEmailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StudentDAO studentDAO = new StudentDAO();
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        System.out.println(username + ": " + email);
        String url = "./page/index.jsp";
        String thongBaoEmail = null;
        HttpSession session = request.getSession();
        try {
            if(!email.equalsIgnoreCase("")){
                studentDAO.updateEmail(username, email);
                thongBaoEmail = "Bạn đã đăng ký thành công nhận tin thành công tại email: " + email;
            } else {
                thongBaoEmail = "Đăng ký không thành công. Vui lòng liên hệ với admin!";
            }
            session.setAttribute("email", thongBaoEmail);
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(RegisterEmailServlet.class.getName()).log(Level.SEVERE, null, ex);
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
