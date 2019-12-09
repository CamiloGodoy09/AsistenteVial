package DAO;

import VO.SoporteVO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import UTIL.Conexion;
import UTIL.InterfaceCrud;

/**
 *
 * @author Juan
 */
public class SoporteDAO extends Conexion implements InterfaceCrud {

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;

    private String idSoporte = "";
    private String idCliente = "";
    private String comentario = "";
    private String usuario = "";
    private boolean operacion = false;

    public SoporteDAO() {
    }

    public SoporteDAO(SoporteVO soporteVO) {
        super();

        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();

            idCliente = soporteVO.getIdCliente();
            comentario = soporteVO.getComentario();
            usuario = soporteVO.getUsuario();

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

    }

    @Override
    public boolean AgregarRegistro() {
        try {
            CallableStatement prepa = conexion.prepareCall("call insertarSoporte(?,?,?)");
            prepa.setString(1, idCliente);
            prepa.setString(2, comentario);
            prepa.setString(3, usuario);
            prepa.execute();
            operacion = true;

        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } 
        return operacion;
    }

    @Override
    public boolean ActualizarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
