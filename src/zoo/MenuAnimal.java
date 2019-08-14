
package zoo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author crist
 */
/**La clase de MenuAnimal nos permite saber sobre los animales del zoo*/
public class MenuAnimal extends JPanel implements FormaAnimal{
    private final long serialVersionUID=1;
    private JButton bLimpia=null;
    private JButton bCome=null;
    private JButton bAñadir=null;
    private JTable Animal=null;
    DefaultTableModel tabla=null;
    
    Connection con =null;
    PreparedStatement pstm =null;
    ResultSet rs=null;
    /**Constructor*/
    MenuAnimal(){
        tabla= new DefaultTableModel();
        tabla.addColumn("Nombre");
        tabla.addColumn("Patas");
        tabla.addColumn("Ojos");
        tabla.addColumn("Peligrosidad");
        
        Animal=new JTable(tabla);
        
        //añadimos la barra deslizadora a nuestro panel de animal para que todos los animales sean visibles
        JScrollPane deslizador=new JScrollPane(Animal);
        deslizador.setVisible(true);
        add(deslizador);
        
        //Boton añadir animal
        bAñadir=new JButton("Añadir animal");
        bAñadir.setToolTipText("Añade un nuevo animal");
        bAñadir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                FormaAnimal fa=new FormaAnimal() {
                    public void setLocation(int i, int i0) {
                        throw new UnsupportedOperationException("Not supported yet.");
                    }
                    public void setVisible(boolean b) {
                        throw new UnsupportedOperationException("Not supported yet.");
                    }
                };
                fa.setLocation(140,140);
                fa.setVisible(true);
            }
        });
        bCome=new JButton("Dar de comer");
        bCome.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                int dar=0;
                dar++;
                System.out.println("Ha comido " + dar + "veces");
                
            }
        });
        
        bLimpia=new JButton("Limpiar animal");
        bLimpia.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int veces=0;
                veces++;
                System.out.println("Se ha limpiado " + veces + "veces"); 
            }
        });
    }  
    
    /**Rellenamos la tabla con todos los animales que tengamos en nuestra base de datos*/
         public void Rellena(){
            try{
                String Driver = "com.mysql.cj.jdbc.Driver";
                String URL = "jdbc:mysql://localhost:3306/ZOO?ussesSSL=false&serverTimezone=UTC";			
			
                Class.forName(Driver); 
                con = DriverManager.getConnection(URL,"root","root");
					
                String sql= "SELECT* FROM ANIMAL";
                
                //preparamos sentencia
                pstm=con.prepareStatement(sql);
                //ejecutamos la sentencia
                rs=pstm.executeQuery();
			
                while(rs.next()) {
                   Object objetos[]=new Object[3];
                   objetos[0]=(rs.getString(1)); //NOMBRE	
                   objetos[1]=(rs.getString(2)); //PATAS
    		   objetos[2]=(rs.getString(3)); //OJOS	
                   objetos[3]=(rs.getString(4)); //PELIGROSIDAD
       		  
		   tabla.addRow(objetos);
		   objetos=null;
		}
            }catch(SQLException e){
        	e.printStackTrace();			
		throw new RuntimeException(e);		
            } catch (ClassNotFoundException e) {
		e.printStackTrace();
            }
            finally{
		try {
                    if(pstm !=null) pstm.close();
                    if(con!=null) con.close();
		}catch(Exception e){
                    throw new RuntimeException(e);
		}
            }
	
        }
         /**Nos permite actualizar nuestra tabla de animales tanto si eliminamos como si añadimos un nuevo animal en nuestra base de datos*/
        public void Actualiza() {
		tabla.setRowCount(0);//se vacia el modelo		
		Rellena();//se rellena otra vez	
			
	}
            
}

