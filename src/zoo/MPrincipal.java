/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo;

import java.awt.*;
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
import javax.swing.JTabbedPane;



/**
 *
 * @author crist
 */
public class MPrincipal extends JPanel {
	//campos de la clase
	private static final long serialVersionUID = 1L;
		
	GestionUsuarios gestionUsuarios=null;
	GestionAnimales gestionAnimales=null;
	
	/**
	 * Constructor para la clase MenuPrincipal
	*/
	MPrincipal(JFrame zoo, boolean isAdmin){

		JTabbedPane tabs = new JTabbedPane();

		if(isAdmin) {
			JPanel usuarios = new JPanel();
			gestionUsuarios = new GestionUsuarios();
			gestionUsuarios.setLocation(0, 0);
			gestionUsuarios.setVisible(true);
			usuarios.add(gestionUsuarios);
			tabs.addTab("Usuarios", usuarios);
		}
		JPanel animales = new JPanel();
		gestionAnimales = new GestionAnimales();
		gestionAnimales.setLocation(0,0);
		gestionAnimales.setVisible(true);
		animales.add(gestionAnimales);
		tabs.addTab("Animales", animales);
          
		add(tabs);
        
    }
        
}
    

