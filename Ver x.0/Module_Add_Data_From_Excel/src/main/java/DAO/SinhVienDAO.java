/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SinhVien;

/**
 *
 * @author Administrator
 */
public class SinhVienDAO {
    ConnectDB con;
    Statement stm;
    PreparedStatement ps;
    ResultSet rs;

    public SinhVienDAO() {
        if(con == null)
         con= new ConnectDB();
        
    }
   
    public void insert(SinhVien sv) {
     try {
        String sql = "insert into tblsinhvien (Lop, MaSV, Ho, Ten, NgaySinh) values(?,?,?,?,?)";
        ps = con.openConnect().prepareStatement(sql);
        ps.setString(1, sv.getLop());
        ps.setString(2, sv.getMaSV());
        ps.setString(3, sv.getHo());
        ps.setString(4, sv.getTen());
        ps.setString(5, sv.getNgaySinh());
        ps.executeUpdate();
    } catch (Exception ex) {
        
    }
    }
}
