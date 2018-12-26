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

/**
 *
 * @author Admin
 */
public class HocKyDao {
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private connectDB connectdb;

    public HocKyDao(connectDB connectdb) {
        this.connectdb = connectdb;
    }

    public void addHocKy() {
        
    }
    
}
