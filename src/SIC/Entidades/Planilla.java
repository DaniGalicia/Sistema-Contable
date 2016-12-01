/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Entidades;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author galicia
 */
@Entity
@Table(name = "planilla")
@NamedQueries({
    @NamedQuery(name = "Planilla.findAll", query = "SELECT p FROM Planilla p"),
    @NamedQuery(name = "Planilla.findByPeriodo", query = "SELECT p FROM Planilla p WHERE p.periodo = :periodo")})
public class Planilla implements Serializable {

    @OneToMany(mappedBy = "planilla", fetch = FetchType.LAZY)
    private List<IngresoPlanilla> ingresosPlanillaList;

    @Column(name = "otro_ingreso")
    private Double otroIngreso;
    @Column(name = "otro_egreso")
    private Double otroEgreso;
    
    @Column(name = "estado")
    private String estado;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_planilla")
    private Integer idPlanilla;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salario_bruto")
    private Double salarioBruto;
    @Column(name = "renta")
    private Double renta;
    @Column(name = "isss")
    private Double isss;
    @Column(name = "afp")
    private Double afp;
    @Column(name = "sueldo_neto")
    private Double sueldoNeto;
    @JoinColumn(name = "id_periodo", referencedColumnName = "id_periodo")
    @ManyToOne(fetch = FetchType.LAZY)
    private Periodo periodo;
    @JoinColumn(name = "codigo_empleado", referencedColumnName = "codigo_empleado")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado empleado;

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

    public Double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(Double salarioBruto) {
        this.salarioBruto = salarioBruto;
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

    public Double getSueldoNeto() {
        return sueldoNeto;
    }

    public void setSueldoNeto(Double sueldoNeto) {
        this.sueldoNeto = sueldoNeto;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
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

    public Double getOtroIngreso() {
        return otroIngreso;
    }

    public void setOtroIngreso(Double otroIngreso) {
        this.otroIngreso = otroIngreso;
    }

    public Double getOtroEgreso() {
        return otroEgreso;
    }

    public void setOtroEgreso(Double otroEgreso) {
        this.otroEgreso = otroEgreso;
    }

    public List<IngresoPlanilla> getIngresosPlanillaList() {
        return ingresosPlanillaList;
    }

    public void setIngresosPlanillaList(List<IngresoPlanilla> ingresosPlanillaList) {
        this.ingresosPlanillaList = ingresosPlanillaList;
    }
    
    public void calcularSueldoNeto(){
        this.sueldoNeto = salarioBruto + otroIngreso - (isss + afp + otroEgreso);
          
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
