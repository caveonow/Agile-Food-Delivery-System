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
public interface CustomerInterface<T> {
      
    public boolean addCustomer(T question, T a, T b, T c, T d, T answer, T questType);
    public ArrayList getAllCustomer();
    public ArrayList getCust(T custID);
    public boolean updateCustomer(T question, T a, T b, T c, T d, T answer, T questType);
}
