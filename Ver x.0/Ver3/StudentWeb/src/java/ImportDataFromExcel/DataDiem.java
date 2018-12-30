/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportDataFromExcel;

import DAO.MarkDAO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Mark;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Administrator
 */
public class DataDiem {

    FileInputStream input;
    XSSFWorkbook myWorkBook;
    
    public DataDiem(String excelFile) {
        try {
            input = new FileInputStream(excelFile);
            myWorkBook = new XSSFWorkbook(input);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataDiem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataDiem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean importData(int start, int mahk, int[] tenmh, int[] sotc, int[] col){
        int numberOfSheet = myWorkBook.getNumberOfSheets();
        XSSFRow row;
        int maHK = mahk;
        
            for (int n = 0; n < numberOfSheet; n++) {
            System.out.println("Starting...");
            XSSFSheet sheet = myWorkBook.getSheetAt(n);
            
            row = sheet.getRow(tenmh[0]);
            String tenMH = row.getCell(tenmh[1]).getStringCellValue();
            
            row = sheet.getRow(sotc[0]);
            String soTC = "" + (int) row.getCell(sotc[1]).getNumericCellValue();
            
            MarkDAO markDAO = new MarkDAO();
            String maMH = markDAO.getMaMH(tenMH);
            
                for (int i = start;; i++) {
                    row = sheet.getRow(i);
                    String maSV = row.getCell(col[0]).getStringCellValue();
                    if (row.getCell(col[0]).getCellTypeEnum() == CellType.BLANK) {
                        break;
                    }
                    String diemCC = "";
                    if (row.getCell(col[1]).getCellTypeEnum() == CellType.NUMERIC) {
                        diemCC = "" + (float) row.getCell(col[1]).getNumericCellValue();
                    }

                    String diemKT = "";
                    if (row.getCell(col[2]).getCellTypeEnum() == CellType.NUMERIC) {
                        diemKT = "" + (float) row.getCell(col[2]).getNumericCellValue();
                    }

                    String diemTH = "";
                    if (row.getCell(col[3]).getCellTypeEnum() == CellType.NUMERIC) {
                        diemTH = "" + (float) row.getCell(col[3]).getNumericCellValue();
                    }
                    String diemBT = "";
                    if (row.getCell(col[4]).getCellTypeEnum() == CellType.NUMERIC) {
                        diemBT = "" + (float) row.getCell(col[4]).getNumericCellValue();
                    }
                    String diemThi = "";

                    if (row.getCell(col[5]).getCellTypeEnum() == CellType.NUMERIC) {
                        diemThi = "" + (float) row.getCell(col[5]).getNumericCellValue();
                    }

                    String diemTK = "" + (float) row.getCell(col[6]).getNumericCellValue();

                    String diemChu = row.getCell(col[7]).getStringCellValue();

                    Mark diem = new Mark(maHK, maSV, maMH, tenMH, soTC, diemCC, diemKT, diemBT, diemTH, diemThi, diemTK, diemChu);

                    boolean isSuccess = markDAO.insert(diem);
                    if(!isSuccess) return false;
                    System.out.println(i + " " + maHK + " " + maSV + " " + maMH + " " + tenMH + " " + soTC + " " + diemCC + " " + diemKT + " " + diemBT + " " + diemTH + " " + diemThi + " " + diemTK + " " + diemChu);
                }
            }
        
        
        return true;
    }

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");

        DataDiem diem1 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Cac ky thuat giau tin(web).xlsx");
        //diem1.importData(8);
        int a[] = {2,3};
        int b[] = {3,3};
        int c[] = {2,7,8,9,10,11,12,13};
        boolean t = diem1.importData(8, 20172,a ,b ,c );
        System.out.println(t);
//
//        DataDiem diem2 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD An toan va bao mat HTTT(web).xlsx");
//        diem2.importData2(8);
//  
//        DataDiem diem3 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Cac he thong phan tan(web).xlsx");
//        diem3.importData2(8);
//
//        DataDiem diem4 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Cac ky thuat giau tin(web).xlsx");
//        diem4.importData(8);
//
//        DataDiem diem5 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Cac ky thuat lap trinh(web).xlsx");
//        diem5.importData2(8);
//        
//        DataDiem diem6 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Cau truc du lieu va giai thuat(web).xlsx");
//        diem6.importData2(8);
//
//        DataDiem diem7 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Chuyen de cong nghe phan mem(web).xlsx");
//        diem7.importData2(8);
//
//        DataDiem diem8 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Chuyen de he thong thong tin(web).xlsx");
//        diem8.importData2(8);
//
//        DataDiem diem9 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Co so an toan thong tin(web).xlsx");
//        diem9.importData2(8);
//
//        DataDiem diem10 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Co so du lieu(web).xlsx");
//        diem10.importData(8);
//        
//        DataDiem diem11 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Dam bao chat luong phan mem(web).xlsx");
//        diem11.importData(8);
//
//        DataDiem diem12 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD He co so du lieu da phuong tien(web).xlsx");
//        diem12.importData2(8);
//
//        DataDiem diem13 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD He dieu hanh Windows va Linux_Unix(web).xlsx");
//        diem13.importData2(8);
//
//        DataDiem diem14 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Kho du lieu va khai pha du lieu(web).xlsx");
//        diem14.importData(8);
//
//        DataDiem diem15 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Kiem thu xam nhap mang(web).xlsx");
//        diem15.importData(8);
//
//        DataDiem diem16 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Kien truc may tinh(web).xlsx");
//        diem16.importData(8);
//
//        DataDiem diem17 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Kien truc va thiet ke phan mem(web).xlsx");
//        diem17.importData(8);
//
//        DataDiem diem18 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Ky thuat do hoa(web).xlsx");
//        diem18.importData(8);
//
//        DataDiem diem19 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Ky thuat theo doi va giam sat an toan mang(web).xlsx");
//        diem19.importData(8);
//        
//        DataDiem diem20 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Lap trinh web(web).xlsx");
//        diem20.importData2(8);
////        
//        DataDiem diem21 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Mang may tinh(web).xlsx");
//        diem21.importData(8);
//
//        DataDiem diem22 = new DataDiem(path + "\\CSDL\\Nganh CNTT\\BD Mat ma hoc co so(web).xlsx");
//        diem22.importData(8);
//
//        DataDiem diem23 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Nhap mon cong nghe phan mem(web).xlsx");
//        diem23.importData2(8);
//        DataDiem diem24 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Nhap mon tri tue nhan tao(web).xlsx");
//        diem24.importData(8);
//        DataDiem diem25 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Phan tich va thiet ke he thong thong tin(web).xlsx");
//        diem25.importData(8);
//        DataDiem diem26 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Phat trien he thong thong tin quan ly(web).xlsx");
//        diem26.importData2(8);
//     
//        DataDiem diem28 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Phat trien phan mem huong dich vu(web).xlsx");
//        diem28.importData(8);
//        DataDiem diem29 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD Phat trien ung dung cho cac thiet bi di dong(web).xlsx");
//        diem29.importData2(8);

       
    }
}

