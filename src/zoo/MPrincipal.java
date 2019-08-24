/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;



/**
 *
 * @author crist
 */
public class MPrincipal extends JPanel {
	//campos de la clase
	private static final long serialVersionUID = 1L;
        private Animal animal;
		
	/**
	 * Constructor para la clase MenuPrincipal
	*/
	MPrincipal(){
            animal= new Animal();
            
            JPanel ventana=new JPanel();
            JLabel user=new JLabel("Usuarios");
            user.setBounds(80,90,80,50);
            ventana.add(user);
            JButton u1=new JButton("Añadir usuario");
            u1.setBounds(100, 100, 100, 40);
            ventana.add(u1);
            ActionListener al=new ActionListener(){
                public void actionPerformed(ActionEvent arg0){
                    añadirUsuario();
                }
            }
            /**u1.addActionListener(new ActionListener() {	    	
		public void actionPerformed(ActionEvent arg0) {
                    añadirUsuario();			
		}
                private void añadirUsuario() {
                    throw new UnsupportedOperationException("Not supported yet."); 
                }
            });	*/
            
            JButton u2=new JButton("Borrar usuario");
            u2.setBounds(200,200,100,40);
            ventana.add(u2);
            u2.addActionListener(new ActionListener() {	    	
		public void actionPerformed(ActionEvent arg0) {
                    borrarUsuario();			
		}

                private void borrarUsuario() {
                    throw new UnsupportedOperationException("Not supported yet."); 
                }
            });		
            JButton u3=new JButton("Modificar usuario");
            u3.setBounds(300,300,100,40);
            ventana.add(u3);
            u3.addActionListener(new ActionListener() {	    	
		public void actionPerformed(ActionEvent arg0) {
                    modificarUsuario();			
		}
                 private void modificarUsuario() {
                    throw new UnsupportedOperationException("Not supported yet."); 
                }
            });
            
            JLabel animal=new JLabel("Animales");
            animal.setBounds(80,90,80,50);
            ventana.add(animal);
            
            JButton a1=new JButton("Añadir animal");
            ventana.add(a1);
            a1.setBounds(200,200,100,40);
            ventana.add(a1);
            a1.addActionListener(new ActionListener() {	    	
		public void actionPerformed(ActionEvent arg0) {
                    añadirAnimal();			
                }
                 private void añadirAnimal() {
                    throw new UnsupportedOperationException("Not supported yet."); 
                }
            });		
            JButton a2=new JButton("Borrar animal");
            ventana.add(a2);
            a2.setBounds(200,200,100,40);
            ventana.add(a2);
            a2.addActionListener(new ActionListener() {	    	
		public void actionPerformed(ActionEvent arg0) {
                    borrarAnimal();
                }
                 private void borrarAnimal() {
                    throw new UnsupportedOperationException("Not supported yet."); 
                }
            });	
            JButton a3=new JButton("Modificar animal");
            ventana.add(a3);
            a3.setBounds(200,200,100,40);
            ventana.add(u2);
            a3.addActionListener(new ActionListener() {	    	
		public void actionPerformed(ActionEvent arg0) {
                    modificarAnimal();			
                }
                 private void modificarAnimal() {
                    throw new UnsupportedOperationException("Not supported yet."); 
                }
            });		
            JButton a4=new JButton("Ver todos los animales");
            ventana.add(a4);
            a4.setBounds(200,200,100,40);
            ventana.add(u2);
            a4.addActionListener(new ActionListener() {	    	
		public void actionPerformed(ActionEvent arg0) {
                    verAnimal();			
                }
                 private void verAnimal() {
                    throw new UnsupportedOperationException("Not supported yet."); 
                }
            });
           
           
            
           
            
            
           	
           
            		
              
            ventana.setSize(400,400);  
            ventana.setVisible(true);
        
            add(ventana);
        
        }
        
}
    

