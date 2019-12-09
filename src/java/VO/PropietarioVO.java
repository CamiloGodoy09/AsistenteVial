package VO;

/**
 *
 * @author Juan
 */
public class PropietarioVO {

    private String foto, idPropietario, nombre, apellido, telefono, estado, usuario, clave;

    public PropietarioVO(String foto, String idPropietario, String nombre, String apellido, String telefono, String estado, String usuario, String clave) {
        this.foto = foto;
        this.idPropietario = idPropietario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.estado = estado;
        this.usuario = usuario;
        this.clave = clave;
    }

    public PropietarioVO() {
    }

    public PropietarioVO(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public PropietarioVO(String idPropietario) {
        this.idPropietario = idPropietario;
    }

  
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(String idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
