/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author crist
 */
public class Login extends JPanel{
	JPanel login = null;
    JTextField usuario = null;
    JPasswordField pass=null;

    boolean isAdmin = false;
    
   
    public Login(final JFrame zoo){
        
        //login.setLayout(null);
        
        JLabel user=new JLabel("USUARIO");
        usuario=new JTextField();
        JLabel password=new JLabel("CONTRASENIA");
        pass=new JPasswordField();
        
        JButton acceder=new JButton("ACCEDER");
        
        JLabel error=new JLabel();
        
        
        login=new JPanel(new GridLayout(6,1,50,10));
        
        
        login.add(error);
        login.add(user);
        login.add(usuario);
        login.add(password);
        login.add(pass);
        login.add(acceder);
       
        login.setVisible(true);
        
        add(login);

        zoo.getRootPane().setDefaultButton(acceder);
        
        acceder.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(loguear()){
                    //Para ver si funciona vamos a poner el fondo verde o rojo segun lo encuentre o no
                    //accesoMenuPrincipal();
                    accesoMenuPrincipal(zoo, isAdmin);
                }else{
                    //setBackground(Color.RED);
                    //login.add(error);
                }
            }
        });
    }
    
    public void accesoMenuPrincipal(JFrame zoo, boolean isAdmin) {
        login.setVisible(false);
    	JPanel menuprincipal = new MPrincipal(zoo, isAdmin);
    	zoo.add(menuprincipal,BorderLayout.CENTER);
        menuprincipal.setVisible(true);
    	zoo.setTitle("MENU PRINCIPAL");
    }
    
    public boolean loguear(){
        String usuario = this.usuario.getText();
        String password = new String(this.pass.getPassword());
        
        if(usuario.equals("")||password.equals("")){
            JOptionPane.showMessageDialog(this, "Usuario y/o contraseña vacíos, por favor rellene los campos",
                    "Error!!",JOptionPane.ERROR_MESSAGE); 
        }else if(!usuario.equals("")&&!password.equals("")){
            // Ahora abrimos una conexion con la base de datos para ver 
            BaseDatos bbdd = new BaseDatos();
            //si tenemos el usuario; Primero miramos si existe el usuario
            String sql="SELECT * FROM USUARIO WHERE LOGIN='"+usuario+"'";
            Usuario u = bbdd.executeGetUsuario(sql);
            if(u!=null){
                //Existe el usuario, vamos a ver si coinciden las contraseñas
                //Si existe miramos si coinciden las contraseñas, si no, login erroneo
                if(u.getPassword().equals(password)){
                    if(u.getRol()){
                        isAdmin = true;
                    }
                    return true; 
                }else{
                    JOptionPane.showMessageDialog(this, "La contraseña no coincide",
                    "Error!!",JOptionPane.ERROR_MESSAGE); //esto es dar muchas pistas jeje
                }
            }else{
                //No existe el usuario
                JOptionPane.showMessageDialog(this, "No existe un usuario cone esos datos",
                    "Error!!",JOptionPane.ERROR_MESSAGE);
            }
           
        }else{
            JOptionPane.showMessageDialog(this, "Usuario y/o contraseña vacíos, por favor rellene los campos",
                    "Error!!",JOptionPane.ERROR_MESSAGE);   
        }
        
        return false;
        
        
    }
}

