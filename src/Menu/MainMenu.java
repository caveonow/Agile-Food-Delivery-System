package Menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * @author caveon
 */
public class MainMenu extends JFrame{

    public static MainMenu dsa;
    
    JButton jbtModuleA = new JButton("Module A");
    JButton jbtModuleB = new JButton("Module B");
    JButton jbtModuleC = new JButton("Customer Order Menu");
    JButton jbtModuleD = new JButton("Module D");
    
    JPanel p1 = new JPanel(new FlowLayout());
    JPanel p2 = new JPanel(new FlowLayout());
    JPanel p3 = new JPanel(new FlowLayout());
    JPanel p4 = new JPanel(new FlowLayout());
    JPanel combination = new JPanel(new BorderLayout());
    
    public MainMenu(){
        
        jbtModuleA.setPreferredSize(new Dimension(300,50));
        jbtModuleB.setPreferredSize(new Dimension(300,50));
        jbtModuleC.setPreferredSize(new Dimension(300,50));
        jbtModuleD.setPreferredSize(new Dimension(300,50));
        
        p1.add(jbtModuleA);
        jbtModuleA.setToolTipText("Module A");

        p2.add(jbtModuleB);
        jbtModuleB.setToolTipText("Module B");
        
        p3.add(jbtModuleC);
        jbtModuleC.setToolTipText("Customer Order Menu");

        p4.add(jbtModuleD);
        jbtModuleD.setToolTipText("Module D");
        
        jbtModuleA.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //new ModuleA().setSize(800, 375);
                setVisible(false);
            }
        });
        jbtModuleB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //new ModuleA().setSize(800, 375);
                setVisible(false);
            }
        });
        jbtModuleC.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new CustomerMenu().setSize(800, 375);
                setVisible(false);
            }
        });
        jbtModuleD.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //new ModuleA().setSize(800, 375);
                setVisible(false);
            }
        });
        
        combination.add(p1);
        combination.add(p2);
        combination.add(p3);
        combination.add(p4);
        combination.setLayout(new GridLayout(4,1));  
        
        setContentPane(combination);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //setSize(800,435);
        pack();
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        dsa = new MainMenu();
        dsa.setSize(400, 375);
    }
}
