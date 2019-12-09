/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author Tiiin
 */
public class BeanTaller {

    private String niTaller, telefono, idDueno, noRegistro;
    private String nombre, apellido , fecha,idAlarma;
    private String nombreTaller, correo, direccion, certificadoEmpresa, categoria, calificacion, logo, latitud, longitud;

    public BeanTaller(String niTaller, String noRegistro, String telefono, String idDueno, String nombreTaller, String correo, String direccion, String certificadoEmpresa, String categoria, String calificacion, String logo, String latitud, String longitud) {
        this.niTaller = niTaller;
        this.nombreTaller = nombreTaller;
        this.noRegistro = noRegistro;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.idDueno = idDueno;
        this.certificadoEmpresa = certificadoEmpresa;
        this.categoria = categoria;
        this.calificacion = calificacion;
        this.logo = logo;
        this.latitud = latitud;
        this.longitud = longitud;
    }
    

    public String getNiTaller() {
        return niTaller;
    }

    public void setNiTaller(String niTaller) {
        this.niTaller = niTaller;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdDueno() {
        return idDueno;
    }

    public void setIdDueno(String idDueno) {
        this.idDueno = idDueno;
    }

    public String getNoRegistro() {
        return noRegistro;
    }

    public void setNoRegistro(String noRegistro) {
        this.noRegistro = noRegistro;
    }

    public String getNombreTaller() {
        return nombreTaller;
    }

    public void setNombreTaller(String nombreTaller) {
        this.nombreTaller = nombreTaller;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCertificadoEmpresa() {
        return certificadoEmpresa;
    }

    public void setCertificadoEmpresa(String certificadoEmpresa) {
        this.certificadoEmpresa = certificadoEmpresa;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public BeanTaller() {
    }
    public BeanTaller(String niTaller,String clave){
    }

    public BeanTaller(String niTaller) {
        this.niTaller = niTaller;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the idAlarma
     */
    public String getIdAlarma() {
        return idAlarma;
    }

    /**
     * @param idAlarma the idAlarma to set
     */
    public void setIdAlarma(String idAlarma) {
        this.idAlarma = idAlarma;
    }

}
