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

    public void importData(int n, int start, int end) {
        System.out.println("Starting...");
        XSSFSheet sheet = myWorkBook.getSheetAt(n);
        XSSFRow row;
        int maHK = 20172;
       
  
        for (int i = start; i <= end; i++) {
            row = sheet.getRow(i);
            String maMH = row.getCell(1).getStringCellValue();
            String tenMH = row.getCell(2).getStringCellValue();
            
            String maNhom = "";
            if(row.getCell(4).getCellTypeEnum() == CellType.NUMERIC) maNhom = ""+(int)row.getCell(4).getNumericCellValue();
            else if(row.getCell(4).getCellTypeEnum() == CellType.FORMULA) maNhom = ""+(int)row.getCell(4).getNumericCellValue();
            else maNhom = row.getCell(4).getStringCellValue();
            
            String toHop = "";
            if(row.getCell(5).getCellTypeEnum() == CellType.STRING) toHop = row.getCell(5).getStringCellValue();
            else if(row.getCell(5).getCellTypeEnum() == CellType.NUMERIC) toHop = ""+(int)row.getCell(5).getNumericCellValue();
            
            String toTH = "";
            if(row.getCell(6).getCellTypeEnum() == CellType.STRING) toTH = row.getCell(6).getStringCellValue();
           
            int thu = (int) row.getCell(10).getNumericCellValue();
            int tietBD = (int) row.getCell(11).getNumericCellValue();
            int soTiet = (int) row.getCell(12).getNumericCellValue();
            int kip = (int) row.getCell(13).getNumericCellValue();
             
            String phong = "";
            if(row.getCell(15).getCellTypeEnum() == CellType.NUMERIC) phong = ""+(int)row.getCell(15).getNumericCellValue();
            else phong = row.getCell(15).getStringCellValue();
            
            String nha = "";
            if(row.getCell(16).getCellTypeEnum() == CellType.STRING) nha = row.getCell(16).getStringCellValue();
            
            String tuanHoc ="";
            for(int j = 1; j<=19; j++){
                if(row.getCell(j+17).getCellTypeEnum() == CellType.STRING) tuanHoc +=Integer.toString(j%10);
                else tuanHoc += "-";
            }
            
            String giangVien = row.getCell(39).getStringCellValue();
            TKB tkb = new TKB(maHK, maMH, maNhom, tenMH, toHop, toTH, thu, tietBD, soTiet, kip, phong, nha, tuanHoc, giangVien);
            TKBDAO tkbdao = new  TKBDAO();
            tkbdao.insert(tkb);
            //System.out.println(i + " " + maHK+ " " +maNhom+ " " +maMH+ " " +tenMH+ " " +toHop+ " " +toTH+ " " +thu+ " " +tietBD+ " " +soTiet+ " " +kip+ " " +phong+ " " +nha+ " " +tuanHoc+ " " +giangVien);
        }
        System.out.println("Finish!");
    }
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        DataTKB dataTKB = new DataTKB(path+"\\CSDL\\TKB-HK2-NAM-HOC-2017-2018-10_02.xlsx");
        dataTKB.importData(1, 11, 2174);
    }
}
