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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author dannier
 */
@Entity
@Table(name = "CUENTA_SALDADA")
@NamedQueries({
    @NamedQuery(name = "CuentaSaldada.findAll", query = "SELECT c FROM CuentaSaldada c"),
    @NamedQuery(name = "CuentaSaldada.findByIdCuentaSaldada", query = "SELECT c FROM CuentaSaldada c WHERE c.idCuentaSaldada = :idCuentaSaldada"),
    @NamedQuery(name = "CuentaSaldada.findBySaldo", query = "SELECT c FROM CuentaSaldada c WHERE c.saldo = :saldo")})
public class CuentaSaldada implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CUENTA_SALDADA")
    @GeneratedValue(generator="InvSeqCS")
    @SequenceGenerator(name="InvSeqCS",sequenceName="SECUENCIA_CUENTA_SALDADA", allocationSize=5)
    private BigDecimal idCuentaSaldada;
    @Basic(optional = false)
    @Column(name = "SALDO")
    private double saldo;
    @JoinColumn(name = "ID_CUENTA", referencedColumnName = "ID_CUENTA")
    @ManyToOne(optional = false)
    private Cuenta cuenta;
    @JoinColumn(name = "ID_PERIODO", referencedColumnName = "ID_PERIODO")
    @ManyToOne(optional = false)
    private Periodo periodo;

    public CuentaSaldada() {
    }

    public CuentaSaldada(BigDecimal idCuentaSaldada) {
        this.idCuentaSaldada = idCuentaSaldada;
    }

    public CuentaSaldada(BigDecimal idCuentaSaldada, double saldo) {
        this.idCuentaSaldada = idCuentaSaldada;
        this.saldo = saldo;
    }

    public BigDecimal getIdCuentaSaldada() {
        return idCuentaSaldada;
    }

    public void setIdCuentaSaldada(BigDecimal idCuentaSaldada) {
        this.idCuentaSaldada = idCuentaSaldada;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuentaSaldada != null ? idCuentaSaldada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaSaldada)) {
            return false;
        }
        CuentaSaldada other = (CuentaSaldada) object;
        if ((this.idCuentaSaldada == null && other.idCuentaSaldada != null) || (this.idCuentaSaldada != null && !this.idCuentaSaldada.equals(other.idCuentaSaldada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SIC.Entidades.CuentaSaldada[ idCuentaSaldada=" + idCuentaSaldada + " ]";
    }
    
}
