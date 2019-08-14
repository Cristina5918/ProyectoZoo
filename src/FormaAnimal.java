import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import zoo.Animal;

/**la clase FormCliente nos permite asignar datos a un nuevo cliente*/
public class FormaAnimal extends JFrame {	
    private static final long serialVersionUID = 1L;
    //FORMAMOS LAS ETIQUETAS
    JLabel eNombre=null; 
    JLabel eOjos=null;
    JLabel ePatas=null;
    JLabel ePeligrosidad=null;
	
    JTextField tNombre=null;
    JTextField tOjos=null;
    JTextField tPatas=null;
    JTextField tPeligrosidad=null;
    
	
    JButton bComer=null;
    JButton bLimpiar=null;
    JButton bAñadir=null;
    Animal a=null;
	

	/**Constructor*/
	FormaAnimal(){
            setLayout(new FlowLayout());	
            this.setResizable(false); 
		//hola
            eNombre=new JLabel("Nombre");
            tNombre=new JTextField(20);
		
            eOjos=new JLabel("Ojos");
            tOjos=new JTextField(2);
		
            ePatas=new JLabel("Patas");
            tPatas=new JTextField(2);
		
            ePeligrosidad=new JLabel("Nivel en porcentaje de peligrosidad");
            tPeligrosidad=new JTextField(3);
            
            bComer=new JButton("Comer");
            bLimpiar=new JButton("Limpiar");
            bAñadir=new JButton("Añadir animal");
		

            getContentPane().add(eNombre);
            getContentPane().add(tNombre);
	
            getContentPane().add(eOjos);
            getContentPane().add(tOjos);
		
            getContentPane().add(ePatas);
            getContentPane().add(tPatas);
		 
            getContentPane().add(ePeligrosidad);
            getContentPane().add(tPeligrosidad);
		 
            getContentPane().add(bComer);
            getContentPane().add(bLimpiar);
            getContentPane().add(bAñadir);
            
            this.setSize(250,400);
            this.setTitle("Animal");		
		
            bAñadir.addActionListener(new ActionListener() {			
		public void actionPerformed(ActionEvent e) {
	
                    String nombre=tNombre.getText();//nombre animal
                    String ojos=tOjos.getText();//ojos del animal
                    String patas=tPatas.getText();//patas del animal
                    String peligrosidad=tPeligrosidad.getText();//nivel de peligrosidad
                    
                    if( nombre.length()<=20) {
			JOptionPane.showMessageDialog(null, "El campo nombre tiene que ser rellenado "
                                + "y no puede tener mas de 20 letras","Error",JOptionPane.ERROR_MESSAGE);
			System.out.print(nombre);					
                    }				
                    if(ojos.length()<2){
    			JOptionPane.showMessageDialog(null, "El campo ojos  es incorrecto","Error",
                                JOptionPane.ERROR_MESSAGE);
                        System.out.print(ojos);
                    }
                    if(patas.equals("")==true) {
			JOptionPane.showMessageDialog(null, "El campo patas ha de ser rellenado","Error",
                                JOptionPane.ERROR_MESSAGE);
                        System.out.print(patas);
                    }
                    if(peligrosidad.length()!=3) {
			JOptionPane.showMessageDialog(null, "La peligrosidad no puede pasar de 100",
                                "Error",JOptionPane.ERROR_MESSAGE);
                        System.out.print(peligrosidad);
                    }
                }
                });
                    }
}
