/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nam Anh
 */
public class TimeTable {
    private int maHK, soTC;
    private String maSV, maMH, maNhom, tenMH, toHop, toTH, thu, tietBD, soTiet, kip, phong, nha, tuanHoc, giangVien;

    public TimeTable() {
    }

    public TimeTable(int maHK, int soTC, String maSV, String maMH, String maNhom, 
            String tenMH, String toHop, String toTH, String thu, String tietBD, 
            String soTiet, String kip, String phong, String nha, String tuanHoc, 
            String giangVien) {
        this.maHK = maHK;
        this.soTC = soTC;
        this.maSV = maSV;
        this.maMH = maMH;
        this.maNhom = maNhom;
        this.tenMH = tenMH;
        this.toHop = toHop;
        this.toTH = toTH;
        this.thu = thu;
        this.tietBD = tietBD;
        this.soTiet = soTiet;
        this.kip = kip;
        this.phong = phong;
        this.nha = nha;
        this.tuanHoc = tuanHoc;
        this.giangVien = giangVien;
    }

    public TimeTable(int maHK, int soTC, String maSV, String maMH, String maNhom, String tenMH) {
        this.maHK = maHK;
        this.soTC = soTC;
        this.maSV = maSV;
        this.maMH = maMH;
        this.maNhom = maNhom;
        this.tenMH = tenMH;
    }

    

    public int getSoTC() {
        return soTC;
    }

    public void setSoTC(int soTC) {
        this.soTC = soTC;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    

    public int getMaHK() {
        return maHK;
    }

    public void setMaHK(int maHK) {
        this.maHK = maHK;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(String maNhom) {
        this.maNhom = maNhom;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public String getToHop() {
        return toHop;
    }

    public void setToHop(String toHop) {
        this.toHop = toHop;
    }

    public String getToTH() {
        return toTH;
    }

    public void setToTH(String toTH) {
        this.toTH = toTH;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public String getTietBD() {
        return tietBD;
    }

    public void setTietBD(String tietBD) {
        this.tietBD = tietBD;
    }

    public String getSoTiet() {
        return soTiet;
    }

    public void setSoTiet(String soTiet) {
        this.soTiet = soTiet;
    }

    public String getKip() {
        return kip;
    }

    public void setKip(String kip) {
        this.kip = kip;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public String getNha() {
        return nha;
    }

    public void setNha(String nha) {
        this.nha = nha;
    }

    public String getTuanHoc() {
        return tuanHoc;
    }

    public void setTuanHoc(String tuanHoc) {
        this.tuanHoc = tuanHoc;
    }

    public String getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(String giangVien) {
        this.giangVien = giangVien;
    }
    
    
}
