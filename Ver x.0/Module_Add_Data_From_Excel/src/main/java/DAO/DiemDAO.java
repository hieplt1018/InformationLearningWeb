/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Diem;

/**
 *
 * @author Administrator
 */
public class DiemDAO {

    ConnectDB con;
    Statement stm;
    PreparedStatement ps;
    ResultSet rs;

    public DiemDAO() {
        if(con == null)
        con = new ConnectDB();

    }

    public void insert(Diem diem) {
        try {
            String sql = "insert into tbldiem (maHK, maSV, maMH, tenMH, soTC, diemCC, diemKT, diemBT, diemThi, diemTK, diemChu, diemTH) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.openConnect().prepareStatement(sql);
            ps.setInt(1, diem.getMaHK());
            ps.setString(2, diem.getMaSV());
            ps.setString(3, diem.getMaMH());
            ps.setString(4, diem.getTenMH());
            ps.setString(5, diem.getSoTC());
            ps.setString(6, diem.getDiemCC());
            ps.setString(7, diem.getDiemKT());
            ps.setString(8, diem.getDiemBT());
            ps.setString(9, diem.getDiemThi());
            ps.setString(10, diem.getDiemTK());
            ps.setString(11, diem.getDiemChu());
            ps.setString(12, diem.getDiemTH());
            ps.executeUpdate();
            con.closeConnet();
        } catch (Exception ex) {
            Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getMaMH(String tenMH) {

        try {
            String sql = "select MaMH from tbllichthi where tbllichthi.TenMH = '" + tenMH + "'";

            stm = con.openConnect().createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "####";
    }
}
