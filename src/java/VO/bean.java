package VO;

public class bean {

    private String idAlarma, fecha, categoriaTaller, idCliente, estado, lat, lon;

    public bean(String idAlarma, String fecha, String categoriaTaller, String idCliente, String estado, String lat, String lon) {
        this.idAlarma = idAlarma;
        this.fecha = fecha;
        this.categoriaTaller = categoriaTaller;
        this.idCliente = idCliente;
        this.estado = estado;
        this.lat = lat;
        this.lon = lon;
    }

    public String getIdAlarma() {
        return idAlarma;
    }

    public void setIdAlarma(String idAlarma) {
        this.idAlarma = idAlarma;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCategoriaTaller() {
        return categoriaTaller;
    }

    public void setCategoriaTaller(String categoriaTaller) {
        this.categoriaTaller = categoriaTaller;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public bean() {
    }

}
