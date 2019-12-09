/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.DaoTaller;
import VO.BeanTaller;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author junior
 */
@WebServlet(name = "RegistroTallerControlador", urlPatterns = {"/RegistroTaller"})
public class RegistroTallerControlador extends HttpServlet {

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

        String niTaller = request.getParameter("nitTaller");
        String noRegistro = null;
        String nombreTaller = request.getParameter("txtnombreTaller");
        String telefono = request.getParameter("txttelefono");
        String correo = request.getParameter("txtcorreo");
        String direccion = request.getParameter("txtdireccion");
        String idDueño = request.getParameter("txtiddueno");
        String certificadoEmpresa = request.getParameter("txtcertificadoEmpresa");
        String categoria = request.getParameter("txtcategoria");
        String calificacion = request.getParameter("txtcalificacion");
        String logo = request.getParameter("img");
        String latitud = request.getParameter("lat");
        String longitud = request.getParameter("longi");

        BeanTaller bean = new BeanTaller(niTaller, noRegistro, telefono, idDueño, nombreTaller,
                correo, direccion, certificadoEmpresa, categoria, calificacion, logo, latitud, longitud);

        DaoTaller dao = new DaoTaller(bean);
        if (dao.CrearTaller()) {

            request.setAttribute("exito", "Exito");
            request.getRequestDispatcher("registroTaller.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Error");
            request.getRequestDispatcher("registroTaller.jsp").forward(request, response);
        }

//
//        try {
//
//            String url = "C:\\Users\\junior\\Documents\\NetBeansProjects\\ProyectoIndividual\\proyectos\\nocomite (1)\\nocomite\\nocomite\\Propietario\\web\\assets\\images";
//            FileItemFactory file_factory = new DiskFileItemFactory();
//            ServletFileUpload servlet_up = new ServletFileUpload(file_factory);
//            List items = servlet_up.parseRequest(request);
//            HashMap<String, String> parametros = new HashMap<String, String>();
//            for (int i = 0; i < items.size(); i++) {
//                FileItem item = (FileItem) items.get(i);
//                String valor = "";
//                if (item.isFormField()) {
//                    valor = item.getString();
//                } else {
//                    valor = (new Date().getTime()) + item.getName();
//                    File archivo_server = new File(url + valor);
//                    item.write(archivo_server);
//                }
//                parametros.put(item.getFieldName().toLowerCase(), valor);
//            }
//
//        } catch (Exception e) {
//
//            request.setAttribute("error", "Error");
//            request.getRequestDispatcher("registroTaller.jsp").forward(request, response);
//        }
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
