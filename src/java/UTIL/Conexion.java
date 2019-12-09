package UTIL;

import java.sql.*;

public class Conexion {

    public String driver, urlbd, user, password, bd;

    Connection conexion;

    public Conexion() {

        driver = "com.mysql.jdbc.Driver";
        bd = "siproyecto1";
        user = "root";
        password = "";
        urlbd = "jdbc:mysql://localhost:3306/" + bd;

        try {

            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(urlbd, user, password);

            System.out.println("¡Conexion OK!");

        } catch (Exception e) {

            System.out.println("Error al conectar la base de datos" + e);

        }

    }

    public Connection obtenerConexion() {
        return conexion;
    }

    public Connection cerrarConexion() throws SQLException {
        conexion.close();
        conexion = null;
        return conexion;

    }

    public static void main(String[] args) {
        new Conexion();
    }

}

//Tenga En Cuenta Que Antes De Que Correrlo Agregar Libreria "MySQL JDBC Driver"
