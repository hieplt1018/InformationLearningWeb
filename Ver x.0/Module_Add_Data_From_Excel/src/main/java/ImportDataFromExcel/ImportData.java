/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportDataFromExcel;

import DAO.ConnectDB;

/**
 *
 * @author Administrator
 */
public class ImportData {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        new ConnectDB().setMaxConnection(60000);
        //Import data dang ky mon hoc
        DataDangKyMonHoc ddkmh1 = new DataDangKyMonHoc(path+"\\CSDL\\DS-lop-ky-2-nam-hoc.xlsx");
        ddkmh1.importData(0, 9, 56638);
        //Import data sinh vien
        DataSinhvien d = new DataSinhvien(path+"\\CSDL\\DS-phân-ngành-D15CN1.xlsx");
        d.importData(0, 6, 61);
        d.importData(1, 6, 60);
        d.importData(2, 6, 59);
        d.importData(3, 6, 60);
        d.importData(4, 6, 56);
        d.importData(5, 6, 54);
        d.importData(6, 6, 58);
        d.importData(7, 6, 56);
        d.importData(8, 6, 58);
        d.importData(9, 6, 50);
        d.importData(10, 6, 58);
        
        //Import data lich thi
        DataLichThi dataLichThi = new DataLichThi(path+"\\CSDL\\Lich-thi-HK-2-nam-hoc-2017-2018-10-042.xlsx");
        dataLichThi.importData(1, 8, 1810);
        
        //Import data tkb
        DataTKB dataTKB = new DataTKB(path+"\\CSDL\\TKB-HK2-NAM-HOC-2017-2018-10_02.xlsx");
        dataTKB.importData(1, 11, 2174);
        
        //Import data diem
        DataDiem diem = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD An toan he dieu hanh(web).xlsx");
        diem.importData(8);

        DataDiem diem1 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD An toan mang nang cao(web).xlsx");
        diem1.importData(8);

        DataDiem diem2 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD An toan va bao mat HTTT(web).xlsx");
        diem2.importData2(8);
  
        DataDiem diem3 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Cac he thong phan tan(web).xlsx");
        diem3.importData2(8);

        DataDiem diem4 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Cac ky thuat giau tin(web).xlsx");
        diem4.importData(8);

        DataDiem diem5 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Cac ky thuat lap trinh(web).xlsx");
        diem5.importData2(8);
        
        DataDiem diem6 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Cau truc du lieu va giai thuat(web).xlsx");
        diem6.importData2(8);

        DataDiem diem7 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Chuyen de cong nghe phan mem(web).xlsx");
        diem7.importData2(8);

        DataDiem diem8 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Chuyen de he thong thong tin(web).xlsx");
        diem8.importData2(8);

        DataDiem diem9 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Co so an toan thong tin(web).xlsx");
        diem9.importData2(8);

        DataDiem diem10 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Co so du lieu(web).xlsx");
        diem10.importData(8);
        
        DataDiem diem11 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Dam bao chat luong phan mem(web).xlsx");
        diem11.importData(8);

        DataDiem diem12 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD He co so du lieu da phuong tien(web).xlsx");
        diem12.importData2(8);

        DataDiem diem13 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD He dieu hanh Windows va Linux_Unix(web).xlsx");
        diem13.importData2(8);

        DataDiem diem14 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Kho du lieu va khai pha du lieu(web).xlsx");
        diem14.importData(8);

        DataDiem diem15 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Kiem thu xam nhap mang(web).xlsx");
        diem15.importData(8);

        DataDiem diem16 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Kien truc may tinh(web).xlsx");
        diem16.importData(8);

        DataDiem diem17 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Kien truc va thiet ke phan mem(web).xlsx");
        diem17.importData(8);

        DataDiem diem18 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Ky thuat do hoa(web).xlsx");
        diem18.importData(8);

        DataDiem diem19 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Ky thuat theo doi va giam sat an toan mang(web).xlsx");
        diem19.importData(8);
        
        DataDiem diem20 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Lap trinh web(web).xlsx");
        diem20.importData2(8);
//        
        DataDiem diem21 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Mang may tinh(web).xlsx");
        diem21.importData(8);

        DataDiem diem22 = new DataDiem(path + "\\CSDL\\Nganh CNTT\\BD Mat ma hoc co so(web).xlsx");
        diem22.importData(8);

        DataDiem diem23 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Nhap mon cong nghe phan mem(web).xlsx");
        diem23.importData2(8);
        DataDiem diem24 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Nhap mon tri tue nhan tao(web).xlsx");
        diem24.importData(8);
        DataDiem diem25 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Phan tich va thiet ke he thong thong tin(web).xlsx");
        diem25.importData(8);
        DataDiem diem26 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Phat trien he thong thong tin quan ly(web).xlsx");
        diem26.importData2(8);
     
        DataDiem diem28 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Phat trien phan mem huong dich vu(web).xlsx");
        diem28.importData(8);
        DataDiem diem29 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Phat trien ung dung cho cac thiet bi di dong(web).xlsx");
        diem29.importData2(8);
        
        
    }
}
