/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dannier
 */
@Entity
@Table(name = "PERIODO")
@NamedQueries({
    @NamedQuery(name = "Periodo.findAll", query = "SELECT p FROM Periodo p"),
    @NamedQuery(name = "Periodo.findByFechaInicio", query = "SELECT p FROM Periodo p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Periodo.findByFechaFin", query = "SELECT p FROM Periodo p WHERE p.fechaFin = :fechaFin"),
    @NamedQuery(name = "Periodo.findByIdPeriodo", query = "SELECT p FROM Periodo p WHERE p.idPeriodo = :idPeriodo"),
    @NamedQuery(name = "Periodo.findByActivo", query = "SELECT p FROM Periodo p WHERE p.activo = :activo")})
public class Periodo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PERIODO")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SECUENCIA_PERIODO")
    private BigDecimal idPeriodo;
    @Column(name = "ACTIVO")
    private String activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo")
    private List<CuentaSaldada> cuentaSaldadaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo")
    private List<EstadoFinanciero> estadoFinancieroList;

    public Periodo() {
    }

    public Periodo(BigDecimal idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Periodo(BigDecimal idPeriodo, Date fechaInicio, Date fechaFin) {
        this.idPeriodo = idPeriodo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(BigDecimal idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public List<CuentaSaldada> getCuentaSaldadaList() {
        return cuentaSaldadaList;
    }

    public void setCuentaSaldadaList(List<CuentaSaldada> cuentaSaldadaList) {
        this.cuentaSaldadaList = cuentaSaldadaList;
    }

    public List<EstadoFinanciero> getEstadoFinancieroList() {
        return estadoFinancieroList;
    }

    public void setEstadoFinancieroList(List<EstadoFinanciero> estadoFinancieroList) {
        this.estadoFinancieroList = estadoFinancieroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeriodo != null ? idPeriodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodo)) {
            return false;
        }
        Periodo other = (Periodo) object;
        if ((this.idPeriodo == null && other.idPeriodo != null) || (this.idPeriodo != null && !this.idPeriodo.equals(other.idPeriodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SIC.Entidades.Periodo[ idPeriodo=" + idPeriodo + " ]";
    }
    
}
