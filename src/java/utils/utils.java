/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HuynhDuong
 */

public class utils {
    public static Connection createConnection() {
        Connection conn = null;
            String DB_URL = "jdbc:sqlserver://localhost:1433;"
                    +"databaseName=ShoppingCart;";
            
            try {
                //connect to database
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection(DB_URL, "sa", "12345");
                //create statement
            } catch(Exception ex) {
                System.out.println("Error connection");
            }
            return conn;
    }
}