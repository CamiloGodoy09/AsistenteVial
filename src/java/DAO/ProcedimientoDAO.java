/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.ProcedimientoVO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import UTIL.Conexion;
import UTIL.InterfaceCrud;
import java.sql.PreparedStatement;

public class ProcedimientoDAO extends Conexion implements InterfaceCrud {

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;
    private PreparedStatement pst = null;

    private String idHistorial = "";
    private String tipoProcedimiento = "";
    private String procedimiento = "";
    private String costos = "";
    private boolean operacion = false;

    public ProcedimientoDAO(ProcedimientoVO procedimientoVO) {
        super();

        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();

            idHistorial = procedimientoVO.getIdHistorial();
            tipoProcedimiento = procedimientoVO.getTipoProcedimiento();
            procedimiento = procedimientoVO.getProcedimiento();
            costos = procedimientoVO.getCostos();

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    @Override
    public boolean AgregarRegistro() {

        try {
            CallableStatement prepa = conexion.prepareCall("call insertarProcedimiento(?,?,?,?)");
            prepa.setString(1, idHistorial);
            prepa.setString(2, tipoProcedimiento);
            prepa.setString(3, procedimiento);
            prepa.setString(4, costos);

            try {
                prepa.execute();
                operacion = true;
            } catch (Exception e) {
                System.out.println("error Procedimiento " + e);
            }
        } catch (Exception e) {
            System.out.println("Error procedure" + e.toString());
        }
        return operacion;
    }

    @Override
    public boolean ActualizarRegistro() {
        try {
            CallableStatement prepa = conexion.prepareCall("{call actualizarPropietario(?,?,?,?,?)}");
            prepa.setString(1, idHistorial);
            prepa.setString(3, tipoProcedimiento);
            prepa.setString(4, procedimiento);
            prepa.setString(5, costos);

            operacion = true;
            try {
                prepa.execute();
            } catch (Exception e) {
                System.out.println("errorProcedimiento" + e);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return operacion;
    }

}
