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

/**
 *
 * @author Jan
 */
@WebServlet(name = "Página_Principal", urlPatterns = {"/Página_Principal"})
public class UsuarioController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuarioController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        int i=0;

        //Modelos.Usuario user = new Modelos.Usuario(i, nombre, contra);
        String nombre = request.getParameter("username");
        String contra = request.getParameter("password1");

        Usuario usuario = new Usuario(nombre, contra);

        UsuarioDAO uDAO = new UsuarioDAO();

        try {
            boolean result = uDAO.agregar(usuario);

            if (result) {
                processRequest(request, response);
            }

            // Revisar que le usuario exista
            //response.sendRedirect("Vistas/principal.jsp");
            //request.setAttribute("id", 1);
            //request.getRequestDispatcher("principal.jsp").forward(request, response);
            //processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        
//        UsuarioDAO uDAO = new UsuarioDAO();
//
//        try {
//            ArrayList<Usuario> usuarios = uDAO.getUsuarios();
//            
//            request.setAttribute("usuarios", usuarios);
//            
//            request.getRequestDispatcher("html/home.jsp").forward(request, response);
//        } catch (SQLException ex) {
//            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//        
//        //processRequest(request, response);
//    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("username");
        String contra = request.getParameter("password1");

        Usuario usuario = new Usuario(nombre, contra);

        UsuarioDAO uDAO = new UsuarioDAO();

        try {
            ArrayList<Usuario> usuarios = uDAO.getUnUsuario(usuario);

            if (usuarios.isEmpty()) { 
                request.getRequestDispatcher("html/index.html").forward(request, response);         
            } else {
                request.setAttribute("usuarios", usuarios);

                request.getRequestDispatcher("html/home.jsp").forward(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
