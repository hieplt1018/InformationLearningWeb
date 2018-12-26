package Servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.LichThiDAO;
import controller.LoginControl;
import DAO.StudentDAO;
import controller.SendMail;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
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
    LichThiDAO lichThiDao = new LichThiDAO();
    
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
        
        //String result = "Đăng nhập sai :(";
        String url = "";
        String thongBao = "";
        HttpSession session = request.getSession();
        
        try {
            String mainQLDT = "http://qldt.ptit.edu.vn/";
            String defaultQLDT = "http://qldt.ptit.edu.vn/default.aspx";
            
            
            LoginControl http = new LoginControl();
            CookieHandler.setDefault(new CookieManager());
            http.GetCookie(mainQLDT);
            String postParams = http.getFormParams(username, password);
            http.sendPost(defaultQLDT, postParams);
            System.out.println(username + " " + password);
            
            if(http.checkLogin(username)) {
                studentDAO.updatePassword(username, password);
                Student student = studentDAO.getStudent(username);
                String email = student.getEmail();
                System.out.println(email);
                url = "./page/index.jsp";
                session.setAttribute("student", student);
                    
                thongBao = lichThiDao.thongBaoLichThi(username);
                System.out.println(thongBao);
                session.setAttribute("thongBao", thongBao);
                if(!thongBao.equalsIgnoreCase("Chúc bạn một ngày tốt lành!")) {
                    SendMail sm = new SendMail();
                    sm.sendMail(email, "Thông báo lịch thi", thongBao);
                }
            }
            else if(studentDAO.checkLoginDuPhong(username,password) == true){
                Student student = studentDAO.getStudent(username);
                url = "./page/index.jsp";
                session.setAttribute("student", student);
                String email = student.getEmail();
                thongBao = lichThiDao.thongBaoLichThi(username);
                session.setAttribute("thongBao", thongBao);
                

//                RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//                dispatcher.forward(request, response);
            }
            else{
                System.out.println("false");
                url = "./page/login.jsp";
                String errorMessage = "Tên đăng nhập hoặc mật khẩu không chính xác";
 
                request.setAttribute("errorMessage", errorMessage);
//                RequestDispatcher dispatcher =  request.getRequestDispatcher(url);
//                dispatcher.forward(request, response);
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            out1.println("<h1> WRONG " + request.getContextPath() + "</h1>");
            out1.println("<h1> WRONG " + ex.toString() + "</h1>");
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
