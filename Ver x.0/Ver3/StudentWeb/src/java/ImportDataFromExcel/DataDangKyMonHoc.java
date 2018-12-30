/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportDataFromExcel;

import DAO.DangKyMonHocDAO;
import connectDB.connectDB;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DangKyMonHoc;
import org.apache.poi.ss.usermodel.CellType;
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

    public boolean importData(int start, int mahk, int[] col) {
        int numberOfSheet = myWorkBook.getNumberOfSheets();
        XSSFRow row;
        int maHK = mahk;

        for (int n = 0; n < numberOfSheet; n++) {
            System.out.println("Starting...");
            XSSFSheet sheet = myWorkBook.getSheetAt(n);

            for (int i = start;; i++) {
                row = sheet.getRow(i);
                if (row.getCell(col[0]).getCellTypeEnum() == CellType.BLANK) {
                    break;
                }
                String maSV = row.getCell(col[0]).getStringCellValue();
                String[] lopMH = row.getCell(col[1]).getStringCellValue().split("-");
                String maNhom = lopMH[1];
                String maMH = row.getCell(col[2]).getStringCellValue();
                String tenMH = row.getCell(col[3]).getStringCellValue();
                String soTC = "" + (int) row.getCell(col[4]).getNumericCellValue();
                DangKyMonHoc dkmh = new DangKyMonHoc(maHK, maSV, maNhom, maMH, tenMH, soTC);
                boolean isSuccess = new DangKyMonHocDAO().insert(dkmh);
                if (!isSuccess) {
                    return false;
                }
                System.out.println(i + " " + maHK + " " + maSV + " " + maNhom + " " + maMH + " " + tenMH + " " + soTC);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        new connectDB().setMaxConnection(60000);
        DataDangKyMonHoc ddkmh1 = new DataDangKyMonHoc(path + "\\CSDL\\DS-lop-ky-2-nam-hoc.xlsx");
        int [] col = { 1, 8, 10, 11, 12};
        ddkmh1.importData(9, 20172, col);
    }
}
