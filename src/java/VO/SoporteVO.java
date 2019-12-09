package VO;

/**
 *
 * @author Juan
 */
public class SoporteVO {

    private String comentario;
    String idCliente;
    String idSoporte;
    String usuario;

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdSoporte() {
        return idSoporte;
    }

    public void setIdSoporte(String idSoporte) {
        this.idSoporte = idSoporte;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public SoporteVO() {
    }

    public SoporteVO(String comentario, String idCliente, String idSoporte, String usuario) {
        this.comentario = comentario;
        this.idCliente = idCliente;
        this.idSoporte = idSoporte;
        this.usuario = usuario;
    }

    
}
