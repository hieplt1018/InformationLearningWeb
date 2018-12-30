/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Administrator
 */
public class Admin {
    public String username, password, maNV, ho, ten, image;

    public Admin() {
    }

    public Admin(String username, String password, String maNV, String ho, String ten, String image) {
        this.username = username;
        this.password = password;
        this.maNV = maNV;
        this.ho = ho;
        this.ten = ten;
        this.image = image;
    }

    public Admin(String username, String password, String maNV, String ho, String ten) {
        this.username = username;
        this.password = password;
        this.maNV = maNV;
        this.ho = ho;
        this.ten = ten;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
