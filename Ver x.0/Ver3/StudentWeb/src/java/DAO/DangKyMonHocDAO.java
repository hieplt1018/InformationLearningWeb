/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connectDB.connectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DangKyMonHoc;

/**
 *
 * @author Administrator
 */
public class DangKyMonHocDAO {
    connectDB con;
    Statement stm;
    PreparedStatement ps;
    ResultSet rs;

    public DangKyMonHocDAO() {
        if(con == null)
         con= new connectDB();
    }
   
    public boolean insert(DangKyMonHoc dkmh) {
     try {
        String sql = "insert into tbldangkymonhoc (maHK, maSV, maNhom, maMH, tenMH, soTC) values(?,?,?,?,?,?)";
        ps = con.openConnect().prepareStatement(sql);
        ps.setInt(1, dkmh.getMaHK());
        ps.setString(2, dkmh.getMaSV());
        ps.setString(3, dkmh.getMaNhom());
        ps.setString(4, dkmh.getMaMH());
        ps.setString(5, dkmh.getTenMH());
        ps.setString(6, dkmh.getSoTC());
        return ps.executeUpdate()==1;
    } catch (Exception ex) {
        Logger.getLogger(DangKyMonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }
    }
    
}
