/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author IVON-GARCIA
 */
@Entity
@Table(name = "periodo")
@NamedQueries({
    @NamedQuery(name = "Periodo_1.findAll", query = "SELECT p FROM Periodo_1 p"),
    @NamedQuery(name = "Periodo_1.findByIdPeriodo", query = "SELECT p FROM Periodo_1 p WHERE p.idPeriodo = :idPeriodo"),
    @NamedQuery(name = "Periodo_1.findByActivo", query = "SELECT p FROM Periodo_1 p WHERE p.activo = :activo"),
    @NamedQuery(name = "Periodo_1.findByFechaFin", query = "SELECT p FROM Periodo_1 p WHERE p.fechaFin = :fechaFin"),
    @NamedQuery(name = "Periodo_1.findByFechaInicio", query = "SELECT p FROM Periodo_1 p WHERE p.fechaInicio = :fechaInicio")})
public class Periodo_1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_periodo")
    private Integer idPeriodo;
    @Column(name = "activo")
    private String activo;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo", fetch = FetchType.LAZY)
    private List<IngresosEgresos> ingresosEgresosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo", fetch = FetchType.LAZY)
    private List<Planilla> planillaList;

    public Periodo_1() {
    }

    public Periodo_1(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Integer getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public List<IngresosEgresos> getIngresosEgresosList() {
        return ingresosEgresosList;
    }

    public void setIngresosEgresosList(List<IngresosEgresos> ingresosEgresosList) {
        this.ingresosEgresosList = ingresosEgresosList;
    }

    public List<Planilla> getPlanillaList() {
        return planillaList;
    }

    public void setPlanillaList(List<Planilla> planillaList) {
        this.planillaList = planillaList;
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
        if (!(object instanceof Periodo_1)) {
            return false;
        }
        Periodo_1 other = (Periodo_1) object;
        if ((this.idPeriodo == null && other.idPeriodo != null) || (this.idPeriodo != null && !this.idPeriodo.equals(other.idPeriodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SIC.Entidades.Periodo_1[ idPeriodo=" + idPeriodo + " ]";
    }
    
}
