/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connectDB.connectDB;
import controller.DateControl;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.HocKy;
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

    long miliSeconds = System.currentTimeMillis();
    Date toDay = new Date(miliSeconds);
    
    public TimeTableDAO() {
        connectdb = new connectDB();
    }    
    
    public ArrayList<TimeTable> getTimeTable(String studentID) throws SQLException, Exception {
        ArrayList<TimeTable> timeTableList = new ArrayList<>();
        String sqlDangKyMonHoc = "SELECT * FROM tbldangkymonhoc as a, tbltkb as b "
                + "WHERE MaSV = '" + studentID + "' " +
                "AND a.MaHK = '" + 20172 + "' AND a.MaNhom = b.MaNhom AND a.MaMH = b.MaMH Order by b.TietBD asc";
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
    
    public ArrayList<TimeTable> getTimeTableInToday(ArrayList<TimeTable> timeTable, int maHK) throws Exception {
        DateControl dateCtr = new DateControl();
        ArrayList<TimeTable> timeTableTodayList = new ArrayList<>();
        TimeTableDAO dao = new TimeTableDAO();
        HocKyDAO hkDao = new HocKyDAO();
        HocKy hk = hkDao.getHocKy(20172);
        TimeTable timeTableToDay = null;
        int tuanBD = dateCtr.getSttTuan(hk.getNgayBD());
        int tuanHT = dateCtr.getSttTuan("23/01/2018");
//        int tuanHT = dateCtr.getSttThisWeek();
//        int toDay = dateCtr.chuyenDoiThuTrongTuan();
        int toDay = 2; 
        System.out.println(toDay);
            for (TimeTable tt : timeTable) {
                String[] tuanHocStr = tt.getTuanHoc().split("");
                String sttTuanHienTai = Integer.toString(tuanHT - tuanBD + 1);
                for(int i = 0; i < tuanHocStr.length; i++) {
                    if (i >= 10) {
                        String tuanHoc1 = '1' + tuanHocStr[i];
                        if (sttTuanHienTai.equalsIgnoreCase(tuanHoc1) && Integer.toString(toDay).equalsIgnoreCase(tt.getThu())) {
                            String tenMH = tt.getTenMH();
                            String tietBD = tt.getTietBD();
                            String soTiet = tt.getSoTiet();
                            String phong = tt.getPhong();
                            String nha = tt.getNha();
                            String giangVien = tt.getGiangVien();
                            timeTableToDay = new TimeTable(tenMH, tietBD, soTiet, phong, nha, giangVien);
                            timeTableTodayList.add(timeTableToDay);
                        }
                    } else {
                        String tuanHoc1 = tuanHocStr[i];
                        if (sttTuanHienTai.equalsIgnoreCase(tuanHoc1) && Integer.toString(toDay).equalsIgnoreCase(tt.getThu())) {
                            String tenMH = tt.getTenMH();
                            String tietBD = tt.getTietBD();
                            String soTiet = tt.getSoTiet();
                            String phong = tt.getPhong();
                            String nha = tt.getNha();
                            String giangVien = tt.getGiangVien();
                            timeTableToDay = new TimeTable(tenMH, tietBD, soTiet, phong, nha, giangVien);
                            timeTableTodayList.add(timeTableToDay);
                        }
                    } 
                    
                }
                
            
        }
        return timeTableTodayList;
    }
    
    
    public static void main(String[] args) throws Exception {
        TimeTableDAO dao = new TimeTableDAO();
        ArrayList<TimeTable> timeTableList = dao.getTimeTable("B15DCCN021");
        for (TimeTable tt: timeTableList){
            System.out.println(tt.getTenMH() + " " + tt.getThu()+ " " + tt.getTuanHoc());
        }        
        int j = 1;
        String thongBaoLichHoc = "";
        ArrayList<TimeTable> timeTableToday = dao.getTimeTableInToday(timeTableList, 20172);
        for (int i = 0; i < timeTableToday.size(); i++) {
            TimeTable tt = timeTableToday.get(i);
            thongBaoLichHoc += "<p>" +j + ". " + tt.getTenMH() + " - " + tt.getGiangVien() + " - Tiết bắt đầu: " + tt.getTietBD() + " - phòng: " + tt.getPhong() + " - " + tt.getNha() + "</p>";
            j ++;
        }   
        System.out.println(thongBaoLichHoc);
    } 
}
