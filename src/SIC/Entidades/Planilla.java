/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author IVON-GARCIA
 */
@Entity
@Table(name = "planilla")
@NamedQueries({
    @NamedQuery(name = "Planilla.findAll", query = "SELECT p FROM Planilla p"),
    @NamedQuery(name = "Planilla.findByIdPlanilla", query = "SELECT p FROM Planilla p WHERE p.idPlanilla = :idPlanilla"),
    @NamedQuery(name = "Planilla.findBySueldoBruto", query = "SELECT p FROM Planilla p WHERE p.sueldoBruto = :sueldoBruto"),
    @NamedQuery(name = "Planilla.findByRenta", query = "SELECT p FROM Planilla p WHERE p.renta = :renta"),
    @NamedQuery(name = "Planilla.findByIsss", query = "SELECT p FROM Planilla p WHERE p.isss = :isss"),
    @NamedQuery(name = "Planilla.findByAfp", query = "SELECT p FROM Planilla p WHERE p.afp = :afp"),
    @NamedQuery(name = "Planilla.findByOtrosIngresos", query = "SELECT p FROM Planilla p WHERE p.otrosIngresos = :otrosIngresos"),
    @NamedQuery(name = "Planilla.findByOtrosEgresos", query = "SELECT p FROM Planilla p WHERE p.otrosEgresos = :otrosEgresos"),
    @NamedQuery(name = "Planilla.findBySueldoNeto", query = "SELECT p FROM Planilla p WHERE p.sueldoNeto = :sueldoNeto")})
public class Planilla implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_planilla")
    private Integer idPlanilla;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sueldo_bruto")
    private Double sueldoBruto;
    @Column(name = "renta")
    private Double renta;
    @Column(name = "isss")
    private Double isss;
    @Column(name = "afp")
    private Double afp;
    @Column(name = "otros_ingresos")
    private Double otrosIngresos;
    @Column(name = "otros_egresos")
    private Double otrosEgresos;
    @Column(name = "sueldo_neto")
    private Double sueldoNeto;
    @JoinColumn(name = "codigo_empleado", referencedColumnName = "codigo_empleado")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado_1 empleado;
    @JoinColumn(name = "id_periodo", referencedColumnName = "id_periodo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Periodo_1 periodo;

    public Planilla() {
    }

    public Planilla(Integer idPlanilla) {
        this.idPlanilla = idPlanilla;
    }

    public Integer getIdPlanilla() {
        return idPlanilla;
    }

    public void setIdPlanilla(Integer idPlanilla) {
        this.idPlanilla = idPlanilla;
    }

    public Double getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(Double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    public Double getRenta() {
        return renta;
    }

    public void setRenta(Double renta) {
        this.renta = renta;
    }

    public Double getIsss() {
        return isss;
    }

    public void setIsss(Double isss) {
        this.isss = isss;
    }

    public Double getAfp() {
        return afp;
    }

    public void setAfp(Double afp) {
        this.afp = afp;
    }

    public Double getOtrosIngresos() {
        return otrosIngresos;
    }

    public void setOtrosIngresos(Double otrosIngresos) {
        this.otrosIngresos = otrosIngresos;
    }

    public Double getOtrosEgresos() {
        return otrosEgresos;
    }

    public void setOtrosEgresos(Double otrosEgresos) {
        this.otrosEgresos = otrosEgresos;
    }

    public Double getSueldoNeto() {
        return sueldoNeto;
    }

    public void setSueldoNeto(Double sueldoNeto) {
        this.sueldoNeto = sueldoNeto;
    }

    public Empleado_1 getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado_1 empleado) {
        this.empleado = empleado;
    }

    public Periodo_1 getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo_1 periodo) {
        this.periodo = periodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlanilla != null ? idPlanilla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planilla)) {
            return false;
        }
        Planilla other = (Planilla) object;
        if ((this.idPlanilla == null && other.idPlanilla != null) || (this.idPlanilla != null && !this.idPlanilla.equals(other.idPlanilla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SIC.Entidades.Planilla[ idPlanilla=" + idPlanilla + " ]";
    }
    
}
