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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author dannier
 */
@Entity
@Table(name = "TIPO_ESTADO_FINANCIERO")
@NamedQueries({
    @NamedQuery(name = "TipoEstadoFinanciero.findAll", query = "SELECT t FROM TipoEstadoFinanciero t"),
    @NamedQuery(name = "TipoEstadoFinanciero.findByIdTipoEstadoFinanciero", query = "SELECT t FROM TipoEstadoFinanciero t WHERE t.idTipoEstadoFinanciero = :idTipoEstadoFinanciero"),
    @NamedQuery(name = "TipoEstadoFinanciero.findByNombre", query = "SELECT t FROM TipoEstadoFinanciero t WHERE t.nombre = :nombre")})
public class TipoEstadoFinanciero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TIPO_ESTADO_FINANCIERO")
    private String idTipoEstadoFinanciero;
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(mappedBy = "tipoEstadoFinanciero")
    private List<EstadoFinanciero> estadoFinancieroList;

    public TipoEstadoFinanciero() {
    }

    public TipoEstadoFinanciero(String idTipoEstadoFinanciero) {
        this.idTipoEstadoFinanciero = idTipoEstadoFinanciero;
    }

    public String getIdTipoEstadoFinanciero() {
        return idTipoEstadoFinanciero;
    }

    public void setIdTipoEstadoFinanciero(String idTipoEstadoFinanciero) {
        this.idTipoEstadoFinanciero = idTipoEstadoFinanciero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idTipoEstadoFinanciero != null ? idTipoEstadoFinanciero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEstadoFinanciero)) {
            return false;
        }
        TipoEstadoFinanciero other = (TipoEstadoFinanciero) object;
        if ((this.idTipoEstadoFinanciero == null && other.idTipoEstadoFinanciero != null) || (this.idTipoEstadoFinanciero != null && !this.idTipoEstadoFinanciero.equals(other.idTipoEstadoFinanciero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SIC.Entidades.TipoEstadoFinanciero[ idTipoEstadoFinanciero=" + idTipoEstadoFinanciero + " ]";
    }
    
}
