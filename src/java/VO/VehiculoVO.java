package VO;

/**
 *
 * @author junior
 */
public class VehiculoVO {
    private String tipoVehiculo;
    private String noPlaca;
    private String marca;
    private String modelo;
    private String idCliente;
    private String color;
    private String carroceria;
    private String servicio;
    private String cilindraje;
    private byte [] tarjetaPropiedad;

    public VehiculoVO(String noPlaca) {
        this.noPlaca = noPlaca;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getNoPlaca() {
        return noPlaca;
    }

    public void setNoPlaca(String noPlaca) {
        this.noPlaca = noPlaca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(String carroceria) {
        this.carroceria = carroceria;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public byte[] getTarjetaPropiedad() {
        return tarjetaPropiedad;
    }

    public void setTarjetaPropiedad(byte[] tarjetaPropiedad) {
        this.tarjetaPropiedad = tarjetaPropiedad;
    }
    
    

    public VehiculoVO() {
    }

    public VehiculoVO(String tipoVehiculo, String noPlaca, String marca, String modelo, String idCliente, String color, String carroceria, String servicio, String cilindraje, byte[] tarjetaPropiedad) {
        this.tipoVehiculo = tipoVehiculo;
        this.noPlaca = noPlaca;
        this.marca = marca;
        this.modelo = modelo;
        this.idCliente = idCliente;
        this.color = color;
        this.carroceria = carroceria;
        this.servicio = servicio;
        this.cilindraje = cilindraje;
        this.tarjetaPropiedad = tarjetaPropiedad;
    }
    

}
