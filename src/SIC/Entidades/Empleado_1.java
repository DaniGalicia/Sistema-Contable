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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "empleado")
@NamedQueries({
    @NamedQuery(name = "Empleado_1.findAll", query = "SELECT e FROM Empleado_1 e"),
    @NamedQuery(name = "Empleado_1.findByCodigoEmpleado", query = "SELECT e FROM Empleado_1 e WHERE e.codigoEmpleado = :codigoEmpleado"),
    @NamedQuery(name = "Empleado_1.findByApellidos", query = "SELECT e FROM Empleado_1 e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "Empleado_1.findByDui", query = "SELECT e FROM Empleado_1 e WHERE e.dui = :dui"),
    @NamedQuery(name = "Empleado_1.findByFechaContrato", query = "SELECT e FROM Empleado_1 e WHERE e.fechaContrato = :fechaContrato"),
    @NamedQuery(name = "Empleado_1.findByNombres", query = "SELECT e FROM Empleado_1 e WHERE e.nombres = :nombres"),
    @NamedQuery(name = "Empleado_1.findBySexo", query = "SELECT e FROM Empleado_1 e WHERE e.sexo = :sexo"),
    @NamedQuery(name = "Empleado_1.findByTelefono", query = "SELECT e FROM Empleado_1 e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "Empleado_1.findByPorcRenta", query = "SELECT e FROM Empleado_1 e WHERE e.porcRenta = :porcRenta"),
    @NamedQuery(name = "Empleado_1.findByPorcIsss", query = "SELECT e FROM Empleado_1 e WHERE e.porcIsss = :porcIsss"),
    @NamedQuery(name = "Empleado_1.findByPorcAfp", query = "SELECT e FROM Empleado_1 e WHERE e.porcAfp = :porcAfp")})
public class Empleado_1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo_empleado")
    private String codigoEmpleado;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "dui")
    private String dui;
    @Column(name = "fecha_contrato")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaContrato;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "telefono")
    private String telefono;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porc_renta")
    private Double porcRenta;
    @Column(name = "porc_isss")
    private Double porcIsss;
    @Column(name = "porc_afp")
    private Double porcAfp;
    @OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY)
    private List<IngresosEgresos> ingresosEgresosList;
    @JoinColumn(name = "id_cargo", referencedColumnName = "id_cargo")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cargo_1 cargo;
    @OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY)
    private List<Planilla> planillaList;

    public Empleado_1() {
    }

    public Empleado_1(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Double getPorcRenta() {
        return porcRenta;
    }

    public void setPorcRenta(Double porcRenta) {
        this.porcRenta = porcRenta;
    }

    public Double getPorcIsss() {
        return porcIsss;
    }

    public void setPorcIsss(Double porcIsss) {
        this.porcIsss = porcIsss;
    }

    public Double getPorcAfp() {
        return porcAfp;
    }

    public void setPorcAfp(Double porcAfp) {
        this.porcAfp = porcAfp;
    }

    public List<IngresosEgresos> getIngresosEgresosList() {
        return ingresosEgresosList;
    }

    public void setIngresosEgresosList(List<IngresosEgresos> ingresosEgresosList) {
        this.ingresosEgresosList = ingresosEgresosList;
    }

    public Cargo_1 getCargo() {
        return cargo;
    }

    public void setCargo(Cargo_1 cargo) {
        this.cargo = cargo;
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
        hash += (codigoEmpleado != null ? codigoEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado_1)) {
            return false;
        }
        Empleado_1 other = (Empleado_1) object;
        if ((this.codigoEmpleado == null && other.codigoEmpleado != null) || (this.codigoEmpleado != null && !this.codigoEmpleado.equals(other.codigoEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SIC.Entidades.Empleado_1[ codigoEmpleado=" + codigoEmpleado + " ]";
    }
    
}
