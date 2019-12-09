package DAO;

import UTIL.Conexion;
import UTIL.InterfaceCrud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.nio.charset.StandardCharsets;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Base64;
import UTIL.config;
import VO.PropietarioVO;
import java.sql.CallableStatement;
import java.sql.Statement;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class daoLogin extends Conexion implements InterfaceCrud {

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;
    private boolean operacion = false;

    public daoLogin(PropietarioVO propietariovo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean AgregarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ActualizarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean IniciarSesion(String usuario, String clave) {
        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();
            CallableStatement procedimiento = conexion.prepareCall("{CALL ValidarPropietario(?,?)}");
            procedimiento.setString(1, usuario);
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
    
        

}
