/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.ComentarioDAO;
import DAO.PublicacionDAO;
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
@WebServlet(name = "CrearVoto", urlPatterns = {"/CrearVoto"})
public class CrearVoto extends HttpServlet {

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
        String idUsuario = request.getParameter("idUsuario");
        int idUsuarioInt = Integer.parseInt(idUsuario);
        int spoiler = 0;
        String username = (String) sesion.getAttribute("userName");

        ArrayList miLista = (ArrayList) sesion.getAttribute("usuarios");
        Usuario datosDeMiUsuario = (Usuario) miLista.get(0);
        int myUsuarioId = datosDeMiUsuario.getID_Usuario();
        String apePaterno = datosDeMiUsuario.getApePaterno();

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

        Voto voto = new Voto(myUsuarioId, idNotaInt, 1, timeStamp, timeStamp);

        VotoDAO vDAO = new VotoDAO();

        try {
            boolean result = vDAO.agregar(voto);

            if (result) {

                ComentarioDAO cDAO = new ComentarioDAO();
                ArrayList<Comentario> comentarios = cDAO.getAllComentarios();
                request.setAttribute("comentarios", comentarios);

                PublicacionDAO pDAO = new PublicacionDAO();
                ArrayList<Publicacion> publicaciones = pDAO.get5PublicacionesPorDefecto();
                request.setAttribute("publicaciones", publicaciones);
                
                ArrayList<Voto> votos = vDAO.getAllVotos();
                request.setAttribute("votos", votos);

                request.getRequestDispatcher("html/home.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrearVoto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

