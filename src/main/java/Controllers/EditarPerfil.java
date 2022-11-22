/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.UsuarioDAO;
import Modelos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jan
 */
@WebServlet(name = "EditarPerfil", urlPatterns = {"/EditarPerfil"})
public class EditarPerfil extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        HttpSession miSesion = request.getSession();
        String userName = (String) miSesion.getAttribute("userName");
        String contrasena = (String) miSesion.getAttribute("contrasena");

        ArrayList miLista = (ArrayList) miSesion.getAttribute("usuarios");
        Usuario datosDeMiUsuario = (Usuario) miLista.get(0);
        int myUsuarioId = datosDeMiUsuario.getID_Usuario();

        UsuarioDAO uDAO = new UsuarioDAO();

        try {
//            ArrayList<Publicacion> publicacion = pDAO.getUnaPublicacion(idPost);
//            request.setAttribute("publicacionEditable", publicacion);
//
//            ComentarioDAO cDAO = new ComentarioDAO();
//            ArrayList<Comentario> comentarios = cDAO.getAllComentarios();
//            request.setAttribute("comentarios", comentarios);
//
//            VotoDAO vDAO = new VotoDAO();
//            ArrayList<Voto> votos = vDAO.getAllVotos();
//            request.setAttribute("votos", votos);

            ArrayList<Usuario> usuarios = uDAO.getUnUsuario(datosDeMiUsuario);
            miSesion.setAttribute("usuarioAEditar", usuarios);

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaNac = LocalDate.parse(usuarios.get(0).getFecNacimiento(), fmt);
            LocalDate ahora = LocalDate.now();
            Period periodo = Period.between(fechaNac, ahora);
            String edadUsuario = Integer.toString(periodo.getYears());
            
            miSesion.setAttribute("edadUsuario", edadUsuario);

            request.getRequestDispatcher("html/editarUsuario.jsp").forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(EditarPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
