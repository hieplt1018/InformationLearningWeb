package Servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.LichThiDAO;
import controller.LoginControl;
import DAO.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.LichThi;
import model.Student;

/**
 *
 * @author Administrator
 */
public class LoginServlet extends HttpServlet {
    StudentDAO studentDAO = new StudentDAO();
    long miliSeconds = System.currentTimeMillis();
    Date toDay = new Date(miliSeconds);
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
        System.out.println(username);
        String password = request.getParameter("password");
        //String result = "Đăng nhập sai :(";
        String url = "";
        HttpSession session = request.getSession();
        
        
        try {
            String mainQLDT = "http://qldt.ptit.edu.vn/";
            String defaultQLDT = "http://qldt.ptit.edu.vn/default.aspx";
            
            
            LoginControl http = new LoginControl();
            CookieHandler.setDefault(new CookieManager());
            http.GetCookie(mainQLDT);
            String postParams = http.getFormParams(username, password);
            http.sendPost(defaultQLDT, postParams);
//            if(http.checkLogin(username)) {
            if(http.checkLoginTamThoi(username) == true){
                System.out.println("true");
                Student student = studentDAO.getStudent(username);out1.print(studentDAO.getStudent(username));
                url = "./page/index.jsp";
                session.setAttribute("student", student);
                
                ArrayList<LichThi> lichThi = lichThiDao.getLichThi(username);
                String thongBao = "";
                for (LichThi monThi : lichThi) {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String strToday = formatter.format(toDay);           // Chuyen Date thanh String
                    if (monThi.getNgayThi().equals(strToday)) {
                        thongBao = "Hôm nay thi môn: " + monThi.getTenMH() + " vào lúc " + monThi.getGioBD() + " tại phòng " + monThi.getPhongThi() + ". Chúc bạn may mắn!";
                        break;
                    }else {
                        thongBao = "Chào mừng tới trang web của chúng tôi.";
                    }
                    System.out.println(thongBao);
                }
                session.setAttribute("thongBao", thongBao);
                
                RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                dispatcher.forward(request, response);
            }
            else{
                System.out.println("false");
                url = "./page/login.jsp";
                String errorMessage = "Tên đăng nhập hoặc mật khẩu không chính xác";
 
                request.setAttribute("errorMessage", errorMessage);
                RequestDispatcher dispatcher =  request.getRequestDispatcher(url);
                dispatcher.forward(request, response);
//                dispatcher.include(request, response);
                
            }
            
//            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
//            rd.forward(request, response);
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
