/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.Date;

/**
 *
 * @author caveon
 */
public class SalesOrder {
    String Sales_OrderID;
    String RestID;
    String CustID;
    String DeliverAddress;
    Double Distance;
    Date   SalesOrder_Cdate;
    String Sales_OrderStatus;

    public String getSales_OrderID() {
        return Sales_OrderID;
    }

    public void setSales_OrderID(String Sales_OrderID) {
        this.Sales_OrderID = Sales_OrderID;
    }

    public String getRestID() {
        return RestID;
    }

    public void setRestID(String RestID) {
        this.RestID = RestID;
    }

    public String getCustID() {
        return CustID;
    }

    public void setCustID(String CustID) {
        this.CustID = CustID;
    }

    public String getDeliverAddress() {
        return DeliverAddress;
    }

    public void setDeliverAddress(String DeliverAddress) {
        this.DeliverAddress = DeliverAddress;
    }

    public Double getDistance() {
        return Distance;
    }

    public void setDistance(Double Distance) {
        this.Distance = Distance;
    }

    public Date getSalesOrder_Cdate() {
        return SalesOrder_Cdate;
    }

    public void setSalesOrder_Cdate(Date SalesOrder_Cdate) {
        this.SalesOrder_Cdate = SalesOrder_Cdate;
    }

    public String getSales_OrderStatus() {
        return Sales_OrderStatus;
    }

    public void setSales_OrderStatus(String Sales_OrderStatus) {
        this.Sales_OrderStatus = Sales_OrderStatus;
    }
}
