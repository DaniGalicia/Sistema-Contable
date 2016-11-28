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
 * @author galicia
 */
@Entity
@Table(name = "ingresos_planilla")
@NamedQueries({
    @NamedQuery(name = "IngresoPlanilla.findAll", query = "SELECT i FROM IngresoPlanilla i"),
    @NamedQuery(name = "IngresoPlanilla.findByIdIngresoPlanilla", query = "SELECT i FROM IngresoPlanilla i WHERE i.idIngresoPlanilla = :idIngresoPlanilla"),
    @NamedQuery(name = "IngresoPlanilla.findByMonto", query = "SELECT i FROM IngresoPlanilla i WHERE i.monto = :monto"),
    @NamedQuery(name = "IngresoPlanilla.findByDescripcion", query = "SELECT i FROM IngresoPlanilla i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "IngresoPlanilla.findByTipo", query = "SELECT i FROM IngresoPlanilla i WHERE i.tipo = :tipo")})
public class IngresoPlanilla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ingreso_planilla")
    private Integer idIngresoPlanilla;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private Double monto;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "id_planilla", referencedColumnName = "id_planilla")
    @ManyToOne(fetch = FetchType.LAZY)
    private Planilla planilla;

    public IngresoPlanilla() {
    }

    public IngresoPlanilla(Integer idIngresoPlanilla) {
        this.idIngresoPlanilla = idIngresoPlanilla;
    }

    public Integer getIdIngresoPlanilla() {
        return idIngresoPlanilla;
    }

    public void setIdIngresoPlanilla(Integer idIngresoPlanilla) {
        this.idIngresoPlanilla = idIngresoPlanilla;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
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

    public Planilla getPlanilla() {
        return planilla;
    }

    public void setPlanilla(Planilla planilla) {
        this.planilla = planilla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIngresoPlanilla != null ? idIngresoPlanilla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresoPlanilla)) {
            return false;
        }
        IngresoPlanilla other = (IngresoPlanilla) object;
        if ((this.idIngresoPlanilla == null && other.idIngresoPlanilla != null) || (this.idIngresoPlanilla != null && !this.idIngresoPlanilla.equals(other.idIngresoPlanilla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SIC.Entidades.IngresosPlanilla[ idIngresoPlanilla=" + idIngresoPlanilla + " ]";
    }
    
}
