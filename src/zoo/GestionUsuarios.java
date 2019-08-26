package zoo;

import java.awt.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GestionUsuarios extends JPanel{
	
	JTable usuarios = null;
	
	GestionUsuarios(){
		setLayout(new GridLayout(2,1,0,0));
		JButton borraButton = new JButton("Borrar usuario");
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Login");
		modelo.addColumn("Password");
		modelo.addColumn("Edad");
		modelo.addColumn("Rol");
                //modelo.addColumn("Acciones");
		
		List<Usuario> usuariosBBDD = getAllUsers();
		if(usuariosBBDD!=null && usuariosBBDD.size()>0) {
			for(Usuario u : usuariosBBDD) {
				Object[] fila = new Object[6];
				fila[0] = u.getNombre();
				fila[1] = u.getApellido();
				fila[2] = u.getLogin();
				fila[3] = u.getPassword();
				fila[4] = u.getEdad();				
				fila[5] = (u.getRol()==true ? "Admin" : "Normal");
				modelo.addRow(fila);
			}
		}

		/*Object[] filaOpciones = new Object[6];
		filaOpciones[0] = "";
		filaOpciones[1] = "";
		filaOpciones[2] = "";
		filaOpciones[3] = "";
		filaOpciones[4] = borraButton;
		filaOpciones[5] = "";
		modelo.addRow(filaOpciones);*/


		usuarios = new JTable(modelo);
		
		JScrollPane barra=new JScrollPane(usuarios);
	    barra.setVisible(true);
	    add(barra);

		
	}
	
	
	private List<Usuario> getAllUsers(){
		List<Usuario> returnList = null;
		BaseDatos bbdd = new BaseDatos();
		returnList = bbdd.getAllUsers();
		return returnList;
	}
	
}
