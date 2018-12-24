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

    public LichThiDAO() {
        if(con == null)
         con= new connectDB();
        
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
    public static void main(String[] args) {
        LichThiDAO dAO = new LichThiDAO();
        ArrayList<LichThi> lt = dAO.getLichThi("B15DCCN660");
        for(LichThi l:lt){
            System.out.println(l.getTenMH()+ " "+ l.getNgayThi() +" "+l.getPhongThi() +" " + l.getMaNhom());
        }
    }
}
