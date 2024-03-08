/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.utils;

/**
 *
 * @author HuynhDuong
 */
public class userDAO {
    public boolean checklogin(String username, String password) {
        boolean check = false;
        try {
            Connection conn = utils.createConnection();
            PreparedStatement p = conn.prepareStatement("select * from tblUser "
            + "where username=? and password=?");

            p.setString(1, username);
            p.setString(2, password);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                check = true;
            }

            rs.close();
            p.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("Erorr");
        }
        return check;
    }
    
    public userDTO getuser (String userName, String password) {
        userDTO user = null;
        try {
            Connection conn = utils.createConnection();
            PreparedStatement p = conn.prepareStatement("select * from tblUser "
            + "where username=? and password=?");
            p.setString(1, userName);
            p.setString(2, password);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt(1);
                String username = rs.getString(2);
                String pass = rs.getString(3);  
                String fullname = rs.getString(4);
                
                user = new userDTO(userId, username, pass, fullname);
            }
            rs.close();
            p.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Erorr connect DB");
        }
        return user;
    }
    
        public String getFullName(String username) {
        String fullName = "";
                try {
            Connection conn = utils.createConnection();
            PreparedStatement p = conn.prepareStatement("select * from tblUser"
                    + " where username=?");
            p.setString(1, username);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                 fullName = rs.getString("fullname");
            }
            rs.close();
            p.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("Erorr");
        }
                return fullName;
    }
}
