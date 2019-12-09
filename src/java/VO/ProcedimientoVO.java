/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author Juan
 */
public class ProcedimientoVO {

    private String tipoProcedimiento, procedimiento, costos , idHistorial;

    public ProcedimientoVO(String tipoProcedimiento, String procedimiento, String costos, String idHistorial) {
        this.tipoProcedimiento = tipoProcedimiento;
        this.procedimiento = procedimiento;
        this.costos = costos;
        this.idHistorial = idHistorial;
    }

    public ProcedimientoVO() {
    }

    public String getTipoProcedimiento() {
        return tipoProcedimiento;
    }

    public void setTipoProcedimiento(String tipoProcedimiento) {
        this.tipoProcedimiento = tipoProcedimiento;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    public String getCostos() {
        return costos;
    }

    public void setCostos(String costos) {
        this.costos = costos;
    }

    public String getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(String idHistorial) {
        this.idHistorial = idHistorial;
    }
  

}