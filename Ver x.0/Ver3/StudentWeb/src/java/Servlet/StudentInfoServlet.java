/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.StudentDAO;
import java.io.IOException;
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
public class StudentInfoServlet extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String maSV = request.getParameter("maSV");
        String ho = request.getParameter("ho");
        String ten= request.getParameter("ten");
        String ngaysinh = request.getParameter("ngaysinh");
        String noisinh = request.getParameter("noisinh");
        String gioitinh = request.getParameter("gioitinh");
        
        String url = "";
        HttpSession session = request.getSession();
        try {
            
            Student student1 = new Student(maSV, ho, ten, ngaysinh, gioitinh, noisinh);
            boolean isSuccess = new StudentDAO().update(student1);
            System.out.println(student1.getLastName()+student1.getDateOfBirth()+student1.getPlaceOfBirth()+student1.getFirstName()+student1.getSex()+student1.getsId());
            Student student = new StudentDAO().getStudent(maSV);
            String message = "";
            if(isSuccess){
                url = "./page/studentInfo.jsp";
                
                session.setAttribute("student", student);
                message = "Đã nhập xong!";
                request.setAttribute("message", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                dispatcher.forward(request, response);
            }
            else{
               url = "./page/studentInfo.jsp";
                
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
