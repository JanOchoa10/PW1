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
//@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
//        maxFileSize = 1024 * 1024 * 10,  // 10MB
//        maxRequestSize = 1024 * 1024 * 50)  // 50MB
public class Registro extends HttpServlet {

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
            out.println("<title>Servlet Registro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Registro at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        request.getRequestDispatcher("html/login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        //response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String nombre = request.getParameter("names");
        String apePaterno = request.getParameter("lastNameP");
        String apeMaterno = request.getParameter("lastNameM");
        String fecNacimiento = request.getParameter("birthday");
        String email = request.getParameter("email");
        String userName = request.getParameter("username");
        String contra = request.getParameter("password1");
        String userImagen = request.getParameter("imagenSubida");
//        String activo = request.getParameter("username");
//        String fechaDeCreacion = request.getParameter("username");
//        String fechaDeCambio = request.getParameter("username");
//        Date fecNacimiento = null;  
//        try {
//            fecNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse("29/10/2002");
//        } catch (ParseException ex) {
//            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        PrintWriter out = response.getWriter();
//        Part part = request.getPart("imagenSubida");
//        String fileName = extractFileName(part);
//        String savePath = "C:\\Users\\Jan\\Documents\\GitHub\\pw1\\src\\main\\webapp\\img\\" + File.separator + fileName;
//        File fileSaveDir = new File(savePath);
//        part.write(savePath + File.separator);

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

        Usuario usuario = new Usuario(nombre, apePaterno, apeMaterno, fecNacimiento, email, userName, contra, userImagen, 1, timeStamp, timeStamp);

        UsuarioDAO uDAO = new UsuarioDAO();

        try {
            boolean result = uDAO.agregar(usuario);

            if (result) {
                // processRequest(request, response);
                request.getRequestDispatcher("html/login.jsp").forward(request, response);
            }

            // Revisar que le usuario exista
            //response.sendRedirect("Vistas/principal.jsp");
            //request.setAttribute("id", 1);
            //request.getRequestDispatcher("principal.jsp").forward(request, response);
            //processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

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

//    private String extractFileName(Part part) {
//        String contentDisp = part.getHeader("content-disposition");
//        String[] items = contentDisp.split(";");
//        for (String s : items) {
//            if (s.trim().startsWith("filename")) {
//                return s.substring(s.indexOf("=") + 2, s.length() - 1);
//            }
//        }
//        return "";
//    }

}
