/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author admin
 */
public class connectDB {
    Connection connect = null;
    Statement stmt = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String user = "root";
    String pass = "12345678";

    public void hasDriver() throws Exception {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
//            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new Exception("Invalid Driver!!Please check this drver....");
        }
    }

    public Connection openConnect() throws Exception {
        hasDriver();
        String url = "jdbc:mariadb://localhost:3307/studentweb";
        try {
            this.connect = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối : " + e.getMessage());
        }
        return connect;
    }

    public Statement getStatement() throws SQLException, Exception {
        if (stmt == null) {
            stmt = openConnect().createStatement();
        }
        return stmt;
    }

    public PreparedStatement getPreparedStatement() throws Exception {
        if (ps == null) {
            ps = (PreparedStatement) openConnect().createStatement();
        }
        return ps;
    }

    public void closeConnet() throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (connect != null) {
            connect.close();
        }
    }
    
    public void setMaxConnection(int n) {
        try {
            String sql = "set global max_connections = " + n;
            stmt = getStatement();
            stmt.executeQuery(sql);

        } catch (SQLException ex) {
        } catch (Exception ex) {
        }
    }
}
