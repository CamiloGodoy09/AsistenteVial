package DAO;


import UTIL.Conexion;
import UTIL.InterfaceCrud;
import VO.VehiculoVO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class VehiculoDAO extends Conexion implements InterfaceCrud {

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;

    private String tipoVehiculo = "";
    private String noPlaca = "";
    private String marca = "";
    private String modelo = "";
    private String idCliente = "";
    private String color = "";
    private String carroceria = "";
    private String servicio = "";
    private String cilindraje = "";
    private boolean operacion = false;
    private byte[] tarjetaPropiedad = null;

    public VehiculoDAO(VehiculoVO vehiculoVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();

            tipoVehiculo = vehiculoVO.getTipoVehiculo();
            noPlaca = vehiculoVO.getNoPlaca();
            marca = vehiculoVO.getMarca();
            modelo = vehiculoVO.getModelo();
            idCliente = vehiculoVO.getIdCliente();
            color = vehiculoVO.getColor();
            carroceria = vehiculoVO.getCarroceria();
            servicio = vehiculoVO.getServicio();
            cilindraje = vehiculoVO.getCilindraje();
            tarjetaPropiedad = vehiculoVO.getTarjetaPropiedad();
//   
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

    }

    @Override
    public boolean AgregarRegistro() {
        try {
            CallableStatement prepa = conexion.prepareCall("{call insertarVehiculo(?,?,?,?,?,?,?,?,?,?)}");
            prepa.setString(1, tipoVehiculo);
            prepa.setString(2, noPlaca);
            prepa.setString(3, marca);
            prepa.setString(4, modelo);
            prepa.setString(5, idCliente);
            prepa.setString(6, color);
            prepa.setString(7, carroceria);
            prepa.setString(8, servicio);
            prepa.setString(9, cilindraje);
            prepa.setBytes(10, tarjetaPropiedad);
            prepa.execute();
            operacion = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return operacion;
    }

    @Override
    public boolean ActualizarRegistro() {
        try {
            CallableStatement prepa = conexion.prepareCall("{call actualizarVehiculo(?,?,?,?,?,?,?,?,?,?)}");
            prepa.setString(1, tipoVehiculo);
            prepa.setString(2, noPlaca);
            prepa.setString(3, marca);
            prepa.setString(4, modelo);
            prepa.setString(5, idCliente);
            prepa.setString(6, color);
            prepa.setString(7, carroceria);
            prepa.setString(8, servicio);
            prepa.setString(9, cilindraje);
            prepa.setBytes(10, tarjetaPropiedad);
            operacion = true;
            prepa.execute();
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return operacion;
    }

    public static VehiculoVO consultarPlaca(String placa, String idCliente) {
        VehiculoVO vehiculoVO = null;

        try {

            Conexion conexionBD = new Conexion();
            Connection conexion = conexionBD.obtenerConexion();
            Statement puente = conexion.createStatement();
            ResultSet mensajero = puente.executeQuery("select * from vehiculo where noPlaca = '" + placa + "' and idCliente ='"+ idCliente +"'");

            while (mensajero.next()) {

                vehiculoVO = new VehiculoVO(mensajero.getString(1), placa, mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8), mensajero.getString(9), mensajero.getBytes(10));

            }
            mensajero.close();
            puente.close();

        } catch (Exception e) {
            System.out.println("¡Error!" + e.toString());
        }
        return vehiculoVO;

    }

}
