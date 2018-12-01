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
import static java.lang.System.out;
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
    public void importData(int n, int start, int end) {
        System.out.println("Starting...");
        XSSFSheet sheet = myWorkBook.getSheetAt(n);
        XSSFRow row;
        int maHK = 20172;
        for (int i = start; i <= end; i++) {
            row = sheet.getRow(i);
            String ngayThi= row.getCell(0).getStringCellValue();
            String tietBD = ""+ (int)row.getCell(1).getNumericCellValue();
            String gioBD = row.getCell(2).getStringCellValue();
            String maMH = row.getCell(3).getStringCellValue();
            String maNhom = "";
            if(row.getCell(4).getCellTypeEnum() == CellType.NUMERIC) maNhom = ""+(int)row.getCell(4).getNumericCellValue();
            else if(row.getCell(4).getCellTypeEnum() == CellType.FORMULA) maNhom = ""+(int)row.getCell(4).getNumericCellValue();
            else maNhom = row.getCell(4).getStringCellValue();
            String toThi = row.getCell(5).getStringCellValue();
            String tenMH = row.getCell(6).getStringCellValue();
            String siSo = ""+(int)row.getCell(7).getNumericCellValue();
            String phongThi = row.getCell(8).getStringCellValue();
            String ghiChu = row.getCell(9).getStringCellValue();
            String giangVien = row.getCell(14).getStringCellValue();
            LichThi lt = new LichThi(maHK, maMH, maNhom, tenMH, ngayThi, tietBD, gioBD, toThi, siSo, phongThi, giangVien, ghiChu);
            LichThiDAO dAO = new LichThiDAO();
            dAO.insert(lt);
            System.out.println(i + " " + ngayThi + " " + tietBD + " " 
                    +gioBD + " " + maMH+" " + maNhom + " " + toThi+ " " +tenMH+ " " +siSo+ " " +phongThi+ " " +ghiChu+ " " +giangVien );
        }
        System.out.println("Finish!");
    }
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        DataLichThi d = new DataLichThi(path+"\\CSDL\\Lich-thi-HK-2-nam-hoc-2017-2018-10-042.xlsx");
        d.importData(1, 8, 1810);
    }
}
