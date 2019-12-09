/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.DaoTaller;
import VO.BeanTaller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tiiin
 */
@WebServlet(name = "actualizarTaller", urlPatterns = {"/actualizarTaller"})
public class actualizarTaller extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        int opcion = 0;
        String niTaller = request.getParameter("txtid");
        
        String identificacion =request.getParameter("identificacion");
        String nombreTaller = request.getParameter("txtnombretaller");
        String telefono = request.getParameter("txttelefono");
        String correo = request.getParameter("txtcorreo");
        String direccion = request.getParameter("txtdireccion");
        String categoria = request.getParameter("txtcategoria");
        String calificacion = request.getParameter("txtcalificacion");
        
        
        
        BeanTaller vo = new BeanTaller();
        vo.setNiTaller(identificacion);
        vo.setNombreTaller(nombreTaller);
        vo.setTelefono(telefono);
        vo.setCorreo(correo);
        vo.setDireccion(direccion);
        vo.setCategoria(categoria);
        vo.setCalificacion(calificacion);
       
        DaoTaller dao = new DaoTaller(vo);
        opcion = Integer.parseInt(request.getParameter("opcion"));

        
        

        switch (opcion) {
            case 1:
                if (dao.ActualizarTaller()) {
                    request.setAttribute("mensajeExito", "DATOS ACTUALIZADOS CORRECTAMENTE");
                    request.getRequestDispatcher("actualizarTaller.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "ERROR AL ACTUALIZAR DATOS");
                    request.getRequestDispatcher("actualizarTaller.jsp").forward(request, response);
                }
                break;
                
            case 2:
                BeanTaller cVO = DaoTaller.consultarUsuario(niTaller,identificacion);
        if (cVO != null) {
            request.setAttribute("VoLleno", cVO);
            request.getRequestDispatcher("actualizarTaller.jsp").forward(request, response);
            request.setAttribute("usuarioValido", "USUARIO ENCONTRADO");
        } else {
            request.setAttribute("usuarioInvalido", "¡EL USUARIO NO EXISTE!");
            request.getRequestDispatcher("actualizarTaller.jsp").forward(request, response);
        }
        break;

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
        processRequest(request, response);
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
        processRequest(request, response);
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
