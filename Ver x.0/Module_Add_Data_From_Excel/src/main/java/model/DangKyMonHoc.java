package model;

public class DangKyMonHoc {

    private int maHK;
    private String maSV;
    private String maNhom;
    private String maMH;
    private String tenMH;
    private String soTC;

    public int getMaHK() {
        return maHK;
    }

    public void setMaHK(int maHK) {
        this.maHK = maHK;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(String maNhom) {
        this.maNhom = maNhom;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public DangKyMonHoc(int maHK, String maSV, String maNhom, String maMH, String tenMH, String soTC) {
        this.maHK = maHK;
        this.maSV = maSV;
        this.maNhom = maNhom;
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.soTC = soTC;
    }

    public String getSoTC() {
        return soTC;
    }

    public void setSoTC(String soTC) {
        this.soTC = soTC;
    }


}
