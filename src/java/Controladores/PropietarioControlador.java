package Controladores;

import DAO.PropietarioDAO;
import VO.PropietarioVO;
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
@WebServlet(name = "PropietarioControlador", urlPatterns = {"/Propietario"})
public class PropietarioControlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        PrintWriter out = response.getWriter();
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        String foto = null;
        String idPropietario = request.getParameter("txtid");
        String nombre = request.getParameter("txtnombre");
        String apellido = request.getParameter("txtapellido");
        String telefono = request.getParameter("txttelefono");
        String estado = request.getParameter("txtestado");
        String usuario = request.getParameter("txtusuario");
        String clave = request.getParameter("txtclave");
       
        PropietarioVO propieVO = new PropietarioVO(foto, idPropietario,nombre, apellido,telefono,estado, usuario, clave);
        PropietarioDAO propieDAO = new PropietarioDAO(propieVO);

        
        
        switch (opcion) {
            case 1:
                if (propieDAO.AgregarRegistro()) {
                    request.setAttribute("mensajeExitoso", "el USUARIO se registro correctamente");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {

                    request.setAttribute("mensajeError", "ERROR AL REGISTRAR USUARIO");
                    request.getRequestDispatcher("propietario.jsp").forward(request, response);
                }
                break;
                 case 2:
                if (propieDAO.ActualizarRegistro()) {
                    request.setAttribute("mensajeExitoso", "el USUARIO se actualizó correctamente");
                    request.getRequestDispatcher("actualizarPropietario.jsp").forward(request, response);
                } else {

                    request.setAttribute("mensajeError", "ERROR AL REGISTRAR USUARIO");
                    request.getRequestDispatcher("actualizarPropietario.jsp").forward(request, response);
                }
                break;
                
                  case 3:

                PropietarioVO propiVO = PropietarioDAO.consultarPropietario(idPropietario);
                if (propiVO != null) {
                    request.setAttribute("VoLleno", propiVO);
                    request.getRequestDispatcher("actualizarPropietario.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "¡EL VEHICULO NO EXISTE");
                    request.getRequestDispatcher("actualizarPropietario.jsp").forward(request, response);

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
    
