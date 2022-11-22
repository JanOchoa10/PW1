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
@WebServlet(name = "EliminarVoto", urlPatterns = {"/EliminarVoto"})
public class EliminarVoto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String idVoto = request.getParameter("idVoto");
        int idVotoInt = Integer.parseInt(idVoto);

         VotoDAO vDAO = new VotoDAO();

        try {
            boolean result = vDAO.borrar(idVotoInt);

            if (result) {

                PublicacionDAO pDAO = new PublicacionDAO();
                ArrayList<Publicacion> publicaciones = pDAO.get10PublicacionesPorDefecto();
                request.setAttribute("publicaciones", publicaciones);

                ComentarioDAO cDAO = new ComentarioDAO();
                ArrayList<Comentario> comentarios = cDAO.getAllComentarios();
                request.setAttribute("comentarios", comentarios);

               
                ArrayList<Voto> votos = vDAO.getAllVotos();
                request.setAttribute("votos", votos);

                request.getRequestDispatcher("html/home.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
