/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo;

import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author crist
 */
public class Login extends JFrame{
    private Component confirmacion;
    private String usuario;
    private String usuario1;
    private String contraseña;
    private String contraseña1;
    
    
    public Login(){
        //initComponents();
        setLocationRelativeTo(null);
       // txtUsuario.setFocusable(true);
    }

    public void datos(String usuario, String contraseña){
        usuario="root";
        contraseña="root";
    }
    public void datos1(String usuario1, String contraseña1){
        usuario1="Diego";
        contraseña1="1234";
    }
    private void bCancelarActionPerformed(ActionEvent evt){
        Object[]opciones={"Aceptar","Cancelar"};
        int eleccion=JOptionPane.showOptionDialog(confirmacion,"¿Desea salir?","Confirmacion",JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
        if(eleccion==JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
    
    private void bIniciarActionPerformed(ActionEvent evt){
       
        datos(usuario, contraseña);
            
        if(usuario.equals("root")&&(contraseña.equals("root"))){
            System.out.println("BIENVENIDO ADMINISTRADOR");
            ventana vt=new ventana();
            vt.setVisible(true);
            this.dispose();
        }
        else if((usuario.equals(""))&&(contraseña.equals(""))){
            JOptionPane.showMessageDialog(this, "Usuario y contraseña vacíos, por favor rellene los campos");
            //txtUsuario.setFocusable(true);
        }
        else if((usuario.equals(""))){
            JOptionPane.showMessageDialog(this, "Usuario vacio");
        }
        else if((usuario.equals("root")&&(contraseña.equals("")))){
            JOptionPane.showMessageDialog(this,"Contraseña vacia");
        }
        else if((usuario.compareTo(usuario)!=0)&&(contraseña.compareTo(contraseña)!=0)){
            JOptionPane.showMessageDialog(this,"Usuario y contraseña invalidos, intentelo de nuevo");
        }             
        else if(usuario.compareTo(usuario)!=0){
            JOptionPane.showMessageDialog(this,"Usuario incorrecto, intentelo de nuevo");   
        }
        else if(contraseña.compareTo(contraseña)!=0){
            JOptionPane.showMessageDialog(this, "Contraseña incorrecta");
        }
        
        
        
        datos1(usuario1, contraseña1);
            
        if(usuario.equals("Diego")&&(contraseña.equals("1234"))){
            System.out.println("BIENVENIDO DIEGO");
            ventana vt=new ventana();
            vt.setVisible(true);
            this.dispose();
        }
        else if((usuario1.equals(""))&&(contraseña1.equals(""))){
            JOptionPane.showMessageDialog(this, "Usuario y contraseña vacíos, por favor rellene los campos");
            //txtUsuario.setFocusable(true);
        }
        else if((usuario1.equals(""))){
            JOptionPane.showMessageDialog(this, "Usuario vacio");
        }
        else if((contraseña1.equals(""))){
            JOptionPane.showMessageDialog(this,"Contraseña vacia");
        }
        else if((usuario1.compareTo(usuario)!=0)&&(contraseña1.compareTo(contraseña)!=0)){
            JOptionPane.showMessageDialog(this,"Usuario y contraseña invalidos, intentelo de nuevo");
        }             
        else if(usuario1.compareTo(usuario)!=0){
            JOptionPane.showMessageDialog(this,"Usuario incorrecto, intentelo de nuevo");
            
        }
        else if(contraseña1.compareTo(contraseña)!=0){
            JOptionPane.showMessageDialog(this, "Contraseña incorrecta");
        }
        
        
    }

    
    
}
