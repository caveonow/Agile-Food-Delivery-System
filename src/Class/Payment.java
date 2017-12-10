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
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author caveon
 */
public class Payment<T> implements PaymentInterface<T>{

    private String host = "jdbc:derby://localhost:1527/FoodDeliverySystem";
    private String user = "FDSYS";
    private String password = "FDSYS";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public Payment(){
        createConnection();
    }
    
    @Override
    public boolean addPayment(T PaymentID, T SalesOrderID, T PaymentType, T TotalPayment, T PaymentDate) {
        String Str = "INSERT INTO payment (PaymentID, Sales_Order, PaymentType, TotalPayment,PaymentDate) VALUES (?,?,?,?,?)";      
         Integer numRow = getNumberRows() ;
         String PayID = "";
         if (numRow < 10){
            PayID = "P000" + Integer.toString(numRow);
        }else if(numRow < 100){
            PayID = "P00" + Integer.toString(numRow);
        }else{
            PayID = "P0" + Integer.toString(numRow);
        }
        int temp = 0;
        try{
            stmt = conn.prepareStatement(Str,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, String.valueOf(PayID));
            stmt.setString(2, String.valueOf(SalesOrderID));
            stmt.setString(3, String.valueOf(PaymentType));
            stmt.setString(4, String.valueOf(TotalPayment));
            stmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            stmt.executeUpdate();
            ResultSet keys = stmt.getGeneratedKeys();
            while (keys.next()){
                temp = keys.getInt(1);
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        return false;
    }
    
    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public int getNumberRows(){
        String Str = "SELECT COUNT(*) from payment";
        Integer rowCount = 0;
    try{
            stmt = conn.prepareStatement(Str);
            rs = stmt.executeQuery();
                rs.next();
                rowCount = rs.getInt(1);
    } catch (Exception e){
       System.out.println("Error getting row count");
       e.printStackTrace();
    }
    return rowCount;
}
}
