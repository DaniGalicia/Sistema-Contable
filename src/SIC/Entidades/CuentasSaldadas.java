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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dannier
 */
@Entity
@Table(name = "CUENTAS_SALDADAS",schema = "SIC")
@NamedQueries({
    @NamedQuery(name = "CuentasSaldadas.findAll", query = "SELECT c FROM CuentasSaldadas c"),
    @NamedQuery(name = "CuentasSaldadas.findByIdCuentaSaldada", query = "SELECT c FROM CuentasSaldadas c WHERE c.idCuentaSaldada = :idCuentaSaldada"),
    @NamedQuery(name = "CuentasSaldadas.findBySaldo", query = "SELECT c FROM CuentasSaldadas c WHERE c.saldo = :saldo"),
    @NamedQuery(name = "CuentasSaldadas.findByFechaSaldada", query = "SELECT c FROM CuentasSaldadas c WHERE c.fechaSaldada = :fechaSaldada")})
public class CuentasSaldadas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(generator="InvSeqCS")
    @SequenceGenerator(name="InvSeqCS",sequenceName="SECUENCIA_CUENTA_SALDADA", allocationSize=5)  
    @Column(name = "ID_CUENTA_SALDADA")
    private BigDecimal idCuentaSaldada;
    @Basic(optional = false)
    @Column(name = "SALDO")
    private double saldo;
    @Basic(optional = false)
    @Column(name = "FECHA_SALDADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSaldada;
    @JoinTable(name = "CUENTAS_ESTADO_FINACIERO", joinColumns = {
        @JoinColumn(name = "ID_CUENTA_SALDADA", referencedColumnName = "ID_CUENTA_SALDADA")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_ESTADO_FINANCIERO", referencedColumnName = "ID_ESTADO_FINANCIERO")})
    @ManyToMany
    private List<EstadosFinancieros> estadosFinancierosList;
    @JoinColumn(name = "ID_CUENTA", referencedColumnName = "ID_CUENTA")
    @ManyToOne(optional = false)
    private Cuenta cuenta;

    public CuentasSaldadas() {
    }

    public CuentasSaldadas(BigDecimal idCuentaSaldada) {
        this.idCuentaSaldada = idCuentaSaldada;
    }

    public CuentasSaldadas(BigDecimal idCuentaSaldada, double saldo, Date fechaSaldada) {
        this.idCuentaSaldada = idCuentaSaldada;
        this.saldo = saldo;
        this.fechaSaldada = fechaSaldada;
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

    public Date getFechaSaldada() {
        return fechaSaldada;
    }

    public void setFechaSaldada(Date fechaSaldada) {
        this.fechaSaldada = fechaSaldada;
    }

    public List<EstadosFinancieros> getEstadosFinancierosList() {
        return estadosFinancierosList;
    }

    public void setEstadosFinancierosList(List<EstadosFinancieros> estadosFinancierosList) {
        this.estadosFinancierosList = estadosFinancierosList;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
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
        if (!(object instanceof CuentasSaldadas)) {
            return false;
        }
        CuentasSaldadas other = (CuentasSaldadas) object;
        if ((this.idCuentaSaldada == null && other.idCuentaSaldada != null) || (this.idCuentaSaldada != null && !this.idCuentaSaldada.equals(other.idCuentaSaldada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SIC.Entidades.CuentasSaldadas[ idCuentaSaldada=" + idCuentaSaldada + " ]";
    }
    
}
