/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author crist
 */
public class BaseDatos {
    
    private static String Driver = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/ZOO?ussesSSL=false&serverTimezone=UTC";
    private static String BBDDUser = "root";
    private static String BBDDPass = "root";
    Connection con = null;
    
    public BaseDatos(){
    }
    
    public Usuario executeGetUsuario(String sql){
        ResultSet rs = null;
        PreparedStatement pstm = null;
        Usuario u = null;
        try{
            Class.forName(Driver);
            con = DriverManager.getConnection(URL,BBDDUser,BBDDPass);
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                u = new Usuario();
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setEdad(rs.getInt("edad"));
                u.setRol(rs.getBoolean("rol"));
                u.setLogin(rs.getString("login"));
                u.setPassword(rs.getString("password"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException ex) {
                Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        finally{
            
            try {
                pstm.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return u;
        
    }
    
    public void closeConection() throws SQLException{
        con.close();
    }
    
}
