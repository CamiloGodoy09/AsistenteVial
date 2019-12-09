/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import VO.BeanTaller;
import DAO.DaoTaller;
import DAO.PropietarioDAO;
import DAO.daoLogin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import VO.PropietarioVO;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tiiin
 */
@WebServlet(name = "loginUsuarios", urlPatterns = {"/loginUsuarios"})
public class loginUsuarios extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String idPropietario = request.getParameter("txtid");
        String clave = request.getParameter("txtclave");

        PropietarioVO propietariovo = new PropietarioVO(idPropietario, clave);
        PropietarioDAO propietariodao = new PropietarioDAO(propietariovo);

        if (propietariodao.IniciarTaller(idPropietario, clave)) {
            PropietarioDAO propietaDAO = new PropietarioDAO(propietariovo);
            PropietarioVO propiVO = propietaDAO.consultarPropietario(idPropietario);
            BeanTaller tallervo = new BeanTaller();
            DaoTaller daotaller = new DaoTaller(tallervo);
            BeanTaller tallerdatos = daotaller.consultarTaller(idPropietario);
            ArrayList<BeanTaller> talleres = daotaller.BuscarTalleres(idPropietario);
            

            HttpSession miSesion = request.getSession(true);
            miSesion.setAttribute("validar", "true");
            miSesion.setAttribute("idusuario", idPropietario);
            miSesion.setAttribute("pvo", propiVO);
             miSesion.setAttribute("tallervo", talleres);
          
            request.getRequestDispatcher("menuTaller.jsp").forward(request, response);

        } else {

            request.setAttribute("mensajeError", "EL USUARIO Y/O LA CONTRASEÑA SON INCORRECTAS");
            request.getRequestDispatcher("indexTaller.jsp").forward(request, response);

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
