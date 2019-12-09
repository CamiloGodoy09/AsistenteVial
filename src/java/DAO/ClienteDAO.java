package DAO;

import UTIL.Conexion;
import UTIL.InterfaceCrud;
import VO.ClienteVO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
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

public class ClienteDAO extends Conexion implements InterfaceCrud {

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;
    private PreparedStatement pst = null;

    private String nombre = "";
    private String apellidos = "";
    private String idCliente = "";
    private String fechaNacimiento = "";
    private String genero = "";
    private String correo = "";
    private String telefono = "";
    private String usuario = "";
    private String clave = "";

    private boolean operacion = false;

    public ClienteDAO(ClienteVO clienteVO) {
        super();

        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();

            nombre = clienteVO.getNombre();
            apellidos = clienteVO.getApellidos();
            idCliente = clienteVO.getIdCliente();
            fechaNacimiento = clienteVO.getFechaNacimiento();
            genero = clienteVO.getGenero();
            correo = clienteVO.getCorreo();
            telefono = clienteVO.getTelefono();
            usuario = clienteVO.getUsuario();
            clave = clienteVO.getClave();

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

    }

    @Override
    public boolean AgregarRegistro() {

        try {
            CallableStatement prepa = conexion.prepareCall("{call insertarCliente(?,?,?,?,?,?,?,?,?)}");
            prepa.setString(1, nombre);
            prepa.setString(2, apellidos);
            prepa.setString(3, idCliente);
            prepa.setString(4, fechaNacimiento);
            prepa.setString(5, genero);
            prepa.setString(6, correo);
            prepa.setString(7, telefono);
            prepa.setString(8, usuario);
            prepa.setString(9, clave);

            prepa.execute();
            operacion = true;
        } catch (Exception e) {
            System.out.println("errorProcedimiento" + e);
        }
        return operacion;
    }

    @Override
    public boolean ActualizarRegistro() {
        try {
            CallableStatement prepa = conexion.prepareCall("{call actualizarCliente(?,?,?,?,?,?,?,?,?)}");
            prepa.setString(1, nombre);
            prepa.setString(2, apellidos);
            prepa.setString(3, idCliente);
            prepa.setString(4, fechaNacimiento);
            prepa.setString(5, genero);
            prepa.setString(6, correo);
            prepa.setString(7, telefono);
            prepa.setString(8, usuario);
            prepa.setString(9, clave);

            prepa.execute();
            operacion = true;

        } catch (Exception e) {
            System.out.println("Error actualizar" + e.toString());
        }
        return operacion;
    }

    public boolean IniciarSesion(String idCliente, String clave) {
        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();
            CallableStatement procedimiento = conexion.prepareCall("{CALL ValidarUsuario(?,?)}");
            procedimiento.setString(1, idCliente);
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

    public int consultarId(String usuario, String clave) {
        int id = 0;
        String query = "CALL consultarIdUsuario(?,?)";
        try {
            pst = conexion.prepareStatement(query);
            pst.setString(1, usuario);
            pst.setString(2, clave);

            mensajero = pst.executeQuery();

            if (mensajero.next()) {

                id = mensajero.getInt(1);

            }

            this.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Error IniciarSesion: " + e.toString());
        }
        return id;
    }

    public boolean recuperarClave(String codigo, String clave, String usu) {

        try {
            puente.executeUpdate("UPDATE usuario usu INNER JOIN datospersonales dp on usu.USUID=dp.USUID SET usu.USUPASSWORD ='" + clave + "'  WHERE dp.DATCORREO='" + usu + "' AND usu.USUCODIGO='" + codigo + "';");
            operacion = true;
        } catch (Exception e) {
            Logger.getLogger(ClienteDAO.class
                    .getName()).log(Level.SEVERE, null, e);
        }
        return operacion;
    }

    public String buscarClave(String identificacion, String correo) {

        
        String clave = null;
        String query = "CALL buscarClave(?,?) ";
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

    public static ClienteVO consultarUsuario(String idCliente) {
        ClienteVO clientevo = null;

        try {

            Conexion conexionBD = new Conexion();
            Connection conexion = conexionBD.obtenerConexion();
            Statement puente = conexion.createStatement();
            ResultSet mensajero = puente.executeQuery("select * from cliente where idCliente = '" + idCliente + "'");

            while (mensajero.next()) {

                clientevo = new ClienteVO(mensajero.getString(2), mensajero.getString(3), idCliente, mensajero.getString(6),
                        mensajero.getString(7), mensajero.getString(8), mensajero.getString(9), mensajero.getString(10),
                        mensajero.getString(11), mensajero.getBytes(1));

            }
            mensajero.close();
            puente.close();

        } catch (Exception e) {
            System.out.println("¡Error!" + e.toString());
        }
        return clientevo;
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
            mail.setText("Buen día estimado conductor, Su clave de acceso es: "+mensaje+". "
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
