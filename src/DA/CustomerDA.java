/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DA;

import Domain.Item;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class CustomerDA {
    private String host = "jdbc:derby://localhost:1527/HotelDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Customer";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public CustomerDA() {
        createConnection();
    }
   
    public Customer getRecord(String cusID){
        String queryStr = "SELECT * FROM " + tableName + " WHERE customer_id = ?";
        Customer customer = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1,cusID);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                customer = new Customer(cusID,rs.getString("customer_IC"),rs.getString("customer_name")
                                        ,rs.getString("cphone_no"),rs.getString("customer_address")
                                        ,rs.getString("customer_gender").charAt(0),rs.getString("customer_email"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return customer;
    }
    
    public void insertRecord(Customer cus){
        String str = "INSERT INTO " + tableName + " VALUES(?,?,?,?,?,?,?)";
        
        try{
            stmt = conn.prepareStatement(str);
            stmt.setString(1,cus.getCustomerId());
            stmt.setString(2,cus.getCustomerIc());
            stmt.setString(3,cus.getCustomerName());
            stmt.setString(4,cus.getCphoneNo());
            stmt.setString(5,cus.getCustomerAddress());
            stmt.setString(6,String.valueOf(String.valueOf(cus.getCustomerGender()).charAt(0)));
            stmt.setString(7,cus.getCustomerEmail());
            
             stmt.executeUpdate();
            }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void modifyRecord(Customer cus){
        String str = "UPDATE " + tableName + " SET CUSTOMER_IC = ?, CUSTOMER_NAME = ?, CPHONE_NO = ?, CUSTOMER_ADDRESS = ?, CUSTOMER_GENDER = ?, CUSTOMER_EMAIL = ? WHERE CUSTOMER_ID = ?";
         try{
                    stmt = conn.prepareStatement(str);
                   
                    
                    stmt.setString(1, cus.getCustomerIc());
                    stmt.setString(2, cus.getCustomerName());
                    stmt.setString(3, cus.getCphoneNo());
                    stmt.setString(4, cus.getCustomerAddress());
                    stmt.setString(5, String.valueOf(String.valueOf(cus.getCustomerGender()).charAt(0)));
                    stmt.setString(6, cus.getCustomerEmail());
                    stmt.setString(7, cus.getCustomerId());
                    
                    stmt.executeUpdate();   
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void deleteRecord(Customer cus){
        String str = "DELETE FROM " + tableName + " WHERE CUSTOMER_ID = ?";
        
        try{
                    stmt = conn.prepareStatement(str);
                    stmt.setString(1,cus.getCustomerId());
                    stmt.executeUpdate();  
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Customer checkCustomerName(String cusName){
           String queryStr = "";
           queryStr = "SELECT * FROM "+ tableName;
           Customer customer = null;
                
        try {   
             stmt = conn.prepareStatement(queryStr);
             rs = stmt.executeQuery();
             
             if(rs.next()){            
                 customer = new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6).charAt(0),rs.getString(7));             
             }
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
             return customer;        
}
    
    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int generateNewID() {
        String queryStr = "SELECT CUSTOMER_ID FROM CUSTOMER";
        int count = 1;
            try {
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                count++;  
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            return count;
    }

    public Boolean getIC(String reserveCustomer) {
           String queryStr = "SELECT * FROM "+ tableName + " WHERE CUSTOMER_ID = ? ";
           Boolean customer = null;
                
        try {   
             stmt = conn.prepareStatement(queryStr);
             stmt.setString(1, reserveCustomer);
             rs = stmt.executeQuery();
             
             customer = rs.next();
    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return false;

    }

    public ArrayList<Customer> getArrayRecord() {
        String queryStr = "SELECT * FROM " + tableName;
        ArrayList<Customer> cusList = new ArrayList<Customer>();
        Customer customerList = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                customerList = new Customer(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6).charAt(0),rs.getString(7));
                cusList.add(customerList);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return cusList;
    }

    public Customer retrieveRecord(String string) {
        String queryStr = "SELECT * FROM "+ tableName +" WHERE CUSTOMER_ID = ?" ;
           Customer cus1 = null;
                
        try {   
             stmt = conn.prepareStatement(queryStr);
             stmt.setString(1, string);
             ResultSet rs = stmt.executeQuery();
             
             while(rs.next()){         
                cus1 = new Customer(rs.getString(1), rs.getString(2), rs.getString(3),  rs.getString(4), rs.getString(5),rs.getString(6).charAt(0),rs.getString(7));
                                   
             }
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
             return cus1;}
    
    public Customer retrieveRecordIC(String string) {
        String queryStr = "SELECT * FROM "+ tableName +" WHERE CUSTOMER_IC = ?" ;
           Customer cus1 = null;
                
        try {   
             stmt = conn.prepareStatement(queryStr);
             stmt.setString(1, string);
             rs = stmt.executeQuery();
             
             while(rs.next()){         
                cus1 = new Customer(rs.getString(1), rs.getString(2), rs.getString(3),  rs.getString(4), rs.getString(5),rs.getString(6).charAt(0),rs.getString(7));
                                   
             }
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
             return cus1;
    }
    
    public static void main(String[] args){
        CustomerDA da = new CustomerDA();
        
        
        System.out.println(da.retrieveRecord("C0001").getCustomerGender());
    }

    public Customer retrieveRecordFromIC() {
       String queryStr = "SELECT * FROM "+ tableName ;
           Customer cus1 = null;
                
        try {   
             stmt = conn.prepareStatement(queryStr);
             rs = stmt.executeQuery();
             
             while(rs.next()){         
                cus1 = new Customer(rs.getString(1), rs.getString(2), rs.getString(3),  rs.getString(4), rs.getString(5),rs.getString(6).charAt(0),rs.getString(7));                              
             }
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
             return cus1;
    }
    
}

