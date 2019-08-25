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
import javax.swing.JTabbedPane;



/**
 *
 * @author crist
 */
public class MPrincipal extends JPanel {
	//campos de la clase
	private static final long serialVersionUID = 1L;
		
	GestionUsuarios gestionUsuarios=null;
	
	/**
	 * Constructor para la clase MenuPrincipal
	*/
	MPrincipal(){

		//creamos la estructura de pestañas que contendra las pestañas
		JTabbedPane tabs = new JTabbedPane();
		
		JPanel usuarios = new JPanel();		
		usuarios.setLayout(null);
		
		gestionUsuarios = new GestionUsuarios();
		gestionUsuarios.setLocation(0,0);
		gestionUsuarios.setSize(500,500);
	
		usuarios.add(gestionUsuarios,BorderLayout.WEST);
		tabs.addTab("Usuarios", usuarios);

        
    }
        
}
    

