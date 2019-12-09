/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import VO.BeanTaller;
import DAO.DaoTaller;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
 * @author Tiiin
 */
@WebServlet(name = "controladorTaller", urlPatterns = {"/Taller"})
public class controladorTaller extends HttpServlet {

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
        String mensaje = "";
        try {

            String url = "C:\\Users\\junior\\Documents\\NetBeansProjects\\ProyectoIndividual\\proyectos\\nocomite(1)\\nocomite\\nocomite\\Propietario\\web\\assets\\images";
            FileItemFactory file_factory = new DiskFileItemFactory();
            ServletFileUpload servlet_up = new ServletFileUpload(file_factory);
            List items = servlet_up.parseRequest(request);
            HashMap<String, String> parametros = new HashMap<String, String>();
            for (int i = 0; i < items.size(); i++) {
                FileItem item = (FileItem) items.get(i);
                String valor = "";
                if (item.isFormField()) {
                    valor = item.getString();
                } else {
                    valor = (new Date().getTime()) + item.getName();
                    File archivo_server = new File(url + valor);
                    item.write(archivo_server);
                }
                parametros.put(item.getFieldName().toLowerCase(), valor);
            }

            BeanTaller bean = new BeanTaller();
            bean.setNiTaller(parametros.get("txtniTaller"));
            bean.setNombreTaller(parametros.get("txtnombreTaller"));
            bean.setTelefono(parametros.get("txttelefono"));
            bean.setCorreo(parametros.get("txtcorreo"));
            bean.setDireccion(parametros.get("txtdireccion"));
            bean.setIdDueno(parametros.get("txtiddueno"));
            bean.setCertificadoEmpresa(parametros.get("txtcertificadoEmpresa"));
            bean.setCategoria(parametros.get("txtcategoria"));
            bean.setCalificacion(parametros.get("txtcalificacion"));
            bean.setLogo(parametros.get("img"));
            bean.setLatitud(parametros.get("lat"));
            bean.setLongitud(parametros.get("longi"));

            DaoTaller dao = new DaoTaller(bean);
            dao.CrearTaller();

            request.setAttribute("exito", "Exito");
            request.getRequestDispatcher("registroTaller.jsp").forward(request, response);

        } catch (Exception e) {

            request.setAttribute("error", "Error");
            request.getRequestDispatcher("registroTaller.jsp").forward(request, response);
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
