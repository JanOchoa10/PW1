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
@WebServlet(name = "home", urlPatterns = {"/home"})
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet prueba</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet prueba at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        request.getRequestDispatcher("html/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String user = request.getParameter("username");
        String contra = request.getParameter("password1");

        Usuario usuario = new Usuario(user, contra);

        UsuarioDAO uDAO = new UsuarioDAO();
        
        

        try {
            ArrayList<Usuario> usuarios = uDAO.getUnUsuario(usuario);
            ArrayList<Usuario> usuariosall = uDAO.getUsuarios();

            if (usuarios.isEmpty()) {
                request.getRequestDispatcher("html/index.html").forward(request, response);
            } else {
                HttpSession miSesion = request.getSession();
                miSesion.setAttribute("userName", user);
                miSesion.setAttribute("contrasena", contra);
                miSesion.setAttribute("cantidad", "10");

                miSesion.setAttribute("usuarios", usuarios);
                miSesion.setAttribute("usuariosall", usuariosall);

                response.addHeader("cache-control", "no-cache");

                PublicacionDAO pDAO = new PublicacionDAO();
                ArrayList<Publicacion> publicaciones = pDAO.get5PublicacionesPorDefecto();
                request.setAttribute("publicaciones", publicaciones);

                ComentarioDAO cDAO = new ComentarioDAO();                
                ArrayList<Comentario> comentarios = cDAO.getAllComentarios();
                request.setAttribute("comentarios", comentarios);
                
                VotoDAO vDAO = new VotoDAO();
                ArrayList<Voto> votos = vDAO.getAllVotos();
                request.setAttribute("votos", votos);

//                request.getRequestDispatcher("html/home.jsp").forward(request, response);
                request.getRequestDispatcher("html/home.jsp").forward(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
