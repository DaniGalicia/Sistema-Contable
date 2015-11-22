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
import javax.persistence.Embeddable;

/**
 *
 * @author dannier
 */
@Embeddable
public class EstadoFinancieroPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_ESTADO_FINANCIERO")
    private BigInteger idEstadoFinanciero;
    @Basic(optional = false)
    @Column(name = "ID_PERIODO")
    private BigInteger idPeriodo;

    public EstadoFinancieroPK() {
    }

    public EstadoFinancieroPK(BigInteger idEstadoFinanciero, BigInteger idPeriodo) {
        this.idEstadoFinanciero = idEstadoFinanciero;
        this.idPeriodo = idPeriodo;
    }

    public BigInteger getIdEstadoFinanciero() {
        return idEstadoFinanciero;
    }

    public void setIdEstadoFinanciero(BigInteger idEstadoFinanciero) {
        this.idEstadoFinanciero = idEstadoFinanciero;
    }

    public BigInteger getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(BigInteger idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoFinanciero != null ? idEstadoFinanciero.hashCode() : 0);
        hash += (idPeriodo != null ? idPeriodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoFinancieroPK)) {
            return false;
        }
        EstadoFinancieroPK other = (EstadoFinancieroPK) object;
        if ((this.idEstadoFinanciero == null && other.idEstadoFinanciero != null) || (this.idEstadoFinanciero != null && !this.idEstadoFinanciero.equals(other.idEstadoFinanciero))) {
            return false;
        }
        if ((this.idPeriodo == null && other.idPeriodo != null) || (this.idPeriodo != null && !this.idPeriodo.equals(other.idPeriodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SIC.Entidades.EstadoFinancieroPK[ idEstadoFinanciero=" + idEstadoFinanciero + ", idPeriodo=" + idPeriodo + " ]";
    }
    
}
