/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connectDB.connectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;

/**
 *
 * @author admin
 */
public class StudentDAO {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private connectDB connectdb;

    public StudentDAO() {
        connectdb = new connectDB();
    }
    
    
    public Student getStudent(String studentID) throws SQLException, Exception {
        Student student = new Student();
        String strSQL = "select * from tblSinhVien where MaSV = '" + studentID + "'";
        try {
            rs = connectdb.getStatement().executeQuery(strSQL);
            while (rs.next()) {
                student.setsClass(rs.getString("Lop"));
                student.setsId(rs.getString("MaSV"));
                student.setLastName(rs.getString("Ho"));
                student.setFirstName(rs.getString("Ten"));
                student.setDateOfBirth(rs.getString("NgaySinh"));
                student.setPlaceOfBirth(rs.getString("NoiSinh"));
                student.setSex(rs.getString("GioiTinh"));
                student.setEmail(rs.getString("Email"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;  
    }
    
    public void updatePassword(String studentID, String password) throws Exception {
        String strSQL = "UPDATE tblSinhVien SET Password = '" + password + "' where MaSV = '" + studentID + "'";
        rs = connectdb.getStatement().executeQuery(strSQL);
    }
    
    public void updateEmail(String studentID, String email) throws Exception {
        String strSQL = "UPDATE tblSinhVien SET Email = '" + email + "' where MaSV = '" + studentID + "'";
        System.out.println(strSQL);
        rs = connectdb.getStatement().executeQuery(strSQL);
        System.out.println("Thêm Email thành công!");
    }
    
    public boolean checkLoginDuPhong(String studentID, String password) {
        Student student = new Student();
        String strSQL = "select Password from tblSinhVien where MaSV = '" + studentID + "'";
        try {
            rs = connectdb.getStatement().executeQuery(strSQL);
            while (rs.next()) {
                if(password.equals(rs.getString("Password"))){
                    return true;
                } ;
            }
            
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean insert(Student sv) {
        try {
            String sql = "insert into tblsinhvien (Lop, MaSV, Ho, Ten, NgaySinh) values(?,?,?,?,?)";
            ps = connectdb.openConnect().prepareStatement(sql);
            ps.setString(1, sv.getsClass());
            ps.setString(2, sv.getsId());
            ps.setString(3, sv.getLastName());
            ps.setString(4, sv.getFirstName());
            ps.setString(5, sv.getDateOfBirth());
            return ps.executeUpdate() == 1;
        } catch (Exception ex) {
            System.out.println("eror" + ex.getMessage());
            return false;
        }
    }

    public boolean update(Student sv) {
        try {
            String sql = "update tblsinhvien a "
                    + "set a.Ho = ? ,  a.Ten= ? , a.NgaySinh = ? , a.GioiTinh = ? , a.NoiSinh = ? "
                    + "where a.maSV = ?";
            ps = connectdb.openConnect().prepareStatement(sql);

            ps.setString(1, sv.getLastName());
            ps.setString(2, sv.getFirstName());
            ps.setString(3, sv.getDateOfBirth());
            ps.setString(4, sv.getSex());
            ps.setString(5, sv.getPlaceOfBirth());
            ps.setString(6, sv.getsId());
            System.out.println(ps.executeUpdate());
            return ps.executeUpdate() >= 1;
        } catch (Exception ex) {
            System.out.println("eror" + ex.getMessage());
            return false;
        }
    }
    
    public static void main(String[] args) throws Exception {
        StudentDAO dao = new StudentDAO();
        Student sv = dao.getStudent("B15DCCN209");
        System.out.println(sv.getLastName() + sv.getFirstName());
        System.out.println(dao.checkLoginDuPhong("B15DCCN660", "vuong19971015"));
        
    }
}
