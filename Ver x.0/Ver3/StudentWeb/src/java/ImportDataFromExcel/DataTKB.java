/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportDataFromExcel;

import DAO.TKBDAO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TKB;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Administrator
 */
public class DataTKB {

    FileInputStream input;
    XSSFWorkbook myWorkBook;

    public DataTKB(String excelFile) {
        try {
            input = new FileInputStream(excelFile);
            myWorkBook = new XSSFWorkbook(input);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataTKB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataTKB.class.getName()).log(Level.SEVERE, null, ex);
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
                String maMH = row.getCell(col[0]).getStringCellValue();
                String tenMH = row.getCell(col[1]).getStringCellValue();

                String maNhom = "";
                if (row.getCell(col[2]).getCellTypeEnum() == CellType.NUMERIC) {
                    maNhom = "" + (int) row.getCell(col[2]).getNumericCellValue();
                } else if (row.getCell(col[2]).getCellTypeEnum() == CellType.FORMULA) {
                    maNhom = "" + (int) row.getCell(col[2]).getNumericCellValue();
                } else {
                    maNhom = row.getCell(col[2]).getStringCellValue();
                }

                String toHop = "";
                if (row.getCell(col[3]).getCellTypeEnum() == CellType.STRING) {
                    toHop = row.getCell(col[3]).getStringCellValue();
                } else if (row.getCell(col[3]).getCellTypeEnum() == CellType.NUMERIC) {
                    toHop = "" + (int) row.getCell(col[3]).getNumericCellValue();
                }

                String toTH = "";
                if (row.getCell(col[4]).getCellTypeEnum() == CellType.STRING) {
                    toTH = row.getCell(col[4]).getStringCellValue();
                }

                int thu = (int) row.getCell(col[5]).getNumericCellValue();
                int tietBD = (int) row.getCell(col[6]).getNumericCellValue();
                int soTiet = (int) row.getCell(col[7]).getNumericCellValue();
                int kip = (int) row.getCell(col[8]).getNumericCellValue();

                String phong = "";
                if (row.getCell(col[9]).getCellTypeEnum() == CellType.NUMERIC) {
                    phong = "" + (int) row.getCell(col[9]).getNumericCellValue();
                } else {
                    phong = row.getCell(col[9]).getStringCellValue();
                }

                String nha = "";
                if (row.getCell(col[10]).getCellTypeEnum() == CellType.STRING) {
                    nha = row.getCell(col[10]).getStringCellValue();
                }

                String tuanHoc = "";
                for (int j = 1; j <= 19; j++) {
                    if (row.getCell(j + col[11]).getCellTypeEnum() == CellType.STRING) {
                        tuanHoc += Integer.toString(j % 10);
                    } else {
                        tuanHoc += "-";
                    }
                }

                String giangVien = row.getCell(col[12]).getStringCellValue();
                TKB tkb = new TKB(maHK, maMH, maNhom, tenMH, toHop, toTH, thu, tietBD, soTiet, kip, phong, nha, tuanHoc, giangVien);

                boolean isSuccess = new TKBDAO().insert(tkb);
                if (!isSuccess) {
                    return false;
                }
                System.out.println(i + " " + maHK + " " + maNhom + " " + maMH + " " + tenMH + " " + toHop + " " + toTH + " " + thu + " " + tietBD + " " + soTiet + " " + kip + " " + phong + " " + nha + " " + tuanHoc + " " + giangVien);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        DataTKB dataTKB = new DataTKB(path + "\\CSDL\\TKB-HK2-NAM-HOC-2017-2018-10_02.xlsx");
        int [] col = { 1, 2, 4, 5, 6, 10, 11, 12, 13, 15, 16, 17, 39};
        dataTKB.importData(11, 20172, col);
    }
}
