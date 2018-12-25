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
import java.util.ArrayList;
import model.TimeTable;

/**
 *
 * @author Nam Anh
 */
public class TimeTableDAO {
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private connectDB connectdb;

    public TimeTableDAO() {
        connectdb = new connectDB();
    }    
    
    public ArrayList<TimeTable> getTimeTable(String studentID) throws SQLException, Exception {
        ArrayList<TimeTable> timeTableList = new ArrayList<>();
        String sqlDangKyMonHoc = "SELECT * FROM tbldangkymonhoc as a, tbltkb as b "
                + "WHERE MaSV = '" + studentID + "' " +
                "AND a.MaHK = '" + 20172 + "' AND a.MaNhom = b.MaNhom AND a.MaMH = b.MaMH";
        System.out.println(sqlDangKyMonHoc);
        rs = connectdb.getStatement().executeQuery(sqlDangKyMonHoc);;
        TimeTable timeTable = null;
        while(rs.next()){
            String tenMH = rs.getString("tenMH");
            int soTC = rs.getInt("soTC");
            int maHK = rs.getInt("maHK");
            String maNhom = rs.getString("maNhom");
            String maMH = rs.getString("maMH");
            String toHop = rs.getString("toHop");
            String toTH = rs.getString("toTH");
            String thu = rs.getString("thu");
            String tietBD = rs.getString("tietBD");
            String soTiet = rs.getString("soTiet");
            String kip = rs.getString("kip");
            String phong = rs.getString("phong");
            String nha = rs.getString("nha");
            String tuanHoc = rs.getString("tuanHoc");
            String giangVien = rs.getString("giangVien");
            timeTable = new TimeTable(maHK, soTC, studentID, maMH, maNhom, tenMH, 
                    toHop, toTH, thu, tietBD, soTiet, kip, phong, nha, tuanHoc, 
                    giangVien);
            timeTableList.add(timeTable);
        }
        return timeTableList;
    }    
    
    public boolean checkTimeTable(TimeTable timeTable) {
        
        return true;
    }
    
    public ArrayList<TimeTable> getTimeTableInToday(ArrayList<TimeTable> timeTable) {
        ArrayList<TimeTable> timeTableToday = new ArrayList<>();
        return timeTableToday;
    }
    public static void main(String[] args) throws Exception {
        TimeTableDAO dao = new TimeTableDAO();
        ArrayList<TimeTable> timeTableList = dao.getTimeTable("B15DCCN209");
        for (TimeTable tt: timeTableList){
            System.out.println(tt.getTenMH() + " " + tt.getSoTC());
        }        
    } 
}
