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
import java.util.ArrayList;
import model.Mark;

/**
 *
 * @author Admin
 */
public class MarkDAO {
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private connectDB connectdb;
    
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
    
    public static void main(String[] args) {
        MarkDAO markDAO = new MarkDAO();
        ArrayList<Mark> list = markDAO.getMark("B15DCCN209", 20171);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getSubjectName() + ": " + list.get(i).getDiemTK());
        }
    }
}
