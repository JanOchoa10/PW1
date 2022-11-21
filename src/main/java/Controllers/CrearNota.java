/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.PublicacionDAO;
import Modelos.Publicacion;
import Modelos.Usuario;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
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
@WebServlet(name = "CrearNota", urlPatterns = {"/CrearNota"})
public class CrearNota extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession sesion = request.getSession();

        String miContenido = request.getParameter("miContenido");
        String miImagen = request.getParameter("miImg");
        String miContenido2 = request.getParameter("miContenido2");
        int spoiler = 0;
        String username = (String) sesion.getAttribute("userName");

        ArrayList miLista = (ArrayList) sesion.getAttribute("usuarios");
        Usuario datosDeMiUsuario = (Usuario) miLista.get(0);
        int myUsuarioId = datosDeMiUsuario.getID_Usuario();
        String apePaterno = datosDeMiUsuario.getApePaterno();

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

        Publicacion publicacion = new Publicacion(miContenido, miImagen, spoiler, myUsuarioId, 1, timeStamp, timeStamp);

        PublicacionDAO pDAO = new PublicacionDAO();

        try {
            boolean result = pDAO.agregar(publicacion);

            if (result) {
                

                ArrayList<Publicacion> publicaciones = pDAO.get5PublicacionesPorDefecto();

                request.setAttribute("publicaciones", publicaciones);
                
                request.getRequestDispatcher("html/home.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}