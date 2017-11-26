/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author caveon
 */
public class Customer<T> implements CustomerInterface<T> {
    
    private String host = "jdbc:derby://localhost:1527/FoodDeliverySystem";
    private String user = "FDSYS";
    private String password = "FDSYS";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public Customer(){
        createConnection();
    }
 
    public boolean addCustomer(T custID, T custName, T custICNo, T custAddress, T custPhoneNo, T custEmail, T custStatus){
        String Str = "INSERT INTO Customer (CUSTOMERID, CUSTOMERNAME, CUSTOMERICNO, CUSTOMERADDRESS, CUSTOMERPHONENO, CUSTOMEREMAIL, CUSTOMERSTATUS) VALUES (?,?,?,?,?,?,?)";
        int temp = 0;
        try{
            stmt = conn.prepareStatement(Str,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, String.valueOf(custID));
            stmt.setString(2, String.valueOf(custName));
            stmt.setString(3, String.valueOf(custICNo));
            stmt.setString(4, String.valueOf(custAddress));
            stmt.setString(5, String.valueOf(custPhoneNo));
            stmt.setString(6, String.valueOf(custEmail));
            stmt.setString(7, String.valueOf(custStatus));
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
    
    public ArrayList getAllCustomer() {
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
    
     public ArrayList getCust(T custID){
        String Str = "SELECT * from customer where customerid = ? ";
        ArrayList array = new ArrayList();
        try {
            
            stmt = conn.prepareStatement(Str);
            stmt.setString(1, String.valueOf(custID));  
            rs = stmt.executeQuery();
           
            while (rs.next()) {            
/*                T newT1 = (T)(Object)rs.getString(2);
                T newT2 = (T)(Object)rs.getString(3);
                T newT3 = (T)(Object)rs.getString(4);
                T newT4 = (T)(Object)rs.getString(5);
                T newT5 = (T)(Object)rs.getString(6);*/
                array.add(rs.getString(2));
                array.add(rs.getString(3));
                array.add(rs.getString(4));
                array.add(rs.getString(5));
                array.add(rs.getString(6));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        return array;
    }  
     
     public boolean updateCustomer(T custID, T custName, T custICNo, T custAddress, T custPhoneNo, T custEmail, T custStatus){
        String Str = "Update Customer SET CUSTOMERNAME = ? , CUSTOMERICNO = ? , CUSTOMERADDRESS = ?, CUSTOMERPHONENO = ?, CUSTOMEREMAIL = ?, CUSTOMERSTATUS = ? WHERE CUSTOMERID = ?";
        
        int temp = 0;
        try{
            PreparedStatement ps = conn.prepareStatement(Str,Statement.RETURN_GENERATED_KEYS);            
            ps.setString(1, String.valueOf(custName));
            ps.setString(2, String.valueOf(custICNo));
            ps.setString(3, String.valueOf(custAddress));
            ps.setString(4, String.valueOf(custPhoneNo));
            ps.setString(5, String.valueOf(custEmail));
            ps.setString(6, String.valueOf(custStatus));
            ps.setString(7, String.valueOf(custID));
            ps.executeUpdate();
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
}
