package model;

public class LichThi {

    private int maHK;
    private String maMH;
    private String maNhom;
    private String tenMH;
    private String ngayThi;
    private String tietBD;
    private String gioBD;
    private String toThi;
    private String siSo;
    private String phongThi;
    private String giangVien;
    private String ghiChu;

    public LichThi() {
    }

    public LichThi(int maHK, String maMH, String maNhom, String tenMH, String ngayThi, String tietBD, String gioBD, String toThi, String siSo, String phongThi, String giangVien, String ghiChu) {
        this.maHK = maHK;
        this.maMH = maMH;
        this.maNhom = maNhom;
        this.tenMH = tenMH;
        this.ngayThi = ngayThi;
        this.tietBD = tietBD;
        this.gioBD = gioBD;
        this.toThi = toThi;
        this.siSo = siSo;
        this.phongThi = phongThi;
        this.giangVien = giangVien;
        this.ghiChu = ghiChu;
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

    public String getNgayThi() {
        return ngayThi;
    }

    public void setNgayThi(String ngayThi) {
        this.ngayThi = ngayThi;
    }

    public String getTietBD() {
        return tietBD;
    }

    public void setTietBD(String tietBD) {
        this.tietBD = tietBD;
    }

    public String getGioBD() {
        return gioBD;
    }

    public void setGioBD(String gioBD) {
        this.gioBD = gioBD;
    }

    public String getToThi() {
        return toThi;
    }

    public void setToThi(String toThi) {
        this.toThi = toThi;
    }

    public String getSiSo() {
        return siSo;
    }

    public void setSiSo(String siSo) {
        this.siSo = siSo;
    }

    public String getPhongThi() {
        return phongThi;
    }

    public void setPhongThi(String phongThi) {
        this.phongThi = phongThi;
    }

    public String getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(String giangVien) {
        this.giangVien = giangVien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

}
