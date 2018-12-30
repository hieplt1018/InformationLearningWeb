/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportDataFromExcel;

import DAO.LichThiDAO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.LichThi;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Administrator
 */
public class DataLichThi {
    
    FileInputStream input;
    XSSFWorkbook myWorkBook;
    
    public DataLichThi(String excelFile) {
        try {
            input = new FileInputStream(excelFile);
            myWorkBook = new XSSFWorkbook(input);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataDiem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataSinhvien.class.getName()).log(Level.SEVERE, null, ex);
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
                String ngayThi = row.getCell(col[0]).getStringCellValue();
                String tietBD = "" + (int) row.getCell(col[1]).getNumericCellValue();
                String gioBD = row.getCell(col[2]).getStringCellValue();
                String maMH = row.getCell(col[3]).getStringCellValue();
                String maNhom = "";
                if (row.getCell(col[4]).getCellTypeEnum() == CellType.NUMERIC) {
                    maNhom = "" + (int) row.getCell(col[4]).getNumericCellValue();
                } else if (row.getCell(col[4]).getCellTypeEnum() == CellType.FORMULA) {
                    maNhom = "" + (int) row.getCell(col[4]).getNumericCellValue();
                } else {
                    maNhom = row.getCell(col[4]).getStringCellValue();
                }
                String toThi = row.getCell(col[5]).getStringCellValue();
                String tenMH = row.getCell(col[6]).getStringCellValue();
                String siSo = "" + (int) row.getCell(col[7]).getNumericCellValue();
                String phongThi = row.getCell(col[8]).getStringCellValue();
                String ghiChu = row.getCell(col[9]).getStringCellValue();
                String giangVien = row.getCell(col[10]).getStringCellValue();
                LichThi lt = new LichThi(maHK, maMH, maNhom, tenMH, ngayThi, tietBD, gioBD, toThi, siSo, phongThi, giangVien, ghiChu);
                boolean isSuccess = new LichThiDAO().insert(lt);
                if(!isSuccess) return false;
                System.out.println(i + " " + ngayThi + " " + tietBD + " "
                        + gioBD + " " + maMH + " " + maNhom + " " + toThi + " " + tenMH + " " + siSo + " " + phongThi + " " + ghiChu + " " + giangVien);
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        DataLichThi d = new DataLichThi(path + "\\CSDL\\Lich-thi-HK-2-nam-hoc-2017-2018-10-042.xlsx");System.out.println(path+"\\CSDL\\DS-phân-ngành-D15CN1.xlsx");
        int [] col = {0, 1, 2, 3, 4, 5, 6, 7 ,8, 9, 14};
        d.importData(8, 20172, col);
    }
}
