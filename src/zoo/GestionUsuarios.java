package zoo;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GestionUsuarios extends JPanel{
	
	JTable usuarios = null;
	
	GestionUsuarios(){

		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Login");
		modelo.addColumn("Password");
		modelo.addColumn("Edad");
		modelo.addColumn("Rol");
		
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
