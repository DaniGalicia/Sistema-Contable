/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author dannier
 */
@Entity
@Table(name = "ESTADOS_FINANCIEROS",schema = "SIC")
@NamedQueries({
    @NamedQuery(name = "EstadosFinancieros.findAll", query = "SELECT e FROM EstadosFinancieros e"),
    @NamedQuery(name = "EstadosFinancieros.findByIdEstadoFinanciero", query = "SELECT e FROM EstadosFinancieros e WHERE e.idEstadoFinanciero = :idEstadoFinanciero"),
    @NamedQuery(name = "EstadosFinancieros.findByFechaInicio", query = "SELECT e FROM EstadosFinancieros e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "EstadosFinancieros.findByTotal", query = "SELECT e FROM EstadosFinancieros e WHERE e.total = :total"),
    @NamedQuery(name = "EstadosFinancieros.findByFechaFin", query = "SELECT e FROM EstadosFinancieros e WHERE e.fechaFin = :fechaFin")})
public class EstadosFinancieros implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ESTADO_FINANCIERO")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="SECUENCIA_ESTADO_FINANCIERO", allocationSize=5)
    
    private BigDecimal idEstadoFinanciero;
    @Basic(optional = false)
    @Column(name = "FECHA_INICIO")
    private String fechaInicio;
    @Basic(optional = false)
    @Column(name = "TOTAL")
    private String total;
    @Column(name = "FECHA_FIN")
    private String fechaFin;
    @ManyToMany(mappedBy = "estadosFinancierosList")
    private List<CuentasSaldadas> cuentasSaldadasList;

    public EstadosFinancieros() {
    }

    public EstadosFinancieros(BigDecimal idEstadoFinanciero) {
        this.idEstadoFinanciero = idEstadoFinanciero;
    }

    public EstadosFinancieros(BigDecimal idEstadoFinanciero, String fechaInicio, String total) {
        this.idEstadoFinanciero = idEstadoFinanciero;
        this.fechaInicio = fechaInicio;
        this.total = total;
    }

    public BigDecimal getIdEstadoFinanciero() {
        return idEstadoFinanciero;
    }

    public void setIdEstadoFinanciero(BigDecimal idEstadoFinanciero) {
        this.idEstadoFinanciero = idEstadoFinanciero;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<CuentasSaldadas> getCuentasSaldadasList() {
        return cuentasSaldadasList;
    }

    public void setCuentasSaldadasList(List<CuentasSaldadas> cuentasSaldadasList) {
        this.cuentasSaldadasList = cuentasSaldadasList;
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
        if (!(object instanceof EstadosFinancieros)) {
            return false;
        }
        EstadosFinancieros other = (EstadosFinancieros) object;
        if ((this.idEstadoFinanciero == null && other.idEstadoFinanciero != null) || (this.idEstadoFinanciero != null && !this.idEstadoFinanciero.equals(other.idEstadoFinanciero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SIC.Entidades.EstadosFinancieros[ idEstadoFinanciero=" + idEstadoFinanciero + " ]";
    }
    
}
