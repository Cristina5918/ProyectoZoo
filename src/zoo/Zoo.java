/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo;

//import java.awt.BorderLayout;
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
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author crist
 */
public class Zoo extends JFrame{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame zoo=new JFrame("ZOO");
        
        //JButton comer=new JButton("click");
        //zoo.add(comer);
        
        JMenuBar mb=new JMenuBar();
        JMenu menu=new JMenu("USUARIOS");
        menu.setMnemonic(KeyEvent.VK_U);
        JMenu edit=new JMenu("OPCIONES");
        edit.setMnemonic(KeyEvent.VK_O);
        JMenu ayuda=new JMenu("AYUDA");
        ayuda.setMnemonic(KeyEvent.VK_A);
        JMenu submenu=new JMenu("SUBMENU USUARIOS");
        
        JMenuItem i1=new JMenuItem("añadir");
        JMenuItem i2=new JMenuItem("modificar");
        JMenuItem i3=new JMenuItem("borrar");
        JMenuItem i4=new JMenuItem("ver");
        
       
       
        //PARA ACCEDER USUARIO NORMAL 
        final JLabel label=new JLabel();
        label.setBounds(20,150,200,50);
        final JPasswordField contraseña=new JPasswordField();
        contraseña.setBounds(20,150,200,50);
        JLabel u=new JLabel("Usuario normal");
        u.setBounds(20,100,80,30);
        JLabel c=new JLabel("Contraseña");
        c.setBounds(20,100,80,30);
        JButton enter=new JButton("Entrar");
        final JTextField texto=new JTextField();
        submenu.add(u);
        submenu.add(contraseña);
        submenu.add(c);
        submenu.add(texto);
        submenu.add(enter);
        enter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String data="Usuario normal" + texto.getText();
                data+=", Contraseña: " + new String(contraseña.getPassword());
                label.setText(data);
            }
        });
        //PARA ACCEDER USUARIO ADMINISTRADOR
        final JLabel label1=new JLabel();
        label.setBounds(20,150,200,50);
        final JPasswordField contraseña_=new JPasswordField();
        contraseña.setBounds(20,150,200,50);
        JLabel a=new JLabel("Usuario administrador");
        u.setBounds(20,100,80,30);
        JLabel c_=new JLabel("Contraseña_");
        c.setBounds(20,100,80,30);
         enter=new JButton("Entrar");
        final JTextField texto1=new JTextField();
        submenu.add(a);
        submenu.add(contraseña_);
        submenu.add(c_);
        submenu.add(texto1);
        submenu.add(enter);
        enter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String data="Usuario admnistrador" + texto1.getText();
                data+=", Contraseña: " + new String(contraseña.getPassword());
                label.setText(data);
            }
        });
        //PANTALLA PRINCIPAL
        JTextArea prin=new JTextArea("BIENVENIDOS AL ZOO");
        
        prin.setBounds(200,300,200,200);
        //En la pantalla principal añadimos lugares donde se puede elegir de donde proviene el usuario
        JButton ver=new JButton("VER");
        ver.setBounds(200,100,75,25);
        String pais[]={"España","Inglaterra","Italia","Estados Unidos"};
        final JComboBox cb=new JComboBox(pais);
        cb.setBounds(50,50,90,30);
        zoo.add(cb);
        zoo.add(ver);
        zoo.add(label);
        ver.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String data="Pais seleccionado: " + cb.getItemAt(cb.getSelectedIndex());
            label.setText(data);
            }
        
        });
        
        zoo.add(prin);
        edit.add(i1);
        edit.add(i2);
        edit.add(i3);
        edit.add(i4);
        menu.add(submenu);
        mb.add(edit);
        mb.add(menu);
        mb.add(ayuda);
        zoo.setJMenuBar(mb);
        zoo.setSize(380, 380);
        zoo.setVisible(true);
        zoo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
