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
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private connectDB connectdb;

    public StudentDAO() {
        connectdb = new connectDB();
    }
    
    
    public Student getStudent(String studentID) throws SQLException, Exception {
            String sql = "SELECT * FROM tblsinhvien WHERE MaSV = '" + studentID + "'";
            System.out.println(sql);
            stmt = connectdb.openConnect().prepareStatement(sql);
            rs = stmt.executeQuery();
            Student student = null;
            while(rs.next()){
                String studentId = rs.getString("maSV");
                String lastName = rs.getString("Ho");
                String firstName = rs.getString("Ten");
                student = new Student(studentId, lastName, firstName);
            }
            return student;
    }
    
    public static void main(String[] args) throws Exception {
        StudentDAO dao = new StudentDAO();
//        Student duyen = dao.getStudent("B15DCCN209");
        System.out.println(dao.getStudent("B15DCCN209").getLastName() + dao.getStudent("B15DCCN209").getFirstName());
    }
}
