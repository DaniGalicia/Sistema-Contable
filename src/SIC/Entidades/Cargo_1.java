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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author IVON-GARCIA
 */
@Entity
@Table(name = "cargo")
@NamedQueries({
    @NamedQuery(name = "Cargo_1.findAll", query = "SELECT c FROM Cargo_1 c"),
    @NamedQuery(name = "Cargo_1.findByIdCargo", query = "SELECT c FROM Cargo_1 c WHERE c.idCargo = :idCargo"),
    @NamedQuery(name = "Cargo_1.findByNombreCargo", query = "SELECT c FROM Cargo_1 c WHERE c.nombreCargo = :nombreCargo"),
    @NamedQuery(name = "Cargo_1.findBySueldo", query = "SELECT c FROM Cargo_1 c WHERE c.sueldo = :sueldo")})
public class Cargo_1 implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_cargo")
    private BigDecimal idCargo;
    @Column(name = "nombre_cargo")
    private String nombreCargo;
    @Column(name = "sueldo")
    private Double sueldo;
    @OneToMany(mappedBy = "cargo", fetch = FetchType.LAZY)
    private List<Empleado_1> empleadoList;

    public Cargo_1() {
    }

    public Cargo_1(BigDecimal idCargo) {
        this.idCargo = idCargo;
    }

    public BigDecimal getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(BigDecimal idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public List<Empleado_1> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado_1> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCargo != null ? idCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo_1)) {
            return false;
        }
        Cargo_1 other = (Cargo_1) object;
        if ((this.idCargo == null && other.idCargo != null) || (this.idCargo != null && !this.idCargo.equals(other.idCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SIC.Entidades.Cargo_1[ idCargo=" + idCargo + " ]";
    }
    
}
