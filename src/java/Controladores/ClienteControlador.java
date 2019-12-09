package Controladores;

import DAO.ClienteDAO;
import VO.ClienteVO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ClienteControlador", urlPatterns = {"/Cliente"})
public class ClienteControlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

//obtener variables de la sesión
//guarda todo como Object, el casteo es obligatorio
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        String nombre = request.getParameter("txtnombre");
        String apellidos = request.getParameter("txtapellidos");
        String idCliente = request.getParameter("txtid");
        String fechaNacimiento = request.getParameter("fecha");
        String genero = request.getParameter("txtgenero");
        String correo = request.getParameter("txtcorreo");
        String telefono = request.getParameter("telefono");
        String usuario = request.getParameter("txtusuario");
        String clave = request.getParameter("txtclave");
//      String imgfoto = request.getParameter("imgfoto");
        byte[] foto = null;
        ClienteVO clieVO = new ClienteVO(nombre, apellidos, idCliente, fechaNacimiento, genero, correo, telefono, usuario, clave, foto);
        ClienteDAO clieDAO = new ClienteDAO(clieVO);

        switch (opcion) {
            case 1:

                if (clieDAO.IniciarSesion(idCliente, clave)) {
                    ClienteDAO clieDAOs = new ClienteDAO(clieVO);
                    

                    HttpSession miSesion = request.getSession(true);  // abir sesion
                    ClienteVO clienVO =  clieDAOs.consultarUsuario(idCliente); // trae el usuario 
                    
         
                  

                    miSesion.setAttribute("validar", "true");
                    miSesion.setAttribute("clievo", clienVO);
                    miSesion.setAttribute("idusuario", idCliente);
                   

                    request.getRequestDispatcher("menu.jsp").forward(request, response);

                } else {

                    request.setAttribute("mensajeError", "EL USUARIO Y/O LA CONTRASEÑA SON INCORRECTAS");
                    request.getRequestDispatcher("indexCliente.jsp").forward(request, response);

                }

                break;

            case 2:
                if (request.getParameter("g-recaptcha-response").equals("") || request.getParameter("g-recaptcha-response") == null) {
                    request.setAttribute("recap", "DEBE SELECCIONAR CAPTCHA");
                    request.getRequestDispatcher("registroUsuario.jsp").forward(request, response);
                } else {

                    if (clieDAO.AgregarRegistro()) {

                        request.setAttribute("registroExitoso", "CORRECTAMENTE REGISTRADOS LOS DATOS");
                        request.getRequestDispatcher("indexCliente.jsp").forward(request, response);
                    } else {
                        request.setAttribute("mensajeError", "ERROR AL REGISTRAR USUARIO");
                        request.getRequestDispatcher("registroUsuario.jsp").forward(request, response);
                    }

                }
                break;

            case 3:
                if (clieDAO.ActualizarRegistro()) {
                    request.setAttribute("mensajeExito", "DATOS ACTUALIZADOS CORRECTAMENTE");
                    request.getRequestDispatcher("actualizarUsuario.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "ERROR AL ACTUALIZAR DATOS");
                    request.getRequestDispatcher("actualizarUsuario.jsp").forward(request, response);
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
