/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo;

import java.awt.BorderLayout;
import javax.swing.JFrame;
/**
 *
 * @author crist
 */
public class Zoo extends JFrame{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new MPrincipal();
        JFrame zoo=new JFrame();
        zoo.getContentPane().add(zoo,BorderLayout.CENTER);
        zoo.setSize(500, 500);
        zoo.setVisible(true);
        zoo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
