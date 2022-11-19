/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import JDBC.Conexion;
import Modelos.Usuario;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

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

    public ArrayList<Usuario> getUsuarios() throws SQLException {
        String sql = "SELECT * FROM usuario;";

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        con = c.getConnection();

        s = con.createStatement();
        rs = s.executeQuery(sql);

        while (rs.next()) {
            int id_usuario = rs.getInt("ID_Usuario");
            String nombre = rs.getString("Nombre");
            String userName = rs.getString("UserName");
            String contrasena = rs.getString("Contrasena");

            usuarios.add(new Usuario(id_usuario, nombre, userName, contrasena));

        }

        return usuarios;
    }

    public ArrayList<Usuario> getUnUsuario(Usuario user) throws SQLException, IOException {
        String sql = "SELECT * FROM usuario WHERE UserName = ? AND Contrasena = ?;";

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        con = c.getConnection();

        ps = con.prepareStatement(sql);
        ps.setString(1, user.getUserName());
        ps.setString(2, user.getContrasena());
        rs = ps.executeQuery();

        while (rs.next()) {
            if (rs.getString("UserName") != null) {
                int id_usuario = rs.getInt("ID_Usuario");
                String nombre = rs.getString("Nombre");
                String apepaterno = rs.getString("ApePaterno");
                String apematerno = rs.getString("ApeMaterno");
                String fecnacimiento = rs.getString("FecNacimiento");
                String email = rs.getString("Email");
                String username = rs.getString("UserName");
                String contrasena = rs.getString("Contrasena");
                String userimagen = rs.getString("UserImagen");
                int activo = rs.getInt("Activo");
                String fechadecreacion = rs.getString("FechaDeCreacion");
                String fechadecambio = rs.getString("FechaDeCambio");

//                // Leemos binario
//                Blob blob = rs.getBlob("UserImagen");
//                // Pasamos el binario a imagen
//                byte[] data = blob.getBytes(1, (int) blob.length());
//                // Lee la imagen
//                BufferedImage img = null;
//                try {
//                    img = ImageIO.read(new ByteArrayInputStream(data));
//                } catch (IOException e){
//                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
//                }
//                
//                ImageIcon icono = new ImageIcon(img);
//                Icon imagen = new ImageIcon(icono.getImage().getScaledInstance(100, 100, 1));
//                InputStream inputStream = rs.getBinaryStream("UserImagen");
//                Blob blob = rs.getBlob("UserImagen");
//                byte byteArray[] = blob.getBytes(1, (int) blob.length());
//                response.
                
                
                

                usuarios.add(new Usuario(id_usuario, nombre, apepaterno, apematerno, fecnacimiento, email, username, contrasena, userimagen, activo, fechadecreacion, fechadecambio));
                //            Nombre, ApePaterno, ApeMaterno, FecNacimiento, Email, UserName, Contrasena, UserImagen
            }
        }

        return usuarios;
    }

    public boolean agregar(Usuario user) throws SQLException {
        String sql = "INSERT INTO usuario (Nombre, ApePaterno, ApeMaterno, FecNacimiento, Email, UserName, Contrasena, UserImagen, Activo, FechaDeCreacion, FechaDeCambio)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        con = c.getConnection();

        ps = con.prepareStatement(sql);
        ps.setString(1, user.getNombre());
        ps.setString(2, user.getApePaterno());
        ps.setString(3, user.getApeMaterno());
        ps.setString(4, user.getFecNacimiento());
        ps.setString(5, user.getEmail());
        ps.setString(6, user.getUserName());
        ps.setString(7, user.getContrasena());
        ps.setString(8, user.getUserImagen());
        ps.setInt(9, user.getActivo());
        ps.setString(10, user.getFechaDeCreacion());
        ps.setString(11, user.getFechaDeCambio());
        int result = ps.executeUpdate();

        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }
}
