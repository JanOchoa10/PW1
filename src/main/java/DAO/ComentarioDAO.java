/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import JDBC.Conexion;
import Modelos.Comentario;
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
public class ComentarioDAO {

    private Connection con;
    private Conexion c = new Conexion();
    private Statement s;
    private PreparedStatement ps;
    private CallableStatement cs;
    private ResultSet rs;

    public ArrayList<Comentario> getAllComentarios() throws SQLException {
        String sql = "SELECT * FROM comentario WHERE Activo = 1 ORDER BY FechaDeCreacion DESC ;";

        ArrayList<Comentario> comentarios = new ArrayList<Comentario>();

        con = c.getConnection();

        ps = con.prepareStatement(sql);
//        int miNCant = Integer.parseInt(cantidad);
//        ps.setInt(1, miNCant);
        rs = ps.executeQuery();

        while (rs.next()) {
            int id_comentario = rs.getInt("ID_Comentario");
            String texto = rs.getString("Texto");
            int spoiler = rs.getInt("Spoiler");
            int id_usuario = rs.getInt("ID_Usuario");
            int id_publicacion = rs.getInt("ID_Publicacion");
            int activo = rs.getInt("Activo");
            String fechaDeCreacion = rs.getString("FechaDeCreacion");

            int anio = Integer.parseInt(fechaDeCreacion.substring(0, 4));
            int mes = Integer.parseInt(fechaDeCreacion.substring(5, 7));
            int dia = Integer.parseInt(fechaDeCreacion.substring(8, 10));
            int hora = Integer.parseInt(fechaDeCreacion.substring(11, 13));
            String horaS = fechaDeCreacion.substring(11, 19);
            String horaT = "";

            String mesS = "";
            switch (mes) {
                case 1: {
                    mesS = "Enero";
                }
                break;
                case 2: {
                    mesS = "Febrero";
                }
                break;
                case 3: {
                    mesS = "Marzo";
                }
                break;
                case 4: {
                    mesS = "Abril";
                }
                break;
                case 5: {
                    mesS = "Mayo";
                }
                break;
                case 6: {
                    mesS = "Junio";
                }
                break;
                case 7: {
                    mesS = "Julio";
                }
                break;
                case 8: {
                    mesS = "Agosto";
                }
                break;
                case 9: {
                    mesS = "Septiembre";
                }
                break;
                case 10: {
                    mesS = "Octubre";
                }
                break;
                case 11: {
                    mesS = "Noviembre";
                }
                break;
                case 12: {
                    mesS = "Diciembre";
                }
                break;

                default:
                    break;
            }

            if (hora >= 12) {
                horaT = "pm";
            } else {
                horaT = "am";
            }

            fechaDeCreacion = dia + " de " + mesS + " de " + anio + ", " + horaS + " " + horaT + ".";

            String fechaDeCambio = rs.getString("FechaDeCambio");

            comentarios.add(new Comentario(id_comentario, texto, spoiler, id_usuario, id_publicacion, activo, fechaDeCreacion, fechaDeCambio));

        }

        return comentarios;
    }
    
    public boolean agregar(Comentario mComentario) throws SQLException {
        String sql = "INSERT INTO comentario (Texto, Spoiler, ID_Usuario, ID_Publicacion, Activo, FechaDeCreacion, FechaDeCambio)"
                + " VALUES (?,?,?,?,?,?,?)";
        con = c.getConnection();

        ps = con.prepareStatement(sql);
        ps.setString(1, mComentario.getTexto());
        ps.setInt(2, mComentario.getSpoiler());
        ps.setInt(3, mComentario.getID_Usuario());
        ps.setInt(4, mComentario.getID_Publicacion());
        ps.setInt(5, mComentario.getActivo());
        ps.setString(6, mComentario.getFechaDeCreacion());
        ps.setString(7, mComentario.getFechaDeCambio());
        int result = ps.executeUpdate();

        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }
    
     public boolean borrar(int idComentario) throws SQLException {
        //String sql = "DELETE FROM Publicacion WHERE ID_Publicacion = ? ;";
        // UPDATE Publicacion SET Activo = 0 WHERE ID_Publicacion = 18;

        String sql = "UPDATE comentario SET Activo = 0 WHERE ID_Comentario = ? ;";

// Texto, String Imagen, int Spoiler, int ID_Usario, int Activo, String FechaDeCreacion, String FechaDeCambio
        con = c.getConnection();

        ps = con.prepareStatement(sql);

//        String myIdS = Integer.toString(idComentario);

        ps.setInt(1, idComentario);
        int result = ps.executeUpdate();

        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }
}
