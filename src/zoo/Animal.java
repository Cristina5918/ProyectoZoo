
package zoo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author crist
 */
/** la clase Animal nos permite guardar, borrar, modificar y mostrar el animal o animales que haya en nuestra base de datos*/
public class Animal {
    private String nombre;
    private int ojos;
    private int patas;
    private int peligrosidad;
    
    Connection con=null;
    PreparedStatement pstm=null;
    
    /**Constructor de la clase Animal
	 * @param nombre: nombre del animal.
	 * @param ojos: ojos del animal.
	 * @param patas: patas del animal.
	 * @param peligrosidad: peligrosidad del animal.
         */
    Animal(String nombre, int ojos, int patas, int peligrosidad){
        setNombre(nombre);
        setOjos(ojos);
        setPatas(patas);
        setPeligrosidad(peligrosidad);
    }

    Animal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**@param nombre:nombre del animal
     sirve para asignarle el nombre al animal que guardamos en la base de datos*/
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    /**@param ojos: ojos del animal
     * que sirve para identificar cuantos ojos tiene el animal introducido*/
    public void setOjos(int ojos){
        this.ojos=ojos;
    }
    /**@param patas: patas del animal
     * sirve para identificar cuantas patas tiene el animal introducido*/
    public void setPatas(int patas){
        this.patas=patas;
    }
    /**@param peligrosidad: peligrosida del animal 
     * nos indica que grado de peligrosidad tiene el animal introducido*/
     
    public void setPeligrosidad(int peligrosidad){
        this.peligrosidad=peligrosidad;
    }
    /**@return nombre del animal.
	 * podemos saber el nombre del animal*/
    public String getNombre(){
        return nombre;
    }
    /**@return ojos del animal.
     *nos permite conocer informacion sobre los ojos del animal */
    public int getOjos(){
        return ojos;
    }
    /**@return patas del animal.
     * nos permite conocer información sobre cuantas patas tiene dicho animal*/
    public int getPatas(){
        return patas;
    }
    /**@return peligrosidad del animal.
     * nos permite saber cuanto de peligroso puede ser el animal 
     */
    public int getPeligrosidad(){
        return peligrosidad;
    }
    
    //METODO A�aADIR ANIMAL
    /**con este metodo podemos guardar el animal que queramos introducir en nuestro zoo*/
    public void a�aadirAnimal(Animal a)  {
	try {			
            String NCompleto=a.getNombre()+" "+a.getOjos()+" "+a.getPatas()+" "+a.getPeligrosidad();

            String Driver = "com.mysql.cj.jdbc.Driver";
            String URL = "jdbc:mysql://localhost:3306/ZOO?ussesSSL=false&serverTimezone=UTC";			
			
            Class.forName(Driver); 
            con = DriverManager.getConnection(URL,"root","root");
					
            String sql= "INSERT INTO ANIMAL";
            sql+=" VALUES(?,?,?,?,?,?,?)";
            //preparamos conexion
            pstm=con.prepareStatement(sql);
			
            pstm.setString(1, this.getNombre());
            pstm.setInt(2, this.getOjos());
            pstm.setInt(3, this.getPatas());
            pstm.setFloat(4, this.getPeligrosidad());
            
			
            int resultado =pstm.executeUpdate();			
            if (resultado==1) {
                JOptionPane.showMessageDialog(null, "Animal "+NCompleto+" guardado correctamente");
            }
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "YA EXISTE UN ANIMAL CON ESE NOMBRE","Error",JOptionPane.ERROR_MESSAGE);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
                            if(pstm !=null) pstm.close();
                            if(con!=null) con.close();
			}catch(Exception e){
                            throw new RuntimeException(e);
			}
		}
	
	}
    //METODO BORRAR ANIMAL
    /**este metodo nos permite borrar un animal que nosotros deseemos*/
    public void borrarAnimal(Animal a)  {
	try {			

            String Driver = "com.mysql.cj.jdbc.Driver";
            String URL = "jdbc:mysql://localhost:3306/ZOO?ussesSSL=false&serverTimezone=UTC";
            Connection con = null;
            Class.forName(Driver); 
            con = DriverManager.getConnection(URL,"root","root");
            //GUARDAMOS LA CLAVE DEL CLIENTE 
            String clave=this.getNombre();
            String sql= "DELETE FROM ANIMAL";
            sql+=" WHERE NOMBRE=?";
				
            pstm=con.prepareStatement(sql);
            pstm.setString(1, clave);
            int resultado =pstm.executeUpdate();
            //Añadimos un JOptionPane para comunicar que el animal seleccionado se ha borrado correctamente
            if (resultado==1) {
                JOptionPane.showMessageDialog(null, "Animal borrado correctamente");
            }
	}catch(SQLException e){
            e.printStackTrace();
            System.out.println("ERROR");
            throw new RuntimeException(e);			
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                if(pstm !=null) pstm.close();
                if(con!=null) con.close();
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
    }
	//METODO MOSTRAR DETALLES ANIMAL
	/**nos muestra en detalle todas las caracteristicas del animal seleccionado*/ 
        public void verAnimal(Animal a) {
            String AnimalCompleto=a.getNombre()+" "+a.getOjos()+" "+a.getPatas()+""+a.getPeligrosidad();
            String nombre=a.getNombre();
		
            //MFactura facturas=new MFactura(dni);		
            JFrame j=new JFrame();
            JTabbedPane p=new JTabbedPane();
		
            //p.addTab("Datos de "+ AnimalCompleto,facturas);
            j.getContentPane().add(p);
            j.setTitle("Animal");
            j.setSize(500,550);
            j.setLocation(545, 0);
            j.setVisible(true);
            j.setResizable(false);
	}
	
	//MODIFICAR ANIMALES
        /**Este metodo nos permite modificar un animal en cuestión*/
	public void modificarAnimal(Animal a)  {
            try {			
                String Driver = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/ZOO?ussesSSL=false&serverTimezone=UTC";
		Class.forName(Driver); 
                con = DriverManager.getConnection(URL,"root","root");
				
		String sql= "UPDATE ANIMAL SET NOMBRE=?,OJOS=?,PATAS=?,PELIGROSIDAD=?";
		sql+=" WHERE NOMBRE=?";
		
                pstm=con.prepareStatement(sql);			
                pstm.setString(1, this.getNombre());
		pstm.setInt(2, this.getOjos());
		pstm.setInt(3, this.getPatas());
		pstm.setFloat(4, this.getPeligrosidad());	
                
		
		int resultado =pstm.executeUpdate();
                //Añadimos JOptionPane para cualquier modificacion
		if (resultado==1) {
                    JOptionPane.showMessageDialog(null, "Nombre del animal modificado correctamente");
		}
                else if(resultado==2){
                    JOptionPane.showMessageDialog(null,"Ojos del animal modificado correctamente");
                }
                else if(resultado==3){
                    JOptionPane.showMessageDialog(null,"Patas del animal modificado correctamente");
                }
                else if(resultado==4){
                    JOptionPane.showMessageDialog(null,"Peligrosidad del animal modificado correctamente");
                }
            }
            catch(SQLException e){
                e.printStackTrace();
                System.out.println("ERROR");
                throw new RuntimeException(e);			
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    
   
}

