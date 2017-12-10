/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.ArrayList;

/**
 *
 * @author caveon
 */
public interface SalesOrderInterface<T> {
    public ArrayList getAllSalesOrder();
    public boolean addSalesOrder(T salesOrderID, T RestaurantID, T CustomerID, T deliverry_address, T Distance, T date_Created, T sales_order_status);
    public int getNumberRows();
    public boolean addOrder(T OrderID, T ItemID, T Quantity, T CreatedDate);
}
