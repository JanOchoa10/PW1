/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import JDBC.Conexion;
import Modelos.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jan
 */
public class UsuarioDAO {
   private Connection con;
    private Conexion c = new Conexion();
    private Statement s;
    private PreparedStatement ps;
    private CallableStatement cs;
    private ResultSet rs;
    
    public ArrayList<Usuario> getUsuarios() throws SQLException{
        String sql = "SELECT * FROM usuario;";
        
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        
        con = c.getConnection();
        
        s = con.createStatement();
        rs = s.executeQuery(sql);
        
        while(rs.next()){
            int idUsuario = rs.getInt("ID_Usuario");
            String nombre = rs.getString("Nombre");
            String contra = rs.getString("Contrasena");
            
            usuarios.add(new Usuario(idUsuario, nombre, contra));
        }
        
        return usuarios;
    }
    
    public boolean agregar(Usuario user) throws SQLException{
        String sql = "INSERT INTO usuario (Nombre, Contrasena) VALUES (?,?)";
        
        con = c.getConnection();
        
        ps = con.prepareStatement(sql);
        ps.setString(1, user.getNombre());
        ps.setString(2, user.getContrasena());
        int result = ps.executeUpdate();
        
        if(result > 0){
            return true;
        } else {
            return false;
        }
    }
}
