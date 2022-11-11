/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import JDBC.Conexion;
import Modelos.Usuario;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

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
        String sql = "SELECT * FROM Usuario;";
        
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        
        con = c.getConnection();
        
        s = con.createStatement();
        rs = s.executeQuery(sql);
        
        while(rs.next()){
            int idUsuario = rs.getInt("ID_Usuario");
            String nombre = rs.getString("Nombre");
            String apePaterno = rs.getString("ApePaterno");
            String apeMaterno = rs.getString("ApeMaterno");
            Date fecNacimiento = rs.getDate("FecNacimiento");
            String email = rs.getString("Email");
            String username = rs.getString("UserName");
            String contrasena = rs.getString("Contrasena");
            Blob userImagen = rs.getBlob("UserImagen");
            int activo = rs.getInt("Activo");
            Date fechaDeCreacion = rs.getDate("FechaDeCreacion");
            Date fechaDeCambio = rs.getDate("FechaDeCambio");
            
            usuarios.add(new Usuario(idUsuario, nombre, apePaterno, apeMaterno, fecNacimiento, email, username, contrasena, userImagen, activo, fechaDeCreacion, fechaDeCambio));
        }
        
        return usuarios;
    }
    
//    public boolean agregar(Usuario user) throws SQLException{
//        String sql = "INSERT INTO usuario (nombre, contra) VALUES (?,?)";
//        
//        con = c.getConnection();
//        
//        ps = con.prepareStatement(sql);
//        ps.setString(1, user.getNombre());
//        ps.setString(2, user.getContra());
//        int result = ps.executeUpdate();
//        
//        if(result > 0){
//            return true;
//        } else {
//            return false;
//        }
//    }
}
