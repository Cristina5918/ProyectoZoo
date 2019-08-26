package zoo;

import java.awt.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GestionUsuarios extends JPanel{
	
	JTable usuarios = null;
	
	GestionUsuarios(){
		setLayout(new BorderLayout());
		JButton borraButton = new JButton("Borrar usuario");
		JButton addButton = new JButton("Aniadir usuario");
		JButton editButton = new JButton("Editar usuario");
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

		usuarios = new JTable(modelo);
		
		JScrollPane barra=new JScrollPane(usuarios);
	    barra.setVisible(true);
	    barra.setMaximumSize(new Dimension(500,300));
	    add(barra, BorderLayout.CENTER);

	    JPanel contenedorBotonera = new JPanel(new GridLayout(1,3,30,30));
	    contenedorBotonera.setSize(500,100);
	    contenedorBotonera.setMaximumSize(new Dimension(500,100));
	    JLabel vacio = new JLabel();
		JLabel vacio2 = new JLabel();

	    contenedorBotonera.add(addButton);
		contenedorBotonera.add(editButton);
	    contenedorBotonera.add(borraButton);


	    add(contenedorBotonera, BorderLayout.SOUTH);

		
	}
	
	
	private List<Usuario> getAllUsers(){
		List<Usuario> returnList = null;
		BaseDatos bbdd = new BaseDatos();
		returnList = bbdd.getAllUsers();
		return returnList;
	}
	
}
