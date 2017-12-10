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
public class SalesOrder<T> implements SalesOrderInterface<T> {
   
    private String host = "jdbc:derby://localhost:1527/FoodDeliverySystem";
    private String user = "FDSYS";
    private String password = "FDSYS";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public SalesOrder(){
        createConnection();
    }
    
    public boolean addSalesOrder(T salesOrderID, T RestaurantID, T CustomerID, T deliverry_address, T Distance, T date_Created, T sales_order_status){
        String Str = "INSERT INTO Sales_Order (SALES_ORDERID, RESTAURANTID, CUSTOMERID, DELIVERY_ADDRESS, DISTANCE, DATE_CREATED, SALES_ORDER_STATUS) VALUES (?,?,?,?,?,?,?)";      
        int temp = 0;
        try{
            stmt = conn.prepareStatement(Str,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, String.valueOf(salesOrderID));
            stmt.setString(2, String.valueOf(RestaurantID));
            stmt.setString(3, String.valueOf(CustomerID));
            stmt.setString(4, String.valueOf(deliverry_address));
            stmt.setString(5, String.valueOf(Distance));
            stmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            stmt.setString(7, String.valueOf(sales_order_status));
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
    
    public ArrayList getAllSalesOrder() {
        String Str = "SELECT * from sales_order";
        ArrayList array = new ArrayList();
        
        try {
            stmt = conn.prepareStatement(Str);
            rs = stmt.executeQuery();
            while (rs.next()) {
                array.add(rs.getString(1));
                array.add(rs.getString(6));
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
    
    public boolean addOrder(T OrderID, T ItemID, T Quantity, T CreatedDate){
        String Str = "INSERT INTO LINKORDER (OrderID, ItemID, Quantity, CreatedDate) VALUES (?,?,?,?)";      
        int temp = 0;
        try{
            stmt = conn.prepareStatement(Str,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, String.valueOf(OrderID));
            stmt.setString(2, String.valueOf(ItemID));
            stmt.setString(3, String.valueOf(Quantity));
            stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
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

    public int getNumberRows(){
        String Str = "SELECT Count(*) from sales_order";
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
