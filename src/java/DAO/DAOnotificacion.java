package DAO;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import UTIL.Conexion;
import VO.bean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOnotificacion extends Conexion {

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet comando = null;
    private PreparedStatement prepa = null;
    private String idAlarma, fecha, categoriaTaller, idCliente, estado, lat, lon;
    private boolean validar = false;

    public DAOnotificacion(bean bn) {
        super();
        try {
            idAlarma = bn.getIdAlarma();
            fecha = bn.getFecha();
            categoriaTaller = bn.getCategoriaTaller();
            idCliente = bn.getIdCliente();
            estado = bn.getEstado();
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();
            lat = bn.getLat();
            lon = bn.getLon();
        } catch (Exception e) {
            Logger.getLogger(DAOnotificacion.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    public ArrayList<bean> notificaciones() {

        ArrayList<bean> notificaciones = new ArrayList<bean>();

        try {

            puente = conexion.createStatement();
            comando = puente.executeQuery("Select * from alarmasactivas ac INNER JOIN historialalarmas ha ON ac.id=ha.IdAlarma WHERE ha.nitTaller = 1234;");

            while (comando.next()) {

                String fec = comando.getString("fecha");
                String categ = comando.getString("categoriaTaller");
                String idC = comando.getString("idCliente");
                String la = comando.getString("lat");
                String lo = comando.getString("lon");
                String id = comando.getString("id");
                bean bP = new bean(id, fec, categ, idC, null, la, lo);
                notificaciones.add(bP);

            }
            if (notificaciones.isEmpty()) {
                this.cerrarConexion();
            }

        } catch (SQLException e) {
            Logger.getLogger(DAOnotificacion.class.getName()).log(Level.SEVERE, null, e);
        }
        return notificaciones;
    }

    public boolean ActualizarRegistro(String id) {

        try {
            String sql = "CALL ActualizarAlarma(?,?)";
            prepa = conexion.prepareStatement(sql);
            prepa.setString(1, id);
            prepa.setString(2, "0");
            prepa.execute();
            this.cerrarConexion();
            prepa.close();
            validar = true;
        } catch (SQLException e) {
            Logger.getLogger(DAOnotificacion.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e);

        }
        return validar;
    }

    public boolean Guardar(String idTaller) {

        try {
            int idAlarma = 0;
            String query = "CALL InsertarAlarma(?,?,?,?)";
            prepa = conexion.prepareStatement(query);
            prepa.setString(1, idCliente);
            prepa.setString(2, categoriaTaller);
            prepa.setString(3, lat);
            prepa.setString(4, lon);
            prepa.execute();
            comando = puente.executeQuery("SELECT MAX(IdAlarma) FROM alarma");
            if (comando.next()) {
                idAlarma = comando.getInt(1);
            }
            if (idAlarma > 0) {

                String sql = "CALL RelacionTallerAlarma(?,?)";
                prepa = conexion.prepareStatement(sql);
                prepa.setInt(1, idAlarma);
                prepa.setString(2, idTaller);
                prepa.execute();

            }
            this.cerrarConexion();
            validar = true;

        } catch (Exception e) {

            Logger.getLogger(DAOnotificacion.class.getName()).log(Level.SEVERE, null, e);
        }
        return validar;

    }

    public boolean aceptarAlarma() {
        try {
            String sql = "CALL aceptarAlarma(?)";
            prepa = conexion.prepareStatement(sql);
            prepa.setString(1, idAlarma);
            prepa.execute();
            this.cerrarConexion();
            prepa.close();
            validar = true;
        } catch (SQLException e) {
            Logger.getLogger(DAOnotificacion.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e);

        }
        return validar;

    }

    public String alarmaAceptada() {
        String taller = "no rigistra";
        try {
            String sql = "CALL alarmaAceptada(?)";
            prepa = conexion.prepareStatement(sql);
            prepa.setString(1, idCliente);
            comando = prepa.executeQuery();
            while (comando.next()) {
                taller = comando.getString("nombreTaller");
            }
            this.cerrarConexion();
            prepa.close();
            comando.close();
            validar = true;
        } catch (SQLException e) {
            Logger.getLogger(DAOnotificacion.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e);

        }
        return taller;

    }
     public String alarmaAceptadaIn() {
        String taller = "";
        try {
            String sql = "CALL alarmaAceptadaIn(?)";
            prepa = conexion.prepareStatement(sql);
            prepa.setString(1, idCliente);
             prepa.execute();
       
            this.cerrarConexion();
            prepa.close();
            
            validar = true;
        } catch (SQLException e) {
            Logger.getLogger(DAOnotificacion.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e);

        }
        return taller;

    }

}
