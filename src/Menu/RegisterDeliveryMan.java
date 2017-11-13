/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author Wayne
 */
public class RegisterDeliveryMan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Delivery Man name:");
        String name = sc.nextLine();
        
        System.out.println("Please Enter Delivery Man IC num:");
        String ic = sc.nextLine();
        System.out.println("Hello"+name+", your ic num is"+ic);
    }
    
}
