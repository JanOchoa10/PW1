/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.ComentarioDAO;
import DAO.PublicacionDAO;
import DAO.UsuarioDAO;
import DAO.VotoDAO;
import Modelos.Comentario;
import Modelos.Publicacion;
import Modelos.Usuario;
import Modelos.Voto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "ActualizarCuenta", urlPatterns = {"/ActualizarCuenta"})
public class ActualizarCuenta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        HttpSession miSesion = request.getSession();
        ArrayList miLista = (ArrayList) miSesion.getAttribute("usuarios");
        Usuario datosDeMiUsuario = (Usuario) miLista.get(0);
        int myUsuarioId = datosDeMiUsuario.getID_Usuario();

        String nombre = request.getParameter("names");
        String apePaterno = request.getParameter("lastNameP");
        String apeMaterno = request.getParameter("lastNameM");
        String fecNacimiento = request.getParameter("birthday");
        String email = request.getParameter("email");
        String userName = request.getParameter("username");
        String contra = request.getParameter("password1");
        String userImagen = request.getParameter("imagenSubida");

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

        String miImagenURL = request.getParameter("miImgURL");

        Usuario usuario;
        if (!"".equals(userImagen)) {
            usuario = new Usuario(myUsuarioId, nombre, apePaterno, apeMaterno, fecNacimiento, email, userName, contra, userImagen, 1, timeStamp, timeStamp);
        } else {
            usuario = new Usuario(myUsuarioId, nombre, apePaterno, apeMaterno, fecNacimiento, email, userName, contra, miImagenURL, 1, timeStamp, timeStamp);
        }

        UsuarioDAO uDAO = new UsuarioDAO();
        try {
            boolean result = uDAO.actualizar(usuario);

            if (result) {

                ArrayList<Usuario> usuarios = uDAO.getUnUsuario(usuario);
                ArrayList<Usuario> usuariosall = uDAO.getUsuarios();

//                HttpSession miSesion = request.getSession();
                miSesion.setAttribute("userName", userName);
                miSesion.setAttribute("contrasena", contra);
                miSesion.setAttribute("cantidad", "10");
                miSesion.setAttribute("cantidadComentadas", "0");
                miSesion.setAttribute("cantidadVotadas", "0");
                miSesion.setAttribute("cantidadBuscadas", "0");

                miSesion.setAttribute("usuarios", usuarios);
                miSesion.setAttribute("usuariosall", usuariosall);

                PublicacionDAO pDAO = new PublicacionDAO();
                ArrayList<Publicacion> publicaciones = pDAO.get10PublicacionesPorDefecto();
                request.setAttribute("publicaciones", publicaciones);

                ComentarioDAO cDAO = new ComentarioDAO();
                ArrayList<Comentario> comentarios = cDAO.getAllComentarios();
                request.setAttribute("comentarios", comentarios);

                VotoDAO vDAO = new VotoDAO();
                ArrayList<Voto> votos = vDAO.getAllVotos();
                request.setAttribute("votos", votos);

                request.getRequestDispatcher("html/home.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
