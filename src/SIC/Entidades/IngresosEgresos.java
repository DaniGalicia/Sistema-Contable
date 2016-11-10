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
@Table(name = "ingresos_egresos")
@NamedQueries({
    @NamedQuery(name = "IngresosEgresos.findAll", query = "SELECT i FROM IngresosEgresos i"),
    @NamedQuery(name = "IngresosEgresos.findByIdIng", query = "SELECT i FROM IngresosEgresos i WHERE i.idIng = :idIng"),
    @NamedQuery(name = "IngresosEgresos.findByDescripcion", query = "SELECT i FROM IngresosEgresos i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "IngresosEgresos.findByTipo", query = "SELECT i FROM IngresosEgresos i WHERE i.tipo = :tipo"),
    @NamedQuery(name = "IngresosEgresos.findByMonto", query = "SELECT i FROM IngresosEgresos i WHERE i.monto = :monto")})
public class IngresosEgresos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ing")
    private Integer idIng;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "tipo")
    private String tipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private Double monto;
    @JoinColumn(name = "codigo_empleado", referencedColumnName = "codigo_empleado")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado_1 empleado;
    @JoinColumn(name = "id_periodo", referencedColumnName = "id_periodo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Periodo_1 periodo;

    public IngresosEgresos() {
    }

    public IngresosEgresos(Integer idIng) {
        this.idIng = idIng;
    }

    public Integer getIdIng() {
        return idIng;
    }

    public void setIdIng(Integer idIng) {
        this.idIng = idIng;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
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
        hash += (idIng != null ? idIng.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresosEgresos)) {
            return false;
        }
        IngresosEgresos other = (IngresosEgresos) object;
        if ((this.idIng == null && other.idIng != null) || (this.idIng != null && !this.idIng.equals(other.idIng))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SIC.Entidades.IngresosEgresos[ idIng=" + idIng + " ]";
    }
    
}
