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

public class test {
    
    

    public static void main(String[] args) {
        
        
        
        try {
            Connection conn = utils.createConnection();
            PreparedStatement p = conn.prepareStatement("select * from tblUser");
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2)
                        + " " + rs.getString(3) );
            }

            rs.close();
            p.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("Erorr");
        }
        
    
}

}
