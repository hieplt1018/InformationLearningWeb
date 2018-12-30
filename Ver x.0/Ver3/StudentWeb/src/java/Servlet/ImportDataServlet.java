/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import ImportDataFromExcel.DataDangKyMonHoc;
import ImportDataFromExcel.DataDiem;
import ImportDataFromExcel.DataLichThi;
import ImportDataFromExcel.DataSinhvien;
import ImportDataFromExcel.DataTKB;
import connectDB.connectDB;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Administrator
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class ImportDataServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String selectOption = request.getParameter("select");
        String url = "";
        PrintWriter out1 = response.getWriter();
        String newFile = saveFile(request, response);
        System.out.println(newFile);
        new connectDB().setMaxConnection(60000);
        if (selectOption.equals("diem")) {
            DataDiem dataDiem = new DataDiem(newFile);
            int maHK = Integer.parseInt(request.getParameter("maHK"));
            String[] vt_tenMH = request.getParameter("vt_tenMH").split(",");
            int[] vt_tenmh = new int[2];
            vt_tenmh[0] = Integer.parseInt(vt_tenMH[0]);
            vt_tenmh[1] = Integer.parseInt(vt_tenMH[1]);
            String[] vt_soTC = request.getParameter("vt_soTC").split(",");
            int[] vt_sotc = new int[2];
            vt_sotc[0] = Integer.parseInt(vt_soTC[0]);
            vt_sotc[1] = Integer.parseInt(vt_soTC[1]);
            int[] vt = new int[8];
            vt[0] = Integer.parseInt(request.getParameter("vt_maSV"));
            vt[1] = Integer.parseInt(request.getParameter("vt_diemCC"));
            vt[2] = Integer.parseInt(request.getParameter("vt_diemKT"));
            vt[3] = Integer.parseInt(request.getParameter("vt_diemTH"));
            vt[4] = Integer.parseInt(request.getParameter("vt_diemBT"));
            vt[5] = Integer.parseInt(request.getParameter("vt_diemThi"));
            vt[6] = Integer.parseInt(request.getParameter("vt_diemTK"));
            vt[7] = Integer.parseInt(request.getParameter("vt_diemChu"));
            int vt_dongBD = Integer.parseInt(request.getParameter("vt_dongBD"));
            boolean isSuccess = dataDiem.importData(vt_dongBD, maHK, vt_tenmh, vt_sotc, vt);
            String message = "";
            url = "./admin/importData.jsp";
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
        }
        else if(selectOption.equals("thongtincanhan")){
            DataSinhvien dataSinhvien = new DataSinhvien(newFile);
            
            int[] vt = new int[5];
            vt[0] = Integer.parseInt(request.getParameter("vt_lop"));
            vt[1] = Integer.parseInt(request.getParameter("vt_maSV"));
            vt[2] = Integer.parseInt(request.getParameter("vt_ho"));
            vt[3] = Integer.parseInt(request.getParameter("vt_ten"));
            vt[4] = Integer.parseInt(request.getParameter("vt_ngaysinh"));
            
            int vt_dongBD = Integer.parseInt(request.getParameter("vt_dongBD"));
            boolean isSuccess = dataSinhvien.importData(vt_dongBD, vt);
            
            String message = "";
            url = "./admin/importData.jsp";
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
        }
        else if(selectOption.equals("tkb")){
            DataTKB dataTKB = new DataTKB(newFile);
            int maHK = Integer.parseInt(request.getParameter("maHK"));
            int[] vt = new int[13];
            vt[0] = Integer.parseInt(request.getParameter("vt_maMH"));
            vt[1] = Integer.parseInt(request.getParameter("vt_tenMH"));
            vt[2] = Integer.parseInt(request.getParameter("vt_maNhom"));
            vt[3] = Integer.parseInt(request.getParameter("vt_toHop"));
            vt[4] = Integer.parseInt(request.getParameter("vt_toTH"));
            vt[5] = Integer.parseInt(request.getParameter("vt_thu"));
            vt[6] = Integer.parseInt(request.getParameter("vt_tietBD"));
            vt[7] = Integer.parseInt(request.getParameter("vt_soTiet"));
            vt[8] = Integer.parseInt(request.getParameter("vt_kip"));
            vt[9] = Integer.parseInt(request.getParameter("vt_phong"));
            vt[10] = Integer.parseInt(request.getParameter("vt_nha"));
            vt[11] = Integer.parseInt(request.getParameter("vt_tuanHoc"));
            vt[12] = Integer.parseInt(request.getParameter("vt_giangVien"));
            
            int vt_dongBD = Integer.parseInt(request.getParameter("vt_dongBD"));
            boolean isSuccess = dataTKB.importData(vt_dongBD, maHK, vt);
            String message = "";
            url = "./admin/importData.jsp";
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
        }
        else if(selectOption.equals("lichthi")){
            DataLichThi dataLichThi = new DataLichThi(newFile);
            int maHK = Integer.parseInt(request.getParameter("maHK"));
            int[] vt = new int[11];
            vt[0] = Integer.parseInt(request.getParameter("vt_ngaythi"));
            vt[1] = Integer.parseInt(request.getParameter("vt_tietBD"));
            vt[2] = Integer.parseInt(request.getParameter("vt_gioBD"));
            vt[3] = Integer.parseInt(request.getParameter("vt_maMH"));
            vt[4] = Integer.parseInt(request.getParameter("vt_maNhom"));
            vt[5] = Integer.parseInt(request.getParameter("vt_toThi"));
            vt[6] = Integer.parseInt(request.getParameter("vt_tenMH"));
            vt[7] = Integer.parseInt(request.getParameter("vt_siSo"));
            vt[8] = Integer.parseInt(request.getParameter("vt_phongThi"));
            vt[9] = Integer.parseInt(request.getParameter("vt_ghiChu"));
            vt[10] = Integer.parseInt(request.getParameter("vt_giangVien"));
            
            int vt_dongBD = Integer.parseInt(request.getParameter("vt_dongBD"));
            boolean isSuccess = dataLichThi.importData(vt_dongBD, maHK, vt);
            String message = "";
            url = "./admin/importData.jsp";
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
        }
        else if(selectOption.equals("dangkymonhoc")){
            DataDangKyMonHoc dataDangKyMonHoc = new DataDangKyMonHoc(newFile);
            int maHK = Integer.parseInt(request.getParameter("maHK"));
            int[] vt = new int[5];
            vt[0] = Integer.parseInt(request.getParameter("vt_maSV"));
            vt[1] = Integer.parseInt(request.getParameter("vt_lopMH"));
            vt[2] = Integer.parseInt(request.getParameter("vt_maMH"));
            vt[3] = Integer.parseInt(request.getParameter("vt_tenMH"));
            vt[4] = Integer.parseInt(request.getParameter("vt_soTC"));
            
            int vt_dongBD = Integer.parseInt(request.getParameter("vt_dongBD"));
            boolean isSuccess = dataDangKyMonHoc.importData(vt_dongBD, maHK, vt);
            String message = "";
            url = "./admin/importData.jsp";
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

    public String saveFile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fileName = "";
        Part part = request.getPart("file");
        fileName = extractFileName(part);
        // refines the fileName in case it is an absolute path
        fileName = new File(fileName).getName();
        part.write(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);

        return this.getFolderUpload().getAbsolutePath() + File.separator + fileName;
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    public File getFolderUpload() {
        File folderUpload = new File(System.getProperty("user.home") + "/Uploads");
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }
}
