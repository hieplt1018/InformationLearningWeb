/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportDataFromExcel;

import DAO.StudentDAO;
import connectDB.connectDB;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import org.apache.poi.ss.usermodel.CellType;
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

    public boolean importData(int start, int[] col){
        int numberOfSheet = myWorkBook.getNumberOfSheets();
        XSSFRow row;
        for (int n = 0; n < numberOfSheet; n++) {
            System.out.println("Starting...");
            XSSFSheet sheet = myWorkBook.getSheetAt(n);
            
            for (int i = start;; i++) {
                row = sheet.getRow(i);
//                System.out.println(row.getCell(col[0]).getCellTypeEnum());
                if (row.getCell(col[0]).getCellTypeEnum() == CellType.BLANK) {
                    break;
                }
                
                String lop = row.getCell(col[0]).getStringCellValue();
                String masv = row.getCell(col[1]).getStringCellValue();
                
                String ho = row.getCell(col[2]).getStringCellValue();
                String ten = row.getCell(col[3]).getStringCellValue();
                String ngaysinh = row.getCell(col[4]).getStringCellValue();
                Student sv = new Student(masv, lop, ho, ten, ngaysinh);
                
                boolean isSuccess = new StudentDAO().insert(sv);
                if(!isSuccess) return false;
                
                System.out.println(i + " " + lop + " " + masv + " " + ho + " " + ten + " " + ngaysinh);
            }
        }
        return true;
    }
     public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        new connectDB().setMaxConnection(60000);
        DataSinhvien dataTKB = new DataSinhvien("D:\\Documents\\NetBeansProjects\\idontknow\\DataExcel\\CSDL\\DS-phân-ngành-D15CN1.xlsx");
        
        int[] col = {1, 2, 3, 4, 5};
        boolean t = dataTKB.importData(6, col );
         System.out.println(t);
    }
}