/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connectDB.connectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Mark;

/**
 *
 * @author Admin
 */
public class MarkDAO {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private connectDB connectdb;
    private Statement stm = null;
    
    public MarkDAO() {
        connectdb = new connectDB();
    }
    
    public ArrayList<Mark> getMark(String maSV, int maHK) {
        ArrayList<Mark> list = new ArrayList();
        String sql = "SELECT * FROM tbldiem WHERE MaSV = '" + maSV + "' AND MaHK = '" + maHK + "'";
        System.out.println(sql);
        try {
            rs = connectdb.getStatement().executeQuery(sql);
            Mark mark = null;
            while (rs.next()) {
                String maMH = rs.getString("MaMH");
                String tenMH = rs.getString("TenMH");
                String soTC = rs.getString("soTC");
                String DiemCC = rs.getString("DiemCC");
                String DiemKT = rs.getString("DiemKT");
                String DiemBT = rs.getString("DiemBT");
                String DiemTH = rs.getString("DiemTH");
                String DiemThi = rs.getString("DiemThi");
                String DiemTK = rs.getString("DiemTK");
                String DiemChu = rs.getString("DiemChu");
                mark = new Mark(maHK, maSV, maMH, tenMH, soTC, DiemCC, DiemKT, DiemBT, DiemTH, DiemThi, DiemTK, DiemChu);
                list.add(mark);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public String getMaMH(String tenMH) {

        try {
            String sql = "select MaMH from tbllichthi where tbllichthi.TenMH = '" + tenMH + "'";

            stm = connectdb.openConnect().createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                return rs.getString(1);

            }
        } catch (Exception ex) {
            Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "####";
    }
    
    public boolean insert(Mark mark) {
        try {
            String sql = "insert into tbldiem (maHK, maSV, maMH, tenMH, soTC, diemCC, diemKT, diemBT, diemThi, diemTK, diemChu, diemTH) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = connectdb.openConnect().prepareStatement(sql);
            ps.setInt(1, mark.getSemesterID());
            ps.setString(2, mark.getStudentID());
            ps.setString(3, mark.getSubjectID());
            ps.setString(4, mark.getSubjectName());
            ps.setString(5, mark.getNumberOfTinChi());
            ps.setString(6, mark.getDiemCC());
            ps.setString(7, mark.getDiemKT());
            ps.setString(8, mark.getDiemBT());
            ps.setString(9, mark.getDiemThi());
            ps.setString(10, mark.getDiemTK());
            ps.setString(11, mark.getDiemChu());
            ps.setString(12, mark.getDiemTH());
            int isSuccess = ps.executeUpdate();
            return isSuccess == 1;
        } catch (Exception ex) {
            Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static void main(String[] args) {
        MarkDAO markDAO = new MarkDAO();
        ArrayList<Mark> list = markDAO.getMark("B15DCCN209", 20171);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getSubjectName() + ": " + list.get(i).getDiemTK());
        }
    }
}
