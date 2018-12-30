/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.HocKyDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HocKy;

/**
 *
 * @author Administrator
 */
public class HocKyInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        int maHK = Integer.parseInt(request.getParameter("maHK"));
        String ngayBD = request.getParameter("ngayBD");
        HocKy hk = new HocKy(maHK, ngayBD);
        String url = "./admin/hocKyInfo.jsp";
        try {
            String message = "";
            boolean isSuccess = new HocKyDAO().insert(hk);
            if(isSuccess){
                message = "Đã nhập xong!";
                request.setAttribute("message", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                dispatcher.forward(request, response);
            }
            else{
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
