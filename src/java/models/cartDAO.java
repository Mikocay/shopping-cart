/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import utils.utils;

/**
 *
 * @author HuynhDuong
 */
public class cartDAO {
    public boolean addCart(cartDTO cart) {
        boolean check = true;
        try {
        Connection conn = utils.createConnection();
        List<bookCartDTO> list = cart.getList();
        int userId = cart.getUser().getId();
        for(bookCartDTO book: list) {
            PreparedStatement p = conn.prepareStatement("INSERT INTO tblCart (user_id, book_id, quantity) VALUES (?, ?, ?)");
            p.setInt(1, userId);
            p.setInt(2, book.getId());
            p.setFloat(3, book.getQuantity());
            
            int value = p.executeUpdate();
            if(value <= 0) {
                check = false;
                break;
            }
            p.close();
        }
        conn.close();
        } catch(SQLException ex){
            System.out.println("Error add cart");
        }
        
        return check;
    }
}
