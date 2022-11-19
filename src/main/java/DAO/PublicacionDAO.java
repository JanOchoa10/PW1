/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import JDBC.Conexion;
import Modelos.Publicacion;
import Modelos.Usuario;
import java.io.IOException;
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
public class PublicacionDAO {

    private Connection con;
    private Conexion c = new Conexion();
    private Statement s;
    private PreparedStatement ps;
    private CallableStatement cs;
    private ResultSet rs;

    public ArrayList<Publicacion> getPublicaciones() throws SQLException {
        String sql = "SELECT * FROM publicacion;";

        ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();

        con = c.getConnection();

        s = con.createStatement();
        rs = s.executeQuery(sql);

        while (rs.next()) {
            int id_publicacion = rs.getInt("ID_Publicacion");
            String texto = rs.getString("Texto");
            String imagen = rs.getString("Imagen");
            int spoiler = rs.getInt("Spoiler");
            int id_usuario = rs.getInt("ID_Usuario");
            int activo = rs.getInt("Activo");
            String fechaDeCreacion = rs.getString("FechaDeCreacion");
            String fechaDeCambio = rs.getString("FechaDeCambio");
            

            publicaciones.add(new Publicacion(id_publicacion, texto, imagen, spoiler, id_usuario, activo, fechaDeCreacion, fechaDeCambio));

        }

        return publicaciones;
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

    public boolean agregar(Publicacion user) throws SQLException {
        String sql = "INSERT INTO publicacion (Texto, Imagen, Spoiler, ID_Usuario, Activo, FechaDeCreacion, FechaDeCambio)"
                + " VALUES (?,?,?,?,?,?,?)";
// Texto, String Imagen, int Spoiler, int ID_Usario, int Activo, String FechaDeCreacion, String FechaDeCambio
        con = c.getConnection();

        ps = con.prepareStatement(sql);
        ps.setString(1, user.getTexto());
        ps.setString(2, user.getImagen());
        ps.setInt(3, user.getSpoiler());
        ps.setInt(4, user.getID_Usuario());
        ps.setInt(5, user.getActivo());
        ps.setString(6, user.getFechaDeCreacion());
        ps.setString(7, user.getFechaDeCambio());
        int result = ps.executeUpdate();

        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

}
