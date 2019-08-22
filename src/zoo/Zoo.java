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
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Zoo();
    }
    Zoo(){
        
        JFrame zoo=new JFrame("BIENVENIDO");
        //JPanel principal=new JPanel();
        JPanel login=new JPanel();
        
        JLabel user=new JLabel("USUARIO");
        user.setBounds(20,20, 80,30);
        JTextField usuario=new JTextField(20);
        
        
        JLabel password=new JLabel("CONTRASEÑA");
        password.setBounds(20,20, 80,30);
        JPasswordField pass=new JPasswordField(20);
        
        JButton acceder=new JButton("ACCEDER");
        acceder.setBounds(50,50,50,50);
        
       // zoo.setContentPane(principal);
        zoo.add(login);
        
        login.add(user);
        login.add(usuario);
        login.add(password);
        login.add(pass);
        login.add(acceder);
       
        //principal.setSize(800,800);
        login.setSize(500,500);
        zoo.setSize(400,500);
        zoo.setResizable(true);
        zoo.setVisible(true);
        login.setLayout(new FlowLayout(FlowLayout.CENTER,10,50) );
        zoo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void acceder(ActionEvent evt){
        String usuario="root";
        String contraseña="root";
            
        if(usuario.equals("root")&&(contraseña.equals("root"))){
            System.out.println("BIENVENIDO USUARIO");
            ventana vt=new ventana();
            vt.setVisible(true);
            this.dispose();
        }
        else if((usuario.equals(""))&&(contraseña.equals(""))){
            JOptionPane.showInputDialog(this, "Usuario y contraseña vacíos, por favor rellene los campos",
                    "Error!!",JOptionPane.ERROR_MESSAGE);
            
        }
        else if((usuario.equals(""))){
            JOptionPane.showMessageDialog(this, "Usuario vacio","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if((usuario.equals("root")&&(contraseña.equals("")))){
            JOptionPane.showMessageDialog(this,"Contraseña vacia","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if((usuario.compareTo(usuario)!=0)&&(contraseña.compareTo(contraseña)!=0)){
            JOptionPane.showMessageDialog(this,"Usuario y contraseña invalidos, intentelo de nuevo","Error",JOptionPane.ERROR_MESSAGE);
        }             
        else if(usuario.compareTo(usuario)!=0){
            JOptionPane.showMessageDialog(this,"Usuario incorrecto, intentelo de nuevo","Error",JOptionPane.ERROR_MESSAGE);   
        }
        else if(contraseña.compareTo(contraseña)!=0){
            JOptionPane.showMessageDialog(this, "Contraseña incorrecta","Error",JOptionPane.ERROR_MESSAGE);
        }
    }  
    
}
