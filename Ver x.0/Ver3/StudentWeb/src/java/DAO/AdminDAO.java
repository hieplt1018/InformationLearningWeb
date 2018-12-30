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
import java.util.ArrayList;
import model.Admin;
import model.LichThi;

/**
 *
 * @author Administrator
 */
public class AdminDAO {
    connectDB con;
    Statement stm;
    PreparedStatement ps;
    ResultSet rs;

    public AdminDAO() {
        if(con == null)
         con= new connectDB();
    }
   
    public Admin checkLogin(String username, String password){
        Admin admin = null;
        String strSQL = "select * from tbladmin where username = '" + username + "' and password = '" + password + "'";
        try {
            rs = con.getStatement().executeQuery(strSQL);
            while (rs.next()) {
                String ho = rs.getString("ho");
                String ten = rs.getString("ten");
                String image = rs.getString("image");
                String maNV = rs.getString("maNV");
                admin = new Admin(username, password, maNV, ho, ten, image);
            }
            con.closeConnet();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return admin; // null is false;
    }
    
    public boolean update(Admin admin, String maNV) {
        try {
            String sql = "update tbladmin a set a.username = ? , a.password = ? , a.maNV = ? , a.ho = ? , a.ten = ? where a.maNV = ? " ;
            ps = con.openConnect().prepareStatement(sql);
            ps.setString(1, admin.getUsername());
            ps.setString(2, admin.getPassword());
            ps.setString(3, admin.getMaNV());
            ps.setString(4, admin.getHo());
            ps.setString(5, admin.getTen());
            ps.setString(6, maNV);
            
            return ps.executeUpdate() == 1;
        } catch (Exception ex) {
            return false;
        }
    }

    
    public static void main(String[] args) {
//        Admin admin = new AdminDAO().checkLogin("hiep97", "123");
//        System.out.println(admin.ho + admin.ten + admin.image + admin.maNV);
AdminDAO a = new AdminDAO();
Admin admin = new Admin("hiep97", "123", "NV102", "Lê", "Tuấn Hiệp");
        System.out.println(a.update(admin, "NV101"));
    }
}
