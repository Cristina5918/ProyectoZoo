/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo;

//import java.awt.BorderLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author crist
 */
public class Zoo extends JFrame {
    
    private Login login;
    private MPrincipal menuprincipal;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Zoo();
    }
    Zoo(){
        
        JFrame zoo=new JFrame("BIENVENIDO");
        zoo.setSize(800,600);
        /*login = new Login();
        zoo.add(login);*/
        //dejamos eso ahi parado que ya sabemos que funciona, hacemos atajo al menu principal
        menuprincipal = new MPrincipal();
        zoo.add(menuprincipal);
        
        zoo.setResizable(true);
        zoo.setVisible(true);
        //login.setLayout(new FlowLayout(FlowLayout.CENTER,10,50) );
        menuprincipal.setLayout(new FlowLayout(FlowLayout.CENTER,10,50) );
        zoo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    } 
    
}
