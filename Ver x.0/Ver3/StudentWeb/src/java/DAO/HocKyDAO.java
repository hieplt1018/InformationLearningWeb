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
import java.sql.SQLException;
import model.HocKy;

/**
 *
 * @author Admin
 */
public class HocKyDAO {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private connectDB connectdb;

    public HocKyDAO() {
        connectdb = new connectDB();
    }
    
    public boolean insert(HocKy hk) {
        try {
            String sql = "insert into tblhocky (maHK, ngayBD) values(?,?)";
            ps = connectdb.openConnect().prepareStatement(sql);
            ps.setInt(1, hk.getMaHK());
            ps.setString(2, hk.getNgayBD());
            return ps.executeUpdate() == 1;
        } catch (Exception ex) {
            return false;
        }
    }
    
    public HocKy getHocKy(int maHK) throws SQLException, Exception {
        HocKy hocky = new HocKy();
        String strSQL = "select * from tblhocky where MaHK = '" + maHK + "'";
        try {
            rs = connectdb.getStatement().executeQuery(strSQL);
            while (rs.next()) {
                hocky.setNgayBD(rs.getString("ngayBD"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hocky;
    }
    
    public static void main(String[] args) throws Exception {
        HocKyDAO hkdao = new HocKyDAO();
        HocKy hk = hkdao.getHocKy(20172);
        System.out.println(hk.getNgayBD());
    }
}
