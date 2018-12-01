/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportDataFromExcel;

import DAO.SinhVienDAO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.SinhVien;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Administrator
 */
public class DataSinhvien {

    FileInputStream input;
    XSSFWorkbook myWorkBook;
    public DataSinhvien(String excelFile) {
        try {
            input = new FileInputStream(excelFile);
            myWorkBook = new XSSFWorkbook(input);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataDiem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataSinhvien.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void importData(int n, int start, int end) {
        System.out.println("Starting...");
        XSSFSheet sheet = myWorkBook.getSheetAt(n);
        XSSFRow row;
        for (int i = start; i <= end; i++) {
            row = sheet.getRow(i);
            String lop = row.getCell(1).getStringCellValue();
            String masv = row.getCell(2).getStringCellValue();
            String ho = row.getCell(3).getStringCellValue();
            String ten = row.getCell(4).getStringCellValue();
            String ngaysinh = row.getCell(5).getStringCellValue();
            SinhVien sv = new SinhVien(lop, masv, ho, ten, ngaysinh);
            SinhVienDAO dAO = new SinhVienDAO();
            dAO.insert(sv);
            System.out.println(i + " " + lop + " " + masv + " " + ho + " " + ten + " " + ngaysinh);
        }
        System.out.println("Finish!");
    }
    
}
