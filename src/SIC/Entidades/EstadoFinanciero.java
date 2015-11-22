/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    @NamedQuery(name = "EstadoFinanciero.findByIdEstadoFinanciero", query = "SELECT e FROM EstadoFinanciero e WHERE e.estadoFinancieroPK.idEstadoFinanciero = :idEstadoFinanciero"),
    @NamedQuery(name = "EstadoFinanciero.findBySaldo", query = "SELECT e FROM EstadoFinanciero e WHERE e.saldo = :saldo"),
    @NamedQuery(name = "EstadoFinanciero.findByIdPeriodo", query = "SELECT e FROM EstadoFinanciero e WHERE e.estadoFinancieroPK.idPeriodo = :idPeriodo")})
public class EstadoFinanciero implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstadoFinancieroPK estadoFinancieroPK;
    @Basic(optional = false)
    @Column(name = "SALDO")
    private double saldo;
    @JoinColumn(name = "ID_PERIODO", referencedColumnName = "ID_PERIODO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Periodo periodo;
    @JoinColumn(name = "ID_TIPO_ESTADO_FINANCIERO", referencedColumnName = "ID_TIPO_ESTADO_FINANCIERO")
    @ManyToOne
    private TipoEstadoFinanciero tipoEstadoFinanciero;

    public EstadoFinanciero() {
    }

    public EstadoFinanciero(EstadoFinancieroPK estadoFinancieroPK) {
        this.estadoFinancieroPK = estadoFinancieroPK;
    }

    public EstadoFinanciero(EstadoFinancieroPK estadoFinancieroPK, double saldo) {
        this.estadoFinancieroPK = estadoFinancieroPK;
        this.saldo = saldo;
    }

    public EstadoFinanciero(BigInteger idEstadoFinanciero, BigInteger idPeriodo) {
        this.estadoFinancieroPK = new EstadoFinancieroPK(idEstadoFinanciero, idPeriodo);
    }

    public EstadoFinancieroPK getEstadoFinancieroPK() {
        return estadoFinancieroPK;
    }

    public void setEstadoFinancieroPK(EstadoFinancieroPK estadoFinancieroPK) {
        this.estadoFinancieroPK = estadoFinancieroPK;
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
        hash += (estadoFinancieroPK != null ? estadoFinancieroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoFinanciero)) {
            return false;
        }
        EstadoFinanciero other = (EstadoFinanciero) object;
        if ((this.estadoFinancieroPK == null && other.estadoFinancieroPK != null) || (this.estadoFinancieroPK != null && !this.estadoFinancieroPK.equals(other.estadoFinancieroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SIC.Entidades.EstadoFinanciero[ estadoFinancieroPK=" + estadoFinancieroPK + " ]";
    }
    
}
