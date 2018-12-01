package model;

public class SinhVien {

    private String lop;
    private String maSV;
    private String ho;
    private String ten;
    private String ngaySinh;
    private String gioiTinh;
    private String noiSinh;
    private String password;

    public SinhVien(String lop, String maSV, String ho, String ten, String ngaySinh) {
        this.lop = lop;
        this.maSV = maSV;
        this.ho = ho;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
      
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
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

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SinhVien() {
    }

}
