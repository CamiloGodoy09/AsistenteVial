/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import DAO.VehiculoDAO;
import VO.VehiculoVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author junior
 */
@WebServlet(name = "VehiculoControlador", urlPatterns = {"/Vehiculo"})
public class VehiculoControlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int opcion = Integer.parseInt(request.getParameter("opcion"));

        String tipoVehiculo = request.getParameter("txtTipo");
        String noPlaca = request.getParameter("txtplaca");
        String marca = request.getParameter("txtmarca");
        String modelo = request.getParameter("txtmodelo");
        String idCliente = request.getParameter("txtid");
        String color = request.getParameter("txtcolor");
        String carroceria = request.getParameter("txtcarroceria");
        String servicio = request.getParameter("txtservicio");
        String cilindraje = request.getParameter("txtcilindraje");
        String tarjeta = request.getParameter("tarjeta");
         byte[] tarjetaPropiedad = tarjeta.getBytes();

        VehiculoVO vehVO = new VehiculoVO(tipoVehiculo, noPlaca, marca, modelo, idCliente, color, carroceria, servicio, cilindraje, tarjetaPropiedad);
        VehiculoDAO vehDAO = new VehiculoDAO(vehVO);

        switch (opcion) {
            case 1:
                if (vehDAO.AgregarRegistro()) {

                    request.setAttribute("mensajeExito", "DATOS REGISTRADOS CORRECTAMENTE");
                    request.getRequestDispatcher("registroVehiculo.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "EL VEHICULO NO SE REGISTRO CORRECTAMENTE");
                    request.getRequestDispatcher("registroVehiculo.jsp").forward(request, response);
                }

                break;
            case 2:
                 if (vehDAO.ActualizarRegistro()) {
                   
                   request.setAttribute("mensajeExito", "SE ACTUALIZO EL VEHICULO");
                                     
               }else{
                   
                   request.setAttribute("mensajeError", "ERROR AL ACTUALIZAR VEHICULO");
               }
               
               request.getRequestDispatcher("actualizarVehiculo.jsp").forward(request, response);
               break;
                         
            case 3:
                
                VehiculoVO vVO = VehiculoDAO.consultarPlaca(noPlaca,idCliente); 
               if (vVO !=null) {
                   request.setAttribute("VoLleno", vVO);
                   request.getRequestDispatcher("actualizarVehiculo.jsp").forward(request, response);
                   
                                      
               }else{
                   request.setAttribute("mensajeError", "¡EL VEHICULO NO EXISTE");
                   request.getRequestDispatcher("actualizarVehiculo.jsp").forward(request, response);
                   
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
