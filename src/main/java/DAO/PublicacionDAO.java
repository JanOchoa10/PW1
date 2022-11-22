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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

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

    public ArrayList<Publicacion> getCargarPublicaciones(String cantidad) throws SQLException {
        String sql = "SELECT ID_Publicacion, Texto, Imagen, Spoiler, ID_Usuario, Activo, FechaDeCreacion, FechaDeCambio FROM publicacion WHERE Activo = 1 ORDER BY FechaDeCreacion DESC LIMIT ? ;";

        ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();

        con = c.getConnection();

        ps = con.prepareStatement(sql);
        int miNCant = Integer.parseInt(cantidad);
        ps.setInt(1, miNCant);
        rs = ps.executeQuery();

        while (rs.next()) {
            int id_publicacion = rs.getInt("ID_Publicacion");
            String texto = rs.getString("Texto");
            String imagen = rs.getString("Imagen");
            int spoiler = rs.getInt("Spoiler");
            int id_usuario = rs.getInt("ID_Usuario");
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

            publicaciones.add(new Publicacion(id_publicacion, texto, imagen, spoiler, id_usuario, activo, fechaDeCreacion, fechaDeCambio));

        }

        return publicaciones;
    }

    public ArrayList<Publicacion> get10PublicacionesPorDefecto() throws SQLException {
        String sql = "SELECT ID_Publicacion, Texto, Imagen, Spoiler, ID_Usuario, Activo, FechaDeCreacion, FechaDeCambio FROM publicacion WHERE Activo = 1 ORDER BY FechaDeCreacion DESC LIMIT 10;";

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

            publicaciones.add(new Publicacion(id_publicacion, texto, imagen, spoiler, id_usuario, activo, fechaDeCreacion, fechaDeCambio));

        }

        return publicaciones;
    }

    public ArrayList<Publicacion> getUnaPublicacion(int publi) throws SQLException, IOException {
        String sql = "SELECT * FROM publicacion WHERE ID_Publicacion = ? ;";

        ArrayList<Publicacion> publicacionEditable = new ArrayList<Publicacion>();

        con = c.getConnection();

        ps = con.prepareStatement(sql);

//        int miNCant = Integer.parseInt(cantidad);
        ps.setInt(1, publi);
        rs = ps.executeQuery();

        while (rs.next()) {
            int id_publicacion = rs.getInt("ID_Publicacion");
            String texto = rs.getString("Texto");
            String imagen = rs.getString("Imagen");
            int spoiler = rs.getInt("Spoiler");
            int id_usuario = rs.getInt("ID_Usuario");
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

            publicacionEditable.add(new Publicacion(id_publicacion, texto, imagen, spoiler, id_usuario, activo, fechaDeCreacion, fechaDeCambio));

        }

        return publicacionEditable;
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

    public boolean borrar(int idNota) throws SQLException {
        //String sql = "DELETE FROM Publicacion WHERE ID_Publicacion = ? ;";
        // UPDATE Publicacion SET Activo = 0 WHERE ID_Publicacion = 18;

        String sql = "UPDATE Publicacion SET Activo = 0 WHERE ID_Publicacion = ? ;";

// Texto, String Imagen, int Spoiler, int ID_Usario, int Activo, String FechaDeCreacion, String FechaDeCambio
        con = c.getConnection();

        ps = con.prepareStatement(sql);

        String myIdS = Integer.toString(idNota);

        ps.setString(1, myIdS);
        int result = ps.executeUpdate();

        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean editar(Publicacion publi, int idNota) throws SQLException {

        String sql = "UPDATE Publicacion SET Texto = ? , Imagen = ? , Spoiler = ? , FechaDeCambio = ? WHERE ID_Publicacion = ? ;";

        con = c.getConnection();
        ps = con.prepareStatement(sql);

//        String myIdS = Integer.toString(idNota);
        ps.setString(1, publi.getTexto());
        ps.setString(2, publi.getImagen());
        ps.setInt(3, publi.getSpoiler());
        ps.setString(4, publi.getFechaDeCambio());

        ps.setInt(5, idNota);
        int result = ps.executeUpdate();

        if (result > 0) {
            return true;
        } else {
            return false;
        }

//        return false;
    }
    
    
    public ArrayList<Publicacion> getMasComentadas() throws SQLException {
        String sql = "select P.ID_Publicacion, P.Texto, P.Imagen, P.Spoiler, P.ID_Usuario, P.Activo, P.FechaDeCreacion, P.FechaDeCambio from Publicacion P left join comentario C on C.ID_Publicacion = P.ID_Publicacion WHERE P.Activo = 1 AND (C.Activo is null OR C.Activo = 1) GROUP BY P.ID_Publicacion ORDER BY COUNT(C.ID_Publicacion) DESC LIMIT 10;";

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

            publicaciones.add(new Publicacion(id_publicacion, texto, imagen, spoiler, id_usuario, activo, fechaDeCreacion, fechaDeCambio));

        }

        return publicaciones;
    }
    
     public ArrayList<Publicacion> getMasVotadas() throws SQLException {
        String sql = "select P.ID_Publicacion, P.Texto, P.Imagen, P.Spoiler, P.ID_Usuario, P.Activo, P.FechaDeCreacion, P.FechaDeCambio from Publicacion P left join usuario_gusta_publicacion C on C.ID_Publicacion = P.ID_Publicacion WHERE P.Activo = 1 AND (C.Activo is null OR C.Activo = 1) GROUP BY P.ID_Publicacion ORDER BY COUNT(C.ID_Publicacion) DESC LIMIT 10;";

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

            publicaciones.add(new Publicacion(id_publicacion, texto, imagen, spoiler, id_usuario, activo, fechaDeCreacion, fechaDeCambio));

        }

        return publicaciones;
    }
     
     public ArrayList<Publicacion> getBuscadas(String valorDeBusqueda) throws SQLException, IOException {
        String sql = "select * from publicacion where texto like ? AND Activo = 1 order by fechaDeCreacion desc limit 10;";

        ArrayList<Publicacion> publicacionEditable = new ArrayList<Publicacion>();

        con = c.getConnection();

        ps = con.prepareStatement(sql);
        ps.setString(1, valorDeBusqueda);
        rs = ps.executeQuery();

        while (rs.next()) {
            int id_publicacion = rs.getInt("ID_Publicacion");
            String texto = rs.getString("Texto");
            String imagen = rs.getString("Imagen");
            int spoiler = rs.getInt("Spoiler");
            int id_usuario = rs.getInt("ID_Usuario");
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

            publicacionEditable.add(new Publicacion(id_publicacion, texto, imagen, spoiler, id_usuario, activo, fechaDeCreacion, fechaDeCambio));

        }

        return publicacionEditable;
    }
     

}
