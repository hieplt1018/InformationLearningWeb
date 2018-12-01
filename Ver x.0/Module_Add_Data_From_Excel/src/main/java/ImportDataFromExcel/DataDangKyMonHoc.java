/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportDataFromExcel;

import DAO.DangKyMonHocDAO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DangKyMonHoc;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




/**
 *
 * @author Administrator
 */
public class DataDangKyMonHoc {
    FileInputStream input;
    XSSFWorkbook myWorkBook;
    public DataDangKyMonHoc(String excelFile) {
        try {
            input = new FileInputStream(excelFile);
            
            myWorkBook = new XSSFWorkbook(input);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataDangKyMonHoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataDangKyMonHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void importData(int n, int start, int end) {
        System.out.println("Starting...");
        XSSFSheet sheet = myWorkBook.getSheetAt(n);
        XSSFRow row;
        int maHK = 20172;
        for (int i = start; i <= end; i++) {
            row = sheet.getRow(i);
            String maSV = row.getCell(1).getStringCellValue();
            String[] lopMH = row.getCell(8).getStringCellValue().split("-");
            String maNhom = lopMH[1];
            String maMH = row.getCell(10).getStringCellValue();
            String tenMH = row.getCell(11).getStringCellValue();
            String soTC = ""+ (int)row.getCell(12).getNumericCellValue();
            DangKyMonHoc dkmh = new DangKyMonHoc(maHK, maSV, maNhom, maMH, tenMH, soTC);
            DangKyMonHocDAO dAO= new DangKyMonHocDAO();
            dAO.insert(dkmh);
            System.out.println(i + " " + maHK + " " + maSV + " " + maNhom + " " + maMH + " " + tenMH + " " + soTC);
        }
        System.out.println("Finish!");
    }
    
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        DataDangKyMonHoc ddkmh1 = new DataDangKyMonHoc(path+"\\CSDL\\DS-lop-ky-2-nam-hoc.xlsx");
        ddkmh1.importData(0, 9, 56638);
    }
}
