/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author dannier
 */
@Entity
@Table(name = "ESTADO_FINANCIERO")
@NamedQueries({
    @NamedQuery(name = "EstadoFinanciero.findAll", query = "SELECT e FROM EstadoFinanciero e"),
    @NamedQuery(name = "EstadoFinanciero.findByIdEstadoFinanciero", query = "SELECT e FROM EstadoFinanciero e WHERE e.idEstadoFinanciero = :idEstadoFinanciero"),
    @NamedQuery(name = "EstadoFinanciero.findBySaldo", query = "SELECT e FROM EstadoFinanciero e WHERE e.saldo = :saldo")})
public class EstadoFinanciero implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ESTADO_FINANCIERO")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SECUENCIA_ESTADO_FINANCIERO")
    private BigDecimal idEstadoFinanciero;
    @Basic(optional = false)
    @Column(name = "SALDO")
    private double saldo;
    @JoinColumn(name = "ID_PERIODO", referencedColumnName = "ID_PERIODO")
    @ManyToOne(optional = false)
    private Periodo periodo;
    @JoinColumn(name = "ID_TIPO_ESTADO_FINANCIERO", referencedColumnName = "ID_TIPO_ESTADO_FINANCIERO")
    @ManyToOne(optional = false)
    private TipoEstadoFinanciero tipoEstadoFinanciero;

    public EstadoFinanciero() {
    }

    public EstadoFinanciero(BigDecimal idEstadoFinanciero) {
        this.idEstadoFinanciero = idEstadoFinanciero;
    }

    public EstadoFinanciero(BigDecimal idEstadoFinanciero, double saldo) {
        this.idEstadoFinanciero = idEstadoFinanciero;
        this.saldo = saldo;
    }

    public BigDecimal getIdEstadoFinanciero() {
        return idEstadoFinanciero;
    }

    public void setIdEstadoFinanciero(BigDecimal idEstadoFinanciero) {
        this.idEstadoFinanciero = idEstadoFinanciero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public TipoEstadoFinanciero getTipoEstadoFinanciero() {
        return tipoEstadoFinanciero;
    }

    public void setTipoEstadoFinanciero(TipoEstadoFinanciero tipoEstadoFinanciero) {
        this.tipoEstadoFinanciero = tipoEstadoFinanciero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoFinanciero != null ? idEstadoFinanciero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoFinanciero)) {
            return false;
        }
        EstadoFinanciero other = (EstadoFinanciero) object;
        if ((this.idEstadoFinanciero == null && other.idEstadoFinanciero != null) || (this.idEstadoFinanciero != null && !this.idEstadoFinanciero.equals(other.idEstadoFinanciero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SIC.Entidades.EstadoFinanciero[ idEstadoFinanciero=" + idEstadoFinanciero + " ]";
    }
    
}
