package DAO;

import VO.BeanTaller;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import UTIL.Conexion;
import VO.bean;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoTaller extends Conexion {

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet comando = null;
    private PreparedStatement prepa = null;
    private String niTaller, telefono, idDueño, noRegistro;
    private String nombreTaller, correo, direccion, certificadoEmpresa, categoria, calificacion, logo, latitud, longitud;
    private boolean validar = false;

    public DaoTaller(BeanTaller bn) {
        super();
        try {

            niTaller = bn.getNiTaller();
            nombreTaller = bn.getNombreTaller();
            noRegistro = bn.getNoRegistro();
            telefono = bn.getTelefono();
            correo = bn.getCorreo();
            direccion = bn.getDireccion();
            idDueño = bn.getIdDueno();
            certificadoEmpresa = bn.getCertificadoEmpresa();
            categoria = bn.getCategoria();
            calificacion = bn.getCalificacion();
            logo = bn.getLogo();
            latitud = bn.getLatitud();
            longitud = bn.getLongitud();
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();

        } catch (Exception e) {
            System.out.println("Error registrar "+e);
        }
    }

    public DaoTaller() {
        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();
        } catch (SQLException e) {
            Logger.getLogger(DaoTaller.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public Boolean CrearTaller() {
        boolean men = false;

        try {

            String query = "CALL InsertarTaller(?,?,?,?,?,?,?,?,?,?,?,?)";
            prepa = conexion.prepareStatement(query);
            prepa.setString(1, niTaller);
            prepa.setString(2, nombreTaller);
            prepa.setString(3, telefono);
            prepa.setString(4, correo);
            prepa.setString(5, direccion);
            prepa.setString(6, idDueño);
            prepa.setString(7, certificadoEmpresa);
            prepa.setString(8, categoria);
            prepa.setString(9, calificacion);
            prepa.setString(10, logo);
            prepa.setString(11, latitud);
            prepa.setString(12, longitud);
            prepa.execute();

            this.cerrarConexion();

            men = true;

        } catch (SQLException e) {
            System.out.println("Error taller "+e);

         
        }
        return men;

    }

    public boolean ActualizarTaller() {
        boolean valido = false;
        try {
            String sql = "CALL ActualizarTaller(?,?,?,?,?,?,?)";
            prepa = conexion.prepareStatement(sql);
            prepa.setString(1, niTaller);
            prepa.setString(2, nombreTaller);
            prepa.setString(3, telefono);
            prepa.setString(4, correo);
            prepa.setString(5, direccion);
            prepa.setString(6, categoria);
            prepa.setString(7, calificacion);

            prepa.execute();
            System.out.println(sql);
            this.cerrarConexion();
            valido = true;

        } catch (SQLException e) {
            Logger.getLogger(DAOnotificacion.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e);
        }
        return valido;
    }

    public static BeanTaller consultarDatosTaller(String niTaller) {

        //declarar bean vehiculo , le ponemos apodo e iniciamos en nulo no tiene interacion con lo de afuera
        BeanTaller bDatos = null;

        try {
            Conexion conexion = new Conexion();
            Connection conn = conexion.obtenerConexion();
            Statement puente = conn.createStatement();
            ResultSet rs = puente.executeQuery("select * from taller where nitTaller='" + niTaller + "'");
            while (rs.next()) {

                bDatos = new BeanTaller(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13));
            }
            rs.close();
            puente.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bDatos;

    }

    public static BeanTaller consultarTaller(String idPropietario) {

        //declarar bean vehiculo , le ponemos apodo e iniciamos en nulo no tiene interacion con lo de afuera
        BeanTaller bDatos = null;

        try {
            Conexion conexion = new Conexion();
            Connection conn = conexion.obtenerConexion();
            Statement puente = conn.createStatement();
            ResultSet rs = puente.executeQuery("select * from taller where idDueño='" + idPropietario + "'");
            while (rs.next()) {

                bDatos = new BeanTaller(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13));
            }
            rs.close();
            puente.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bDatos;

    }
    
    
    public ArrayList<BeanTaller> consultarTalleres(String niTaller) {

        ArrayList<BeanTaller> consultarTaller = new ArrayList<BeanTaller>();

        try {   

            puente = conexion.createStatement();
            comando = puente.executeQuery("Select*from taller where nitTaller='" + niTaller + "';");

            while (comando.next()) {

                niTaller = comando.getString("nitTaller");
                String nombreTaller = comando.getString("nombreTaller");
                String noRegistro = comando.getString("noRegistro");
                String telefono = comando.getString("telefono");
                String correo = comando.getString("correo");
                String direccion = comando.getString("direccion");
                String idDueno = comando.getString("idDueño");
                String certificadoEmpresa = comando.getString("certificadoEmpresa");
                String categoria = comando.getString("categoria");
                String calificacion = comando.getString("calificacion");
                String logo = comando.getString("logo");
                String latitud = comando.getString("lat");
                String longitud = comando.getString("longi");
                BeanTaller bP = new BeanTaller(niTaller, null, telefono, idDueno, nombreTaller, correo, direccion, certificadoEmpresa, categoria, calificacion, logo, latitud, longitud);
                consultarTaller.add(bP);

            }
            if (consultarTaller.isEmpty()) {
                this.cerrarConexion();
            }

        } catch (SQLException e) {
            System.out.println("Error buscar "+e);
        }
        return consultarTaller;
    }

    public ArrayList<BeanTaller> consultaTalleres() {

        ArrayList<BeanTaller> consultarTaller = new ArrayList<BeanTaller>();

        try {

            puente = conexion.createStatement();
            comando = puente.executeQuery("Select*from taller");

            while (comando.next()) {

                niTaller = comando.getString("nitTaller");
                String nombreTaller = comando.getString("nombreTaller");
                String noRegistro = comando.getString("noRegistro");
                String telefono = comando.getString("telefono");
                String correo = comando.getString("correo");
                String direccion = comando.getString("direccion");
                String idDueno = comando.getString("idDueño");
                String certificadoEmpresa = comando.getString("certificadoEmpresa");
                String categoria = comando.getString("categoria");
                String calificacion = comando.getString("calificacion");
                String logo = comando.getString("logo");
                String latitud = comando.getString("lat");
                String longitud = comando.getString("longi");
                BeanTaller bP = new BeanTaller(niTaller, null, telefono, idDueno, nombreTaller, correo, direccion, certificadoEmpresa, categoria, calificacion, logo, latitud, longitud);
                consultarTaller.add(bP);

            }
            if (consultarTaller.isEmpty()) {
                this.cerrarConexion();
            }

        } catch (SQLException e) {
            Logger.getLogger(DAOnotificacion.class.getName()).log(Level.SEVERE, null, e);
        }
        return consultarTaller;
    }

    public boolean IniciarSesion(String niTaller, String clave) {
        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();
            CallableStatement procedimiento = conexion.prepareCall("{CALL ValidarTaller(?,?)}");
            procedimiento.setString(1, niTaller);
            procedimiento.setString(2, clave);
            procedimiento.execute();
            final ResultSet ms = procedimiento.getResultSet();
            if (ms.next()) {
                validar = true;
            }
            this.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Error IniciarSesion: " + e.toString());
        }
        return validar;
    }

    public static BeanTaller consultarUsuario(String niTaller, String identificacion) {
        BeanTaller vo = null;

        try {

            Conexion conexionBD = new Conexion();
            Connection conexion = conexionBD.obtenerConexion();
            Statement puente = conexion.createStatement();
            ResultSet mensajero = puente.executeQuery("select * from taller where nitTaller= '" + niTaller + "' and idDueño = '"+identificacion+"'");

            while (mensajero.next()) {

                vo = new BeanTaller();

                vo.setNiTaller(niTaller);
                vo.setNombreTaller(mensajero.getString("nombreTaller"));
                vo.setTelefono(mensajero.getString("telefono"));
                vo.setCorreo(mensajero.getString("correo"));
                vo.setDireccion(mensajero.getString("direccion"));
                vo.setCategoria(mensajero.getString("categoria"));
                vo.setCalificacion(mensajero.getString("calificacion"));
                vo.setLogo(mensajero.getString("logo"));

            }
            mensajero.close();
            puente.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("¡Error!" + e.toString());
        }
        return vo;
    }

    public ArrayList<BeanTaller> historialAlarmas(String id) {
        String sql = "CALL historialAlarmas(?)";
        ArrayList<BeanTaller> historialalarmas = new ArrayList<BeanTaller>();

        try {

            prepa = conexion.prepareStatement(sql);
            prepa.setString(1, id);
            comando = prepa.executeQuery();

            while (comando.next()) {
                BeanTaller bean = new BeanTaller();
                bean.setNombre(comando.getString("c.nombre"));
                bean.setApellido(comando.getString("c.apellidos"));
                bean.setNombreTaller(comando.getString("t.nombreTaller"));
                bean.setFecha(comando.getString("a.fecha"));
                bean.setDireccion(comando.getString("t.direccion"));
                bean.setIdAlarma(comando.getString("a.IdAlarma"));
              
                
                historialalarmas.add(bean);
            }
            comando.close();
            prepa.close();
            comando.close();

        } catch (SQLException e) {
            Logger.getLogger(DAOnotificacion.class.getName()).log(Level.SEVERE, null, e);
        }
        return historialalarmas;

    }
    
    public ArrayList<BeanTaller> historialAlarmasAceptadas(String id) {
        String sql = "CALL historialAlarmasAceptadas(?)";
        ArrayList<BeanTaller> historialalarmas = new ArrayList<BeanTaller>();

        try {

            prepa = conexion.prepareStatement(sql);
            prepa.setString(1, id);
            comando = prepa.executeQuery();

            while (comando.next()) {
                BeanTaller bean = new BeanTaller();
                bean.setNombre(comando.getString("c.nombre"));
                bean.setApellido(comando.getString("c.apellidos"));
                bean.setNombreTaller(comando.getString("t.nombreTaller"));
                bean.setFecha(comando.getString("a.fecha"));
                bean.setDireccion(comando.getString("t.direccion"));
                bean.setIdAlarma(comando.getString("a.IdAlarma"));
                  bean.setLatitud(comando.getString("t.lat"));
                bean.setLongitud(comando.getString("t.longi"));

                historialalarmas.add(bean);
            }
            comando.close();
            prepa.close();
            comando.close();

        } catch (SQLException e) {
            Logger.getLogger(DAOnotificacion.class.getName()).log(Level.SEVERE, null, e);
        }
        return historialalarmas;

    }
    
     public ArrayList<BeanTaller> BuscarTalleres(String idDueño) {

        ArrayList<BeanTaller> consultarTaller = new ArrayList<BeanTaller>();

        try {

            puente = conexion.createStatement();
            comando = puente.executeQuery("Select*from taller where idDueño = '"+ idDueño +"' ");

            while (comando.next()) {

                niTaller = comando.getString("nitTaller");
                String nombreTaller = comando.getString("nombreTaller");
                String noRegistro = comando.getString("noRegistro");
                String telefono = comando.getString("telefono");
                String correo = comando.getString("correo");
                String direccion = comando.getString("direccion");
                String idDueno = comando.getString("idDueño");
                String certificadoEmpresa = comando.getString("certificadoEmpresa");
                String categoria = comando.getString("categoria");
                String calificacion = comando.getString("calificacion");
                String logo = comando.getString("logo");
                String latitud = comando.getString("lat");
                String longitud = comando.getString("longi");
                BeanTaller bP = new BeanTaller(niTaller, null, telefono, idDueno, nombreTaller, correo, direccion, certificadoEmpresa, categoria, calificacion, logo, latitud, longitud);
                consultarTaller.add(bP);

            }
            if (consultarTaller.isEmpty()) {
                this.cerrarConexion();
            }

        } catch (SQLException e) {
            Logger.getLogger(DAOnotificacion.class.getName()).log(Level.SEVERE, null, e);
        }
        return consultarTaller;
    }
    
    
}
