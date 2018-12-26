/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class HocKy {
    private int maHK;
    private String ngayBD;

    public HocKy() {
    }

    public HocKy(int maHK, String ngayBD) {
        this.maHK = maHK;
        this.ngayBD = ngayBD;
    }

    public int getMaHK() {
        return maHK;
    }

    public void setMaHK(int maHK) {
        this.maHK = maHK;
    }

    public String getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(String ngayBD) {
        this.ngayBD = ngayBD;
    }
    
    
}
