/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connectDB.connectDB;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.LichThi;

/**
 *
 * @author Administrator
 */
public class LichThiDAO {
    connectDB con;
    Statement stm;
    PreparedStatement ps;
    ResultSet rs;

    long miliSeconds = System.currentTimeMillis();
    Date toDay = new Date(miliSeconds);
    
    public LichThiDAO() {
        if(con == null)
         con= new connectDB();
        
    }
   
    public boolean insert(LichThi lt) {
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
            return ps.executeUpdate() == 1;
        } catch (Exception ex) {
            return false;
        }
    }
    
    public ArrayList<LichThi> getLichThi(String masv){
        ArrayList<LichThi> lichThiList = new ArrayList<>();
        ArrayList<LichThi> lichThiList2 = new ArrayList<>();
        String strSQL = "SELECT b.* FROM tbldangkymonhoc as a, tbllichthi as b WHERE a.MaSV = '" + masv + "'"+
                " and a.MaHK = b.MaHK and a.MaMH = b.MaMH and a.MaNhom = b.MaNhom";
        try {
            rs = con.getStatement().executeQuery(strSQL);
            while (rs.next()) {
                LichThi lt = new LichThi();
                lt.setMaHK(rs.getInt("MaHK"));
                lt.setMaMH(rs.getString("MaMH"));
                lt.setMaNhom(rs.getString("MaNhom"));
                lt.setTenMH(rs.getString("TenMH"));
                lt.setNgayThi(rs.getString("NgayThi"));
                lt.setGioBD(rs.getString("GioBD"));
                lt.setPhongThi(rs.getString("PhongThi"));
                lt.setGhiChu(rs.getString("GhiChu"));
                lichThiList.add(lt);
            }
            con.closeConnet();
            boolean mark[] = new boolean[lichThiList.size()];
            for(int i = 0; i < mark.length; i++) mark[i] = true;
            for(int i = 0; i < lichThiList.size()-1; i++){
                for(int j = i+1; j < lichThiList.size(); j++){
                    if(lichThiList.get(i).getMaMH().equals(lichThiList.get(j).getMaMH())){
                        mark[j] = false;
                        String str = lichThiList.get(i).getPhongThi() + ", " + lichThiList.get(j).getPhongThi();
                        lichThiList.get(i).setPhongThi(str);
                    } 
                }
            }
            for(int i = 0; i < mark.length; i++){
               boolean trưe;
                if(mark[i] == true)
                    lichThiList2.add(lichThiList.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lichThiList2;
    }
    
    public String thongBaoLichThi(String username){
        LichThiDAO lichThiDao = new LichThiDAO();
        ArrayList<LichThi> lichThi = lichThiDao.getLichThi(username);
        String thongBao = "";
        for (LichThi monThi : lichThi) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String strToday = formatter.format(toDay);           // Chuyen Date thanh String
            if (monThi.getNgayThi().equals(strToday)) {
                thongBao = "Hôm nay thi môn: " + monThi.getTenMH() + " vào lúc " + monThi.getGioBD() + " tại phòng " + monThi.getPhongThi() + ". Chúc bạn may mắn!";
                break;
            } else {
                thongBao = "Chúc bạn một ngày tốt lành!";
            }
        }
        return thongBao;
    }
    
    public static void main(String[] args) {
        LichThiDAO dAO = new LichThiDAO();
        ArrayList<LichThi> lt = dAO.getLichThi("B15DCCN021");
        for(LichThi l:lt){
            System.out.println(l.getTenMH()+ " "+ l.getNgayThi() +" "+l.getPhongThi() +" " + l.getMaNhom());
        }
        System.out.println(dAO.thongBaoLichThi("B15DCCN660"));
    }
}
