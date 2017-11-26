/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Caveon
 */
public class CustomerMainMenu extends JFrame{

    public static CustomerMainMenu maintainPage;
    private CustomerOrderMenu cutomerorder;
    
    private JPanel p1,p2,p3,p4,p5,p6,buttonSet,combination,b1,b2,b3,b4,b5,b6,home;
    
    private JButton jbtHome = new JButton("Home");
    private JButton jbtCustomerOrder = new JButton("Customer Order");
    private JButton jbtCustomerHistory = new JButton("Order History");
    private JButton jbtCustomerProfile = new JButton("Customer Profile");
    private int panel = 1;
    
    public CustomerMainMenu(){
        cutomerorder = new CustomerOrderMenu();
        
        jbtCustomerOrder.setForeground(Color.red);
        buttonSet = new JPanel(new GridLayout(7,1));
        home = new JPanel();
        home.setBackground(Color.DARK_GRAY);
        b1 = new JPanel();
        b1.setBackground(Color.DARK_GRAY);
        b2 = new JPanel();
        b2.setBackground(Color.DARK_GRAY);
        b3 = new JPanel();
        b3.setBackground(Color.DARK_GRAY);

        combination = new JPanel(new BorderLayout());
        
        jbtHome.setPreferredSize(new Dimension(200, 40));
        jbtCustomerOrder.setPreferredSize(new Dimension(200, 40));
        jbtCustomerHistory.setPreferredSize(new Dimension(200, 40));
        jbtCustomerProfile.setPreferredSize(new Dimension(200, 40));

        
        home.add(jbtHome);
        b1.add(jbtCustomerOrder);
        b2.add(jbtCustomerHistory);
        b3.add(jbtCustomerProfile);
        
        buttonSet.add(home);
        buttonSet.add(b1);
        buttonSet.add(b2);
        buttonSet.add(b3);
        
        p1 = new JPanel();
        p1.add(new CustomerOrderMenu());
        p2 = new JPanel();
        p3 = new JPanel();
        
        
        combination = new JPanel(new BorderLayout());
        combination.add(buttonSet ,BorderLayout.WEST);
        combination.add(p1 ,BorderLayout.CENTER);
        setContentPane(combination);
        
        jbtCustomerOrder.addActionListener(new listener());
        jbtCustomerHistory.addActionListener(new listener());
        jbtCustomerProfile.addActionListener(new listener());
        jbtHome.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new MainMenu().setSize(400, 375);
                setVisible(false);
            }
        });
        setTitle("Customer Order Menu");
        setSize(400, 375);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private class listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            remove(p1);
            remove(p2);
            remove(p3);
            
            jbtCustomerOrder.setForeground(Color.black);
            jbtCustomerHistory.setForeground(Color.black);
            jbtCustomerProfile.setForeground(Color.black);   
            
            if(e.getSource() == jbtCustomerOrder) { 
                jbtCustomerOrder.setForeground(Color.red);
                buttonSet.setSize(800, 75);
                getContentPane().add(p1,BorderLayout.CENTER);
                panel = 1; 
            }
            
            else if(e.getSource() == jbtCustomerHistory) {
                p2.add(new CustomerOrderHistory());
                jbtCustomerHistory.setForeground(Color.red);
                buttonSet.setSize(800, 75);
                getContentPane().add(p2,BorderLayout.CENTER);
                panel = 2;
            }
            
            else if(e.getSource() == jbtCustomerProfile) {
                p3.add(new CustomerProfileMenu());
                jbtCustomerProfile.setForeground(Color.red);
                buttonSet.setSize(800, 75);
                getContentPane().add(p3,BorderLayout.CENTER);
                panel = 3;
            }
            validate();
            repaint();
        }     
    }
    public static void main(String[] args) {
        maintainPage = new CustomerMainMenu();
        maintainPage.setSize(1000, 375);
    }
    
}
