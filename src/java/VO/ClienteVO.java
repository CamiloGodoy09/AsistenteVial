package VO;

public class ClienteVO {

    
    private String nombre, apellidos, idCliente, fechaNacimiento,
            genero, correo, telefono, usuario,clave;
    private byte [] foto;

    public ClienteVO(String nombre, String apellidos, String idCliente, String fechaNacimiento, String genero, String correo, String telefono, String usuario, String clave, byte[] foto) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.idCliente = idCliente;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.correo = correo;
        this.telefono = telefono;
        this.usuario = usuario;
        this.clave = clave;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    
    public ClienteVO(String idCliente) {
        this.idCliente = idCliente;
    }
    
    public ClienteVO(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }



}