/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author caveon
 */
public interface PaymentInterface<T>{
      public boolean addPayment(T PaymentID, T SalesOrderID, T PaymentType, T TotalPayment, T PaymentDate);
}
