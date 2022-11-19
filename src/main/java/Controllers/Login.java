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

            if (usuarios.isEmpty()) {
                request.getRequestDispatcher("html/index.html").forward(request, response);
            } else {
                HttpSession miSesion = request.getSession();
                miSesion.setAttribute("userName", user);
                miSesion.setAttribute("contrasena", contra);

                miSesion.setAttribute("usuarios", usuarios);

                response.addHeader("cache-control","no-cache");
                request.getRequestDispatcher("html/home.jsp").forward(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
