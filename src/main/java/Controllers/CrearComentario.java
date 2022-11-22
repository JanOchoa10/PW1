/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.ComentarioDAO;
import DAO.PublicacionDAO;
import Modelos.Comentario;
import Modelos.Publicacion;
import Modelos.Usuario;
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
@WebServlet(name = "CrearComentario", urlPatterns = {"/CrearComentario"})
public class CrearComentario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession sesion = request.getSession();

        String myComentario = request.getParameter("myComentario");
        String idNota = request.getParameter("idNota");
        int idNotaInt = Integer.parseInt(idNota);
        int spoiler = 0;
        String username = (String) sesion.getAttribute("userName");

        ArrayList miLista = (ArrayList) sesion.getAttribute("usuarios");
        Usuario datosDeMiUsuario = (Usuario) miLista.get(0);
        int myUsuarioId = datosDeMiUsuario.getID_Usuario();
        String apePaterno = datosDeMiUsuario.getApePaterno();

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

        Comentario comentario = new Comentario(myComentario, spoiler, myUsuarioId, idNotaInt, 1, timeStamp, timeStamp);

        ComentarioDAO cDAO = new ComentarioDAO();

        try {
            boolean result = cDAO.agregar(comentario);

            if (result) {

                ArrayList<Comentario> comentarios = cDAO.getAllComentarios();

                request.setAttribute("comentarios", comentarios);

                PublicacionDAO pDAO = new PublicacionDAO();

                ArrayList<Publicacion> publicaciones = pDAO.get5PublicacionesPorDefecto();

                request.setAttribute("publicaciones", publicaciones);

                request.getRequestDispatcher("html/home.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrearComentario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
