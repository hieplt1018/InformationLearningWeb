/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.LichThi;

/**
 *
 * @author Administrator
 */
public class LichThiDAO {
     ConnectDB con;
    Statement stm;
    PreparedStatement ps;
    ResultSet rs;

    public LichThiDAO() {
        if(con == null)
         con= new ConnectDB();
        
    }
   
    public void insert(LichThi lt) {
     try {
        String sql = "insert into tbllichthi (maHK, maMH, maNhom,tenMH,ngayThi,tietBD,gioBD,toThi,siSo,phongThi,giangVien,ghiChu) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        ps = con.openConnect().prepareStatement(sql);
        ps.setInt(1, lt.getMaHK());
        ps.setString(2, lt.getMaMH());
        ps.setString(3, lt.getMaNhom());
        ps.setString(4, lt.getTenMH());
        ps.setString(5, lt.getNgayThi());
        ps.setString(6, lt.getTietBD());
        ps.setString(7, lt.getGioBD());
        ps.setString(8, lt.getToThi());
        ps.setString(9, lt.getSiSo());
        ps.setString(10, lt.getPhongThi());
        ps.setString(11, lt.getGiangVien());
        ps.setString(12, lt.getGhiChu());
        ps.executeUpdate();
    } catch (Exception ex) {
        
    }
    }
}
