/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.UsuarioDAO;
import Modelos.Usuario;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

/**
 *
 * @author Jan
 */
@WebServlet(name = "Registro2", urlPatterns = {"/Registro2"})
public class Registro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        request.getRequestDispatcher("html/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String nombre = request.getParameter("names");
        String apePaterno = request.getParameter("lastNameP");
        String apeMaterno = request.getParameter("lastNameM");
        String fecNacimiento = request.getParameter("birthday");
        String email = request.getParameter("email");
        String userName = request.getParameter("username");
        String contra = request.getParameter("password1");
        String userImagen = request.getParameter("imagenSubida");

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

        Usuario usuario = new Usuario(nombre, apePaterno, apeMaterno, fecNacimiento, email, userName, contra, userImagen, 1, timeStamp, timeStamp);

        UsuarioDAO uDAO = new UsuarioDAO();

        try {
            ArrayList<Usuario> usuariosall = uDAO.getUsuarios();

            boolean existe = false;
            for (int i = 0; i < usuariosall.size(); i++) {
                if (usuariosall.get(i).getUserName().equals(userName)) {
                    existe = true;
                    break;
                }
            }

            if (!existe) {
                boolean result = uDAO.agregar(usuario);

                if (result) {
                    request.getRequestDispatcher("html/successRegistro.jsp").forward(request, response);
                }
            } else {
                request.getRequestDispatcher("html/errorRegistro.jsp").forward(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
