package Controladores;

import VO.BeanTaller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import VO.bean;
import DAO.DAOnotificacion;
import DAO.DaoTaller;
import java.util.ArrayList;

/**
 *
 * @author Tiiin
 */
@WebServlet(name = "controlador", urlPatterns = {"/controlador"})

public class controladorAlarma extends HttpServlet {

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
        response.setContentType("text/plain");
        String action = request.getParameter("action");
        String value = request.getParameter("value");
        String fecha = "";
        String cat = "";
        String idC = "";
        String lat = "";
        String lon = "";
        String idAlarma="";
        ArrayList<String> mensaje = new ArrayList<String>();
        if (action.equals("consulta")) {
            bean bn = new bean();

            DAOnotificacion dn = new DAOnotificacion(bn);

            ArrayList<bean> list = dn.notificaciones();
            for (int i = 0; i < list.size(); i++) {
                bn = list.get(i);

                fecha = bn.getFecha();
                cat = bn.getCategoriaTaller();
                idC = bn.getIdCliente();
                lat = bn.getLat();
                lon = bn.getLon();
                idAlarma = bn.getIdAlarma();

                mensaje.add(fecha + "*" + cat + "*" + idC + "*" + lat + "*" + lon+ "*" + idAlarma);

            }

            out.print(mensaje);

        }
        if (action.equals("crearAlarma")) {

            bean bnA = new bean();
            bnA.setIdCliente(request.getParameter("idCliente"));
            bnA.setCategoriaTaller(request.getParameter("categoria"));
            bnA.setLat(request.getParameter("latitud"));
            bnA.setLon(request.getParameter("longitud"));
            DAOnotificacion dao = new DAOnotificacion(bnA);
            if (dao.Guardar(value)) {
                out.print("Se guardo");
            } else {
                out.print("NO");
            }

        }
        if (action.equals("aceptarAlarma")) {
            String id = request.getParameter("Alarma");
            bean beanss = new bean();
            beanss.setIdAlarma(id);
            DAOnotificacion daoos = new DAOnotificacion(beanss);
            if (daoos.aceptarAlarma()) {
                request.setAttribute("ErrorPropietario", "¡EL USUARIO NO EXISTE!");
            request.getRequestDispatcher("alarmas.jsp").forward(request, response);
                
            }
        }
        
         if (action.equals("alarmaAceptada")) {
            String id = request.getParameter("value");
            bean beanss = new bean();
            beanss.setIdCliente(id);
            DAOnotificacion daoos = new DAOnotificacion(beanss);
            String taller= daoos.alarmaAceptada();
            out.println(taller);
        }
           
         if (action.equals("alarmaAceptadaIn")) {
            String id = request.getParameter("value");
            bean beanss = new bean();
            beanss.setIdCliente(id);
            DAOnotificacion daoos = new DAOnotificacion(beanss);
            String taller= daoos.alarmaAceptadaIn();
            out.println(taller);
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
