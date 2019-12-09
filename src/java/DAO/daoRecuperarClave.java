/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import UTIL.Conexion;
import VO.VoRecuperarClave;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;
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
 * @author Tiiin
 */
public class daoRecuperarClave extends Conexion {

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;
    private PreparedStatement pst = null;

    private String correo = "";
    private String clave = "";
    private String usuario = "";

    private boolean operacion = false;
    private boolean listo = false;

    public daoRecuperarClave(VoRecuperarClave vo) {

        super();

        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();
            correo = vo.getCorreo();
            clave = vo.getClave();
            usuario = vo.getUsuario();

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

    }

    public int codigo() {
        Random rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());
        int aletorio = 136738 + rnd.nextInt(807865);
        return aletorio;
    }

    public void envioCorreo(String host, String puerto, String usuario,
            String clave, String destino, String v) throws AddressException, MessagingException, SQLException {

        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.host", host);
        propiedades.put("mail.smtp.port", puerto);
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");

        Authenticator autenticar = new Authenticator() {

            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, clave);
            }
        };

        Session sesion = Session.getInstance(propiedades, autenticar);

        Message msg = new MimeMessage(sesion);
        msg.setFrom(new InternetAddress(usuario));
        InternetAddress[] direcciones = {new InternetAddress(destino)};
        msg.setRecipients(Message.RecipientType.TO, direcciones);
        msg.setSubject("Código de recuperación");
        msg.setSentDate(new java.util.Date());
        int mensaje = codigo();

        String tabla = "";
        String sql = "";
        if (v.equals("Cliente")) {
            tabla = "cliente";
            sql = "UPDATE " + tabla + " usu  SET usu.codigo ='" + mensaje + "'  WHERE usu.correo='" + destino + "';";
        }
        if (v.equals("Taller")) {
            tabla = "taller";
            sql = "UPDATE " + tabla + " usu  SET usu.codigo ='" + mensaje + "'  WHERE usu.correo='" + destino + "';";
        }
        puente.executeUpdate(sql);

        msg.setText("Su código de verificacion es: " + Integer.toString(mensaje) + "\n \nCordialmente");

            Transport.send(msg);
    }

    public boolean recuperarClave(String codigo, String clave, String usu, String v) {
        String tabla = "";
        String sql = "";
        if (v.equals("Cliente")) {
            tabla = "cliente";
            sql = "UPDATE " + tabla + " usu SET usu.clave ='" + clave + "'  WHERE usu.correo='" + usu + "' AND usu.codigo='" + codigo + "';";
        }
        if (v.equals("Taller")) {
            tabla = "taller";
            sql = "UPDATE " + tabla + " usu INNER JOIN propietario p ON usu.idDueño=p.idDueño SET p.clave ='" + clave + "'  WHERE usu.correo='" + usu + "' AND usu.codigo='" + codigo + "';";
        }

        try {
            puente.executeUpdate(sql);

            listo = true;

        } catch (Exception e) {
            Logger.getLogger(daoRecuperarClave.class
                    .getName()).log(Level.SEVERE, null, e);
        }

        return listo;
    }
}
