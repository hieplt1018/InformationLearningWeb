/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportDataFromExcel;

import DAO.DiemDAO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Diem;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
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

    public void importData(int start) {
        int numberOfSheet = myWorkBook.getNumberOfSheets();
        XSSFRow row;
        int maHK = 20171; // diem29, 30, 31,32 dung ma HK nay
//        int maHK = 20172;
        for (int n = 0; n < numberOfSheet; n++) {
            System.out.println("Starting...");
            XSSFSheet sheet = myWorkBook.getSheetAt(n);
            row = sheet.getRow(2);
            String tenMH = row.getCell(3).getStringCellValue();
            row = sheet.getRow(3);
            String soTC = "" + (int) row.getCell(3).getNumericCellValue();
            DiemDAO dAO = new DiemDAO();
//            String maMH = dAO.getMaMH(tenMH);
            String maMH = "INT1332"; // Do 29, 30 ,21, 32 chưa cập nhật trong lịch thi nên phải add maMH bằng tay
            for (int i = start;; i++) {
                row = sheet.getRow(i);
                String maSV = row.getCell(2).getStringCellValue();
                String diemCC = "";
                if (row.getCell(7).getCellTypeEnum() == CellType.NUMERIC) {
                    diemCC = "" + (float) row.getCell(7).getNumericCellValue();
                }

                String diemKT = "";
                if (row.getCell(8).getCellTypeEnum() == CellType.NUMERIC) {
                    diemKT = "" + (float) row.getCell(8).getNumericCellValue();
                }

                String diemTH = "";
                if (row.getCell(9).getCellTypeEnum() == CellType.NUMERIC) {
                    diemTH = "" + (float) row.getCell(9).getNumericCellValue();
                }
                String diemBT = "";
                if (row.getCell(10).getCellTypeEnum() == CellType.NUMERIC) {
                    diemBT = "" + (float) row.getCell(10).getNumericCellValue();
                }
                String diemThi = "";

                if (row.getCell(11).getCellTypeEnum() == CellType.NUMERIC) {
                    diemThi = "" + (float) row.getCell(11).getNumericCellValue();
                }

                String diemTK = "" + (float) row.getCell(12).getNumericCellValue();
                
                String diemChu = row.getCell(13).getStringCellValue();
                
                Diem diem = new Diem(maHK, maSV, maMH, tenMH, soTC, diemCC, diemKT, diemBT, diemTH, diemThi, diemTK, diemChu);
                
                dAO.insert(diem);
                if (row.getCell(2).getCellTypeEnum() == CellType.BLANK) {
                    break;
                }
                System.out.println(i + " " + maHK + " " + maSV + " " + maMH + " " + tenMH + " " + soTC + " " + diemCC + " " + diemKT + " " + diemBT + " " + diemTH + " " + diemThi + " " + diemTK + " " + diemChu);
            }
            
            System.out.println("Finish!");
        }
    }

    public void importData2(int start) {
        int numberOfSheet = myWorkBook.getNumberOfSheets();
        XSSFRow row;
        int maHK = 20171;
        
        for (int n = 0; n < numberOfSheet; n++) {
            System.out.println("Starting...");
            XSSFSheet sheet = myWorkBook.getSheetAt(n);
            row = sheet.getRow(2);
            String tenMH = row.getCell(3).getStringCellValue();
            row = sheet.getRow(3);
            String soTC = "" + (int) row.getCell(3).getNumericCellValue();
            DiemDAO dAO = new DiemDAO();
            String maMH = dAO.getMaMH(tenMH);
            for (int i = start; ; i++) {
                row = sheet.getRow(i);
                String maSV = row.getCell(2).getStringCellValue();

                String diemCC = "";
                if (row.getCell(7).getCellTypeEnum() == CellType.NUMERIC) {
                    diemCC = "" + (float) row.getCell(7).getNumericCellValue();
                }

                String diemKT = "";
                if (row.getCell(8).getCellTypeEnum() == CellType.NUMERIC) {
                    diemKT = "" + (float) row.getCell(8).getNumericCellValue();
                }

                String diemTH = "";
                if (row.getCell(9).getCellTypeEnum() == CellType.NUMERIC) {
                    diemTH = "" + (float) row.getCell(9).getNumericCellValue();
                }

                String diemBT = "";
                if (row.getCell(10).getCellTypeEnum() == CellType.NUMERIC) {
                    diemBT = "" + (float) row.getCell(10).getNumericCellValue();
                }

                String diemThi = "";
                if (row.getCell(15).getCellTypeEnum() == CellType.NUMERIC) {
                    diemThi = "" + (float) row.getCell(15).getNumericCellValue();
                }

                String diemTK = "" + (float) row.getCell(16).getNumericCellValue();
               
                String diemChu = row.getCell(17).getStringCellValue();;
                Diem diem = new Diem(maHK, maSV, maMH, tenMH, soTC, diemCC, diemKT, diemBT, diemTH, diemThi, diemTK, diemChu);
                dAO.insert(diem);
                if (row.getCell(2).getCellTypeEnum() == CellType.BLANK) {
                    break;
                }
                System.out.println(i + " " + maHK + " " + maSV + " " + maMH + " " + tenMH + " " + soTC + " " + diemCC + " " + diemKT + " " + diemBT + " " + diemTH + " " + diemThi + " " + diemTK + " " + diemChu);
            }
            System.out.println("Finish!");
        }
    }

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
//        DataDiem diem = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD An toan he dieu hanh(web).xlsx");
//        diem.importData(8);
//
//        DataDiem diem1 = new DataDiem(path+"\\CSDL\\Nganh CNTT\\BD An toan mang nang cao(web).xlsx");
//        diem1.importData(8);
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
//        diem23.importData(8);
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
//
//        DataDiem diem30 = new DataDiem(path + "\\CSDL\\Nganh CNTT\\Co so du lieu (web).xlsx");
//        diem30.importData(8);
        
//        DataDiem diem31 = new DataDiem(path + "\\CSDL\\Nganh CNTT\\He dieu hanh(web).xlsx");
//        diem31.importData(8);
////        
//        DataDiem diem32 = new DataDiem(path + "\\CSDL\\Nganh CNTT\\Ky thuat vi xu ly(web).xlsx");
//        diem32.importData(8);
//        
        DataDiem diem33 = new DataDiem(path + "\\CSDL\\Nganh CNTT\\Lap trinh huong doi tuong(web).xlsx");
        diem33.importData(8);
    }
}
//    public String doiSangChu(float n) {
//        String chu;
//        if (n >= 9 && n <= 10) {
//            chu = "A+";
//        } else if (n >= 8.5 && n < 9) {
//            chu = "A";
//        } else if (n >= 8 && n < 8.5) {
//            chu = "B+";
//        } else if (n >= 7 && n < 8) {
//            chu = "B";
//        } else if (n >= 6.5 && n < 7) {
//            chu = "C+";
//        } else if (n >= 5.5 && n < 6.5) {
//            chu = "C";
//        } else if (n >= 5 && n < 5.5) {
//            chu = "D+";
//        } else if (n >= 4 && n < 5) {
//            chu = "D";
//        } else {
//            chu = "F";
//        }
//        return chu;
//    }
