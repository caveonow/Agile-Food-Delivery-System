/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author caveon
 */
public class SalesOrder {
   
    private String host = "jdbc:derby://localhost:1527/FoodDeliverySystem";
    private String user = "FDSYS";
    private String password = "FDSYS";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public SalesOrder(){
        createConnection();
    }
    
    public ArrayList getAllSalesOrder() {
        String Str = "SELECT * from customer";
        ArrayList array = new ArrayList();
        
        try {
            stmt = conn.prepareStatement(Str);
            rs = stmt.executeQuery();
            while (rs.next()) {
                array.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return array;
    }
    
    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
