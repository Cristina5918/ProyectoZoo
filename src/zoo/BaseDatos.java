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
import java.util.ArrayList;
import java.util.List;
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
    
    public List<Usuario> getAllUsers(){
    	List<Usuario> returnList = new ArrayList<>();
    	ResultSet rs = null;
        PreparedStatement pstm = null;
    	String sql = "SELECT * FROM USUARIO";
    	try{
            Class.forName(Driver);
            con = DriverManager.getConnection(URL,BBDDUser,BBDDPass);
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
            	Usuario u = new Usuario();
            	u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setEdad(rs.getInt("edad"));
                u.setRol(rs.getBoolean("rol"));
                u.setLogin(rs.getString("login"));
                u.setPassword(rs.getString("password"));
                returnList.add(u);
            }
    	}catch (Exception e) {
    		e.printStackTrace();
		}finally{
            try {
                pstm.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    	return returnList;
    	
    }
    
    public void closeConection() throws SQLException{
        con.close();
    }

    public boolean deleteUsuario(String input) {
        boolean returnValue = false;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        String sql = "DELETE FROM USUARIO WHERE LOGIN = ?";
        try{
            Class.forName(Driver);
            con = DriverManager.getConnection(URL,BBDDUser,BBDDPass);
            pstm = con.prepareStatement(sql);
            pstm.setString(1,input);
            int resultado = pstm.executeUpdate();
            if (resultado==1) {
                returnValue = true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                pstm.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return returnValue;
    }

    public boolean addUsusario(Usuario u) {
        boolean returnValue = false;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        String sql = "INSERT INTO USUARIO(nombre,apellido,edad,rol,login,password) VALUES" +
                "('"+u.getNombre()+"','"+u.getApellido()+"',"+u.getEdad()+",0,'"+u.getLogin()+"','"+u.getPassword()+"')";
        try{
            Class.forName(Driver);
            con = DriverManager.getConnection(URL,BBDDUser,BBDDPass);
            pstm = con.prepareStatement(sql);
            int resultado = pstm.executeUpdate();
            if (resultado==1) {
                returnValue = true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                pstm.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return returnValue;
    }

    public boolean editUsusario(Usuario ux) {
        boolean returnValue = false;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        String sql = "UPDATE USUARIO SET nombre='"+ux.getNombre()+"', apellido='"+ux.getApellido()+"'," +
                "edad="+ux.getEdad()+"," +
                "login='"+ux.getLogin()+"',password='"+ux.getPassword()+"'" +
            "WHERE login='"+ux.getLogin()+"'";
        try{
            Class.forName(Driver);
            con = DriverManager.getConnection(URL,BBDDUser,BBDDPass);
            pstm = con.prepareStatement(sql);
            int resultado = pstm.executeUpdate();
            if (resultado==1) {
                returnValue = true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                pstm.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return returnValue;
    }



    public List<Animal> getAllAnimals(){
        List<Animal> returnList = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement pstm = null;
        String sql = "SELECT * FROM ANIMAL";
        try{
            Class.forName(Driver);
            con = DriverManager.getConnection(URL,BBDDUser,BBDDPass);
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                Animal a = new Animal();
                a.setNombre(rs.getString("nombre"));
                a.setOjos(rs.getInt("ojos"));
                a.setPatas(rs.getInt("patas"));
                a.setPeligrosidad(rs.getInt("peligrosidad"));
                returnList.add(a);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                pstm.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return returnList;

    }

    public boolean addAnimal(Animal a) {
        boolean returnValue = false;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        String sql = "INSERT INTO ANIMAL(nombre,ojos,patas,peligrosidad) VALUES" +
                "('"+a.getNombre()+"',"+a.getOjos()+","+a.getPatas()+","+a.getPeligrosidad()+")";
        try{
            Class.forName(Driver);
            con = DriverManager.getConnection(URL,BBDDUser,BBDDPass);
            pstm = con.prepareStatement(sql);
            int resultado = pstm.executeUpdate();
            if (resultado==1) {
                returnValue = true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                pstm.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return returnValue;
    }


    public boolean deleteAnimal(String input) {
        boolean returnValue = false;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        String sql = "DELETE FROM ANIMAL WHERE NOMBRE = ?";
        try{
            Class.forName(Driver);
            con = DriverManager.getConnection(URL,BBDDUser,BBDDPass);
            pstm = con.prepareStatement(sql);
            pstm.setString(1,input);
            int resultado = pstm.executeUpdate();
            if (resultado==1) {
                returnValue = true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                pstm.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return returnValue;
    }

    public boolean editAnimal(Animal ax) {
        boolean returnValue = false;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        String sql = "UPDATE ANIMAL SET nombre='"+ax.getNombre()+"', ojos="+ax.getOjos()+"," +
                "patas="+ax.getPatas()+"," +
                "peligrosidad="+ax.getPeligrosidad()+"" +
                "WHERE nombre='"+ax.getNombre()+"'";
        try{
            Class.forName(Driver);
            con = DriverManager.getConnection(URL,BBDDUser,BBDDPass);
            pstm = con.prepareStatement(sql);
            int resultado = pstm.executeUpdate();
            if (resultado==1) {
                returnValue = true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                pstm.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return returnValue;
    }

    public boolean administrador(String input) {
        boolean returnValue = false;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        String sql = "UPDATE USUARIO set rol = 1 WHERE LOGIN = ?";
        try{
            Class.forName(Driver);
            con = DriverManager.getConnection(URL,BBDDUser,BBDDPass);
            pstm = con.prepareStatement(sql);
            pstm.setString(1,input);
            int resultado = pstm.executeUpdate();
            if (resultado==1) {
                returnValue = true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                pstm.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return returnValue;
    }
}
