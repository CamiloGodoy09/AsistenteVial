/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import VO.BeanTaller;
import VO.bean;
import DAO.DAOnotificacion;
import DAO.DaoTaller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tiiin
 */
@WebServlet(name = "controladors", urlPatterns = {"/controladors"})
public class controlador extends HttpServlet {

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

            String opcion = request.getParameter("opcion");
            String actualiza = request.getParameter("actualiza");
            String nitTaller = request.getParameter("nitTaller");

            if (opcion.equals("buscar")) {
                String id = request.getParameter("id");
                BeanTaller bean = new BeanTaller();
                DaoTaller dao = new DaoTaller(bean);
                ArrayList<BeanTaller> list = dao.consultarTalleres(id);
                String src = "";
                for (int i = 0; i < list.size(); i++) {
                    src = list.get(i).getNiTaller() + "!"
                            + list.get(i).getNombreTaller() + "!"
                            + list.get(i).getDireccion() + "!"
                            + list.get(i).getCorreo() + "!"
                            + list.get(i).getTelefono() + "!"
                            + list.get(i).getCategoria() + "!"
                            + list.get(i).getCalificacion() + "!"
                            + list.get(i).getIdDueno();

                }
                out.println(src);
            }

            if (actualiza.equals("actualizaEstado")) {

                bean BEAN = new bean();

                DAOnotificacion daO = new DAOnotificacion(BEAN);
                if (daO.ActualizarRegistro(nitTaller)) {
                    out.print("se ha cambiado la alarma");
                }
            }

            String niTaller = "";

            BeanTaller bn = new BeanTaller();
            DaoTaller dao = new DaoTaller(bn);

            if (dao.ActualizarTaller()) {
                request.setAttribute("id", niTaller);
                BeanTaller bDatoss = DaoTaller.consultarDatosTaller(niTaller);

                if (bDatoss != null) {
                    request.setAttribute("bDatos", bDatoss);
                    String mensajes = "<p style='background-color: #9CFF33;'>Se Actualizaron los datos</p>";
                    request.setAttribute("mensaje", mensajes);
                    // request.setAttribute("exito", "<script>alert('El usuario fue actualizado correctamente')</script>");
                    //request.getRequestDispatcher("actualizar_datospersonales.jsp").forward(request, response);

                }
            } else {
                request.setAttribute("error", "<script>alert('El usuario no pudo ser actualizado correctamente')</script>");
            }

            request.getRequestDispatcher("actualizar_datosTaller.jsp").forward(request, response);

            request.setAttribute("id", niTaller);
            BeanTaller bDatos = DaoTaller.consultarDatosTaller(niTaller);

            if (bDatos != null) {
                request.setAttribute("bDatos", bDatos);
                request.getRequestDispatcher("actualizar_datosTaller.jsp").forward(request, response);

            } else {
                request.setAttribute("error", "<script>alert('No se encontro datos')</script>");

                request.getRequestDispatcher("menuTaller.jsp").forward(request, response);
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
