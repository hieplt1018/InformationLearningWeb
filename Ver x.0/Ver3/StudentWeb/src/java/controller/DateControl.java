/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author Admin
 */
public class DateControl {
    long miliSeconds = System.currentTimeMillis();
    Date toDay = new Date(miliSeconds);
    Date date = new Date();
    
    public DateControl() {
    }
    
    
    public int getSttTuan(String date) {
        int sttTuan = 1;
        String[] arr = date.split("\\/");
        int day = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int year = Integer.parseInt(arr[2]);
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);
        Date day1 = calendar.getTime();
        String monthOfYear = new SimpleDateFormat("w").format(day1);
        return Integer.parseInt(monthOfYear);
    }
    
    public int getSttThisWeek(){
        String day = new SimpleDateFormat("w").format(date);
        return Integer.parseInt(day);
    }
    
    public int chuyenDoiThuTrongTuan() {
        String day = new SimpleDateFormat("E").format(date);
        if(day.equals("Mon")){
            return 2;
        } else if(day.equals("Tue")) {
            return 3;
        } else if(day.equals("Wed")) {
            return 4;
        } else if(day.equals("Thu")) {
            return 5;
        } else if(day.equals("Fri")) {
            return 6;
        } else {
            return 7;
        }
    }
    
    public String getToday() {
        String day = new SimpleDateFormat("MMMMM d, yyyy").format(date);
        return day;
    }
    public static void main(String[] args) {
        DateControl datectr = new DateControl();
        System.out.println(datectr.chuyenDoiThuTrongTuan());
        System.out.println(datectr.getSttThisWeek());
        System.out.println(datectr.getSttTuan("15/08/2018"));
    }
}
