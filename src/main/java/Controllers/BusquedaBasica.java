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
@WebServlet(name = "BusquedaBasica", urlPatterns = {"/BusquedaBasica"})
public class BusquedaBasica extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession sesion = request.getSession();

        String myBusqueda = request.getParameter("buscar");
        String paraPasar = "%" + myBusqueda + "%";
        
        sesion.setAttribute("parametroDeBusqueda", paraPasar);

        PublicacionDAO pDAO = new PublicacionDAO();

        try {

            HttpSession miSesion = request.getSession();
//            miSesion.setAttribute("userName", user);
//            miSesion.setAttribute("contrasena", contra);
            miSesion.setAttribute("cantidad", "0");
            miSesion.setAttribute("cantidadComentadas", "0");
            miSesion.setAttribute("cantidadVotadas", "0");
            miSesion.setAttribute("cantidadBuscadas", "10");
            
            String cantidadBuscadas = (String) miSesion.getAttribute("cantidadBuscadas");

            ArrayList<Publicacion> publicaciones = pDAO.getBuscadas(paraPasar, cantidadBuscadas);
            request.setAttribute("publicaciones", publicaciones);

            ComentarioDAO cDAO = new ComentarioDAO();
            ArrayList<Comentario> comentarios = cDAO.getAllComentarios();
            request.setAttribute("comentarios", comentarios);

            VotoDAO vDAO = new VotoDAO();
            ArrayList<Voto> votos = vDAO.getAllVotos();
            request.setAttribute("votos", votos);

            request.getRequestDispatcher("html/home.jsp").forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(VerNotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
