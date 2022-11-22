/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import JDBC.Conexion;
import Modelos.Voto;
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
public class VotoDAO {

    private Connection con;
    private Conexion c = new Conexion();
    private Statement s;
    private PreparedStatement ps;
    private CallableStatement cs;
    private ResultSet rs;
    
    
    public ArrayList<Voto> getAllVotos() throws SQLException {
        String sql = "SELECT * FROM usuario_gusta_publicacion WHERE Activo = 1 ;";

        ArrayList<Voto> votos = new ArrayList<Voto>();

        con = c.getConnection();

        ps = con.prepareStatement(sql);
//        int miNCant = Integer.parseInt(cantidad);
//        ps.setInt(1, miNCant);
        rs = ps.executeQuery();

        while (rs.next()) {
            int id_ugp = rs.getInt("ID_UGP");
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

            votos.add(new Voto(id_ugp, id_usuario, id_publicacion, activo, fechaDeCreacion, fechaDeCambio));

        }

        return votos;
    }

    public boolean agregar(Voto mVoto) throws SQLException {
        String sql = "INSERT INTO usuario_gusta_publicacion (ID_Usuario, ID_Publicacion, Activo, FechaDeCreacion, FechaDeCambio)"
                + " VALUES (?,?,?,?,?)";
        con = c.getConnection();

        ps = con.prepareStatement(sql);
        ps.setInt(1, mVoto.getID_Usuario());
        ps.setInt(2, mVoto.getID_Publicacion());
        ps.setInt(3, mVoto.getActivo());
        ps.setString(4, mVoto.getFechaDeCreacion());
        ps.setString(5, mVoto.getFechaDeCambio());
        int result = ps.executeUpdate();

        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean borrar(int idVoto) throws SQLException {
        
        String sql = "UPDATE usuario_gusta_publicacion SET Activo = 0 WHERE ID_UGP = ? ;";
        
        con = c.getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, idVoto);
        int result = ps.executeUpdate();

        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
}
