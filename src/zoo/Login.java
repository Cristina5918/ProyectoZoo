/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author crist
 */
public class Login{
    private Component confirmacion;
    private String usuario;
  //  private String usuario1;
    private String password;
   // private String contraseña1;
    
    // la ñ no mola nada
    
    public JPanel createLogin(JPanel entrar){
        
        
        JTextField campo=new JTextField();
        campo.setBounds(new Rectangle(0, 100, 100, 50));
        JPasswordField pass=new JPasswordField();
        pass.setBounds(new Rectangle(0,150,100,50));
        
        JLabel u=new JLabel("USUARIO");
        u.setBounds(new Rectangle(100,300,100,50)); //esto no se que hace
        JLabel c=new JLabel("CONTRASEÑA");
        c.setBounds(new Rectangle(0,200,100,50));
        entrar.add(u); //no llames u a lo loco, llamalo como usuarioText o algo asi, para que quede claro
        /*entrar.add(campo);
        entrar.add(c); // igual aqui
        entrar.add(pass);*/
        
        entrar.setBounds(new Rectangle(0,0,800,600));
        
        return entrar;
    }
    
}

