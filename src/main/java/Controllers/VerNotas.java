/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.PublicacionDAO;
import Modelos.Publicacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "notas", urlPatterns = {"/notas"})
public class VerNotas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
//        request.setCharacterEncoding("UTF-8");
        HttpSession sesion = request.getSession();

        String username = (String) sesion.getAttribute("userName");
        String miCanti = (String) sesion.getAttribute("cantidad");

        int cantidad = Integer.parseInt(miCanti);
        int nuevaCantidad = cantidad + 10;
        String nCant = Integer.toString(nuevaCantidad);
        sesion.setAttribute("cantidad", nCant);

        PublicacionDAO pDAO = new PublicacionDAO();

        try {
            ArrayList<Publicacion> publicaciones = pDAO.getCargarPublicaciones(nCant);

            request.setAttribute("publicaciones", publicaciones);

            request.getRequestDispatcher("html/home.jsp").forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(VerNotas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
