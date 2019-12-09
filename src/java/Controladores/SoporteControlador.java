package Controladores;

import DAO.SoporteDAO;
import VO.SoporteVO;
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
@WebServlet(name = "SoporteControlador", urlPatterns = {"/Soporte"})
public class SoporteControlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        String idSoporte = null;
        String comentario = request.getParameter("txtcomentario");
        String idCliente = request.getParameter("idCliente");
        String usuario = request.getParameter("txtUsuario");
        SoporteVO soporVO = new SoporteVO(comentario, idCliente, idSoporte, usuario);
        SoporteDAO soporDAO = new SoporteDAO(soporVO);

    
    
                if (soporDAO.AgregarRegistro()) {
                    
                    request.setAttribute("mensajeExitoso", "el comentario fue enviado correctamente");
                    request.getRequestDispatcher("soporte.jsp").forward(request, response);

                } else {

                    request.setAttribute("mensajeError", "ERROR al enviar comentario");
                    request.getRequestDispatcher("soporte.jsp").forward(request, response);
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
