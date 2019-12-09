/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.ProcedimientoDAO;
import VO.ProcedimientoVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Procedimiento"})
public class ProcedimientoControlador extends HttpServlet {

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
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        String idHistorial = request.getParameter("txtid");
        String tipoProcedimiento = request.getParameter("txtTiprocedimiento");
        String procedimiento = request.getParameter("txtprocedimiento");
        String costos = request.getParameter("txtcostos");

        ProcedimientoVO proceVO = new ProcedimientoVO(tipoProcedimiento, procedimiento, costos, idHistorial);
        ProcedimientoDAO proceDAO = new ProcedimientoDAO(proceVO);

        switch (opcion) {
            case 1:
                if (proceDAO.AgregarRegistro()) {
                    request.setAttribute("mensajeExitoso", "el USUARIO se registro correctamente");
                    request.getRequestDispatcher("procedimiento.jsp").forward(request, response);
                } else {
                         request.setAttribute("mensajeError", "ERROR AL REGISTRAR PROCEDIMIENTO");
                    request.getRequestDispatcher("procedimiento.jsp").forward(request, response);
               
                }

                break;

            case 2:
                if (proceDAO.ActualizarRegistro()) {
                    request.setAttribute("mensajeExitoso", "el USUARIO se actualizó correctamente");
                    request.getRequestDispatcher("procedimiento.jsp").forward(request, response);
                } else {

                    request.setAttribute("mensajeError", "ERROR AL REGISTRAR USUARIO");
                    request.getRequestDispatcher("procedimiento.jsp").forward(request, response);
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
