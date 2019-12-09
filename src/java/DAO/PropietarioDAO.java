package DAO;

import VO.PropietarioVO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.PrePassivate;
import UTIL.Conexion;
import UTIL.InterfaceCrud;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Juan
 */
public class PropietarioDAO extends Conexion implements InterfaceCrud {

    Conexion cn = new Conexion();
    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;
    CallableStatement Prepa;
    private PreparedStatement pst = null;

    private String foto = "";
    private String idPropietario = "";
    private String nombre = "";
    private String apellido = "";
    private String telefono = "";
    private String estado = "";
    private String usuario = "";
    private String clave = "";
    private boolean operacion = false;

    public PropietarioDAO(PropietarioVO propietarioVO) {
        super();

        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();

            foto = propietarioVO.getFoto();
            idPropietario = propietarioVO.getIdPropietario();
            nombre = propietarioVO.getNombre();
            apellido = propietarioVO.getApellido();
            telefono = propietarioVO.getTelefono();
            estado = propietarioVO.getEstado();
            usuario = propietarioVO.getUsuario();
            clave = propietarioVO.getClave();

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    @Override
    public boolean AgregarRegistro() {
//        try {
//            CallableStatement prepa = conexion.prepareCall("{call insertarPropietario(?,?,?,?,?,?,?,?)}");
//            prepa.setString(1, foto);
//            prepa.setString(2, idPropietario);
//            prepa.setString(3, nombre);
//            prepa.setString(4, apellido);
//            prepa.setString(5, telefono);
//            prepa.setString(6, estado);
//            prepa.setString(7, usuario);
//            prepa.setString(8, clave);
//
//            operacion = true;
//            try {
//                prepa.execute();
//            } catch (Exception e) {
//                System.out.println("errorProcedimiento" + e);
//            }
//        } catch (Exception e) {
//            System.out.println("Error" + e.toString());
//        }
        return operacion;
    }

    @Override
    public boolean ActualizarRegistro() {
        try {
            CallableStatement prepa = conexion.prepareCall("{call actualizarPropietario(?,?,?,?,?,?)}");
            
            prepa.setString(1, idPropietario);
            prepa.setString(2, nombre);
            prepa.setString(3, apellido);
            prepa.setString(4, telefono);
            prepa.setString(5, usuario);
            prepa.setString(6, clave);

            try {
                prepa.execute();
                operacion = true;
            } catch (Exception e) {
                System.out.println("error Procedimiento " + e);
            }
        } catch (Exception e) {
            System.out.println("Error--" + e.toString());
        }
        return operacion;
    }

    public ArrayList<PropietarioVO> listarPropietario() {

        Conexion conn = new Conexion();
        ArrayList<PropietarioVO> listaDatos = new ArrayList<>();

        try {

            Prepa = conn.obtenerConexion().prepareCall("call listarPropietario");
            mensajero = Prepa.executeQuery();

            while (mensajero.next()) {
                foto = mensajero.getString("foto");
                idPropietario = mensajero.getString("idPropietario");
                nombre = mensajero.getString("nombre");
                apellido = mensajero.getString("apellido");
                telefono = mensajero.getString("telefono");
                estado = mensajero.getString("estado");
                usuario = mensajero.getString("usuario");
                clave = mensajero.getString("clave");

                PropietarioVO propietarioVO = new PropietarioVO();

                propietarioVO.setIdPropietario(idPropietario);
                propietarioVO.setNombre(nombre);
                propietarioVO.setApellido(apellido);
                propietarioVO.setTelefono(telefono);
                propietarioVO.setEstado(estado);

                listaDatos.add(propietarioVO);

            }

        } catch (SQLException e) {

            System.out.println("Error" + e.toString());

        }

        return listaDatos;

    }

    
    
    
    public static PropietarioVO consultarPropietario(String idPropietario) {
        PropietarioVO propietarioVO = null;

        try {

            Conexion conexionBD = new Conexion();
            Connection conexion = conexionBD.obtenerConexion();
            Statement puente = conexion.createStatement();
            ResultSet mensajero = puente.executeQuery("select * from propietario where idDueño = '" + idPropietario + "'");

            while (mensajero.next()) {

                propietarioVO = new PropietarioVO(mensajero.getString(1), idPropietario, mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8));;

            }
            mensajero.close();
            puente.close();

        } catch (Exception e) {
            System.out.println("¡Error!" + e.toString());
        }
        return propietarioVO;

    }

    public boolean IniciarTaller(String idPropietario, String clave) {
        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();
            CallableStatement procedimiento = conexion.prepareCall("{CALL validarPropietario(?,?)}");
            procedimiento.setString(1, idPropietario);
            procedimiento.setString(2, clave);
            procedimiento.execute();
            final ResultSet ms = procedimiento.getResultSet();
            if (ms.next()) {
                operacion = true;
            }
            this.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Error IniciarSesion: " + e.toString());
        }
        return operacion;
    }

    public String consultarId(String usuario, String clave) {
        String id = null;
        Conexion cn = new Conexion();
        conexion = cn.obtenerConexion();
        String query = "select idDueño from propietario where usuario=? AND clave=?";
        try {
            pst = conexion.prepareStatement(query);
            pst.setString(1, usuario);
            pst.setString(2, clave);

            mensajero = pst.executeQuery();

            if (mensajero.next()) {

                id = mensajero.getString(1);
            }

            conexion.close();
            pst.close();
            mensajero.close();
        } catch (Exception e) {
            System.out.println("Error IniciarSesion: " + e.toString());
        }
        return id;
    }
    public String buscarClave(String identificacion, String correo) {

        
        String clave = null;
        String query = "CALL buscarClavePP(?,?) ";
        try {
            conexion = this.obtenerConexion();
            pst = conexion.prepareStatement(query);
            pst.setString(1, identificacion);
            pst.setString(2, correo);

            mensajero = pst.executeQuery();

            if (mensajero.next()) {

                clave = mensajero.getString("clave");

            }

            this.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Error Buscar clave: " + e.toString());
        }
        return clave;

    }
    
      public boolean recuperarClave(String destinatario, String mensaje) {
        boolean operacion = false;

        Properties propiedades = System.getProperties();
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.port", "587");
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");

        Authenticator autenticar = new Authenticator() {

            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, clave);
            }
        };

        Session sesion = Session.getInstance(propiedades, autenticar);
        String correo = "brayanalbeiroestrada@gmail.com";
        String contrasena = "estrada.2019";
        String asunto = "Recuperar Clave Asistente Vial";

        MimeMessage mail = new MimeMessage(sesion);
        try {

            mail.setFrom(new InternetAddress(correo));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            mail.setSubject(asunto);
            mail.setText("Buen día estimado Propietario, Su clave de acceso es: "+mensaje+". "
                    + "Gracias por preferirnos, de parte de Asistente vial le deseamos un feliz dia");

            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(correo, contrasena);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            operacion = true;
            transporte.close();

        } catch (AddressException ex) {
            System.out.println("Error correo " + ex);
        } catch (MessagingException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return operacion;
    }
    
}
