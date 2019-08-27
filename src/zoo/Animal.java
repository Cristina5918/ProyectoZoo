
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
    private Integer ojos;
    private Integer patas;
    private Integer peligrosidad;
    
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

    Animal() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getOjos() {
        return ojos;
    }

    public void setOjos(Integer ojos) {
        this.ojos = ojos;
    }

    public Integer getPatas() {
        return patas;
    }

    public void setPatas(Integer patas) {
        this.patas = patas;
    }

    public Integer getPeligrosidad() {
        return peligrosidad;
    }

    public void setPeligrosidad(Integer peligrosidad) {
        this.peligrosidad = peligrosidad;
    }
}

