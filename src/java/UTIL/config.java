package UTIL;

import java.sql.Connection;

public class config {

    public String driver, urlbd, user, pasword, bd;
    Connection conexion;

    public config() {
        driver = "com.mysql.jdbc.Driver";
        bd = "siproyecto";
        user = "root";
        pasword = "";
        urlbd = "jdbc:mysql://localhost:3306/" + bd;
    }

    public String getDriver() {
        return driver;
    }

    public String getUrlbd() {
        return urlbd;
    }

    public String getUser() {
        return user;
    }

    public String getPasword() {
        return pasword;
    }

    public String getBd() {
        return bd;
    }

    public Connection obtenerConexion() {
        return conexion;
    }
}
