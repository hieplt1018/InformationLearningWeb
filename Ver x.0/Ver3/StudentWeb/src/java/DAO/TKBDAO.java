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
import model.TKB;

/**
 *
 * @author Administrator
 */
public class TKBDAO {
    connectDB con;
    Statement stm;
    PreparedStatement ps;
    ResultSet rs;

    public TKBDAO() {
        if(con == null)
         con= new connectDB();
        
    }
   
    public boolean insert(TKB tkb) {
     try {
        String sql = "insert into tbltkb (maHK, maMH, tenMH,toHop, toTH, thu, tietBD, soTiet, kip, phong,  nha, tuanHoc, giangVien,  maNhom) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        ps = con.openConnect().prepareStatement(sql);
        ps.setInt(1, tkb.getMaHK());
        ps.setString(2, tkb.getMaMH());
        ps.setString(3, tkb.getTenMH());
        ps.setString(4, tkb.getToHop());
        ps.setString(5, tkb.getToTH());
        ps.setInt(6, tkb.getThu());
        ps.setInt(7, tkb.getTietBD());
        ps.setInt(8, tkb.getSoTiet());
        ps.setInt(9, tkb.getKip());
        ps.setString(10, tkb.getPhong());
        ps.setString(11, tkb.getNha());
        ps.setString(12, tkb.getTuanHoc());
        ps.setString(13, tkb.getGiangVien());
        ps.setString(14, tkb.getMaNhom());
        return ps.executeUpdate()==1;
    } catch (Exception ex) {
        Logger.getLogger(TKBDAO.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }
    }
}
