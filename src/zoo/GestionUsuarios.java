package zoo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GestionUsuarios extends JPanel{
	
	JTable usuarios = null;
	DefaultTableModel modelo = null;
	
	GestionUsuarios(){
		setLayout(new BorderLayout());
		JButton borraButton = new JButton("Borrar usuario");
		JButton addButton = new JButton("Aniadir usuario");
		JButton editButton = new JButton("Editar usuario");
		modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Login");
		modelo.addColumn("Password");
		modelo.addColumn("Edad");
		modelo.addColumn("Rol");

		rellenaFilas();

		usuarios = new JTable(modelo);
		
		JScrollPane barra=new JScrollPane(usuarios);
	    barra.setVisible(true);
	    barra.setMaximumSize(new Dimension(500,300));
	    add(barra, BorderLayout.CENTER);

	    JPanel contenedorBotonera = new JPanel(new GridLayout(1,3,30,30));
	    contenedorBotonera.setSize(500,100);
	    contenedorBotonera.setMaximumSize(new Dimension(500,100));


	    addButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				addUser();
			}
		});

		editButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				editUser();
			}
		});

		borraButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				deleteUser();
			}
		});

	    contenedorBotonera.add(addButton);
		contenedorBotonera.add(editButton);
	    contenedorBotonera.add(borraButton);


	    add(contenedorBotonera, BorderLayout.SOUTH);

		
	}

	private void rellenaFilas() {
		vaciaTodoMenosPrimeraFila();
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
	}

	private void vaciaTodoMenosPrimeraFila() {
		modelo.setRowCount(0);
	}

	private void editUser() {
	}

	private void addUser() {
		ImageIcon icon = new ImageIcon("src/images/add.png");

		JPanel panel = new JPanel(new GridLayout(5,2));

		JLabel labelNombre = new JLabel("Nombre");
		JLabel labelApellidos = new JLabel("Apellidos");
		JLabel labelEdad = new JLabel("Edad");
		JLabel labelLogin = new JLabel("Login");
		JLabel labelPassword = new JLabel("Password");

		JTextField inputNombre = new JTextField();
		JTextField inputApellidos = new JTextField();
		JTextField inputEdad = new JTextField();
		JTextField inputLogin = new JTextField();
		JTextField inputPassword = new JTextField();

		panel.add(labelNombre);
		panel.add(inputNombre);

		panel.add(labelApellidos);
		panel.add(inputApellidos);

		panel.add(labelEdad);
		panel.add(inputEdad);

		panel.add(labelLogin);
		panel.add(inputLogin);

		panel.add(labelPassword);
		panel.add(inputPassword);

		UIManager.put("OptionPane.minimumSize",new Dimension(300, 120));
		int input = JOptionPane.showOptionDialog(null, panel, "Aniadir usuario", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, null, null);
		if(input == JOptionPane.OK_OPTION){
			String nombre = inputNombre.getText();
			String apellidos = inputApellidos.getText();
			String edad = inputEdad.getText();
			boolean edadEsNumero = false;
			String login = inputLogin.getText();
			String password = inputPassword.getText();
			try{
				Integer.parseInt(edad);
				edadEsNumero = true;
			}catch(NumberFormatException e){
				edadEsNumero = false;
			}
			if(nombre==null || nombre.equals("")){
				JOptionPane.showMessageDialog(null, "Introduzca un nombre", "Error", JOptionPane.ERROR_MESSAGE);
			}else if(apellidos==null || apellidos.equals("")){
				JOptionPane.showMessageDialog(null, "Introduzca un apellido", "Error", JOptionPane.ERROR_MESSAGE);
			}else if(edad==null || edad.equals("") || !edadEsNumero){
				JOptionPane.showMessageDialog(null, "Introduzca una edad", "Error", JOptionPane.ERROR_MESSAGE);
			}else if(login==null || login.equals("")){
				JOptionPane.showMessageDialog(null, "Introduzca un login", "Error", JOptionPane.ERROR_MESSAGE);
			}else if(password==null || password.equals("")){
				JOptionPane.showMessageDialog(null, "Introduzca un password", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				BaseDatos bbdd = new BaseDatos();
				Usuario u = new Usuario();
				u.setNombre(nombre);
				u.setApellido(apellidos);
				u.setEdad(Integer.parseInt(edad));
				u.setLogin(login);
				u.setPassword(password);
				if(bbdd.addUsusario(u)){
					rellenaFilas();
					JOptionPane.showMessageDialog(null, "Usuario aniadido correctamente");
				}else{
					JOptionPane.showMessageDialog(null, "Ha sido imposible aniadir el usuario", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}


	public void deleteUser(){
		String input = JOptionPane.showInputDialog("Inserta el login del usuario a borrar");
		if(input!=null && !input.equals("")) {
			BaseDatos bbdd = new BaseDatos();
			if (bbdd.deleteUsuario(input)) {
				JOptionPane.showMessageDialog(null, "Usuario borrado correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "Ha sido imposible borrar el usuario con login: "+input, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else{
			JOptionPane.showMessageDialog(null, "Introduce un login para ser borraado", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	private List<Usuario> getAllUsers(){
		List<Usuario> returnList = null;
		BaseDatos bbdd = new BaseDatos();
		returnList = bbdd.getAllUsers();
		return returnList;
	}
	
}
