/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.ClienteDAO;
import VO.ClienteVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author junior
 */
@WebServlet(name = "ValidarSesion", urlPatterns = {"/Validacion"})
public class ValidarSesion extends HttpServlet {

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
        String usuario = request.getParameter("txtusuario");
        String clave = request.getParameter("txtclave");

        ClienteVO clieVO = new ClienteVO(usuario, clave);
        ClienteDAO clieDAO = new ClienteDAO(clieVO);

        if (clieDAO.IniciarSesion(usuario, clave)) {
            ClienteDAO clieDAOs = new ClienteDAO(clieVO);

            int id = clieDAOs.consultarId(usuario, clave);

            HttpSession miSesion1 = request.getSession(true);  // abir sesion
            ClienteVO clienVO = new ClienteVO(usuario); // trae el usuario 
            miSesion1.setAttribute("validar", "true");
            miSesion1.setAttribute("clievo", clienVO);
            miSesion1.setAttribute("usuario", usuario);
            miSesion1.setAttribute("idusuario", id);

            request.getRequestDispatcher("menu.jsp").forward(request, response);

        } else {

            request.setAttribute("mensajeError", "EL USUARIO Y/O LA CONTRASEÑA SON INCORRECTAS");
            request.getRequestDispatcher("indexCliente.jsp").forward(request, response);

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
