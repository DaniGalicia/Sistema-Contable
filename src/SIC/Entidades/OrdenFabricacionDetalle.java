/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author dannier
 */
@Entity
@Table(name = "ORDEN_FABRICACION_DETALLE")
@NamedQueries({
    @NamedQuery(name = "OrdenFabricacionDetalle.findAll", query = "SELECT o FROM OrdenFabricacionDetalle o"),
    @NamedQuery(name = "OrdenFabricacionDetalle.findByIdOrden", query = "SELECT o FROM OrdenFabricacionDetalle o WHERE o.idOrden = :idOrden"),
    @NamedQuery(name = "OrdenFabricacionDetalle.findByCantidadObreros", query = "SELECT o FROM OrdenFabricacionDetalle o WHERE o.cantidadObreros = :cantidadObreros"),
    @NamedQuery(name = "OrdenFabricacionDetalle.findByMaterial", query = "SELECT o FROM OrdenFabricacionDetalle o WHERE o.material = :material"),
    @NamedQuery(name = "OrdenFabricacionDetalle.findByCantidadMaterial", query = "SELECT o FROM OrdenFabricacionDetalle o WHERE o.cantidadMaterial = :cantidadMaterial"),
    @NamedQuery(name = "OrdenFabricacionDetalle.findByPrecioUnitario", query = "SELECT o FROM OrdenFabricacionDetalle o WHERE o.precioUnitario = :precioUnitario"),
    @NamedQuery(name = "OrdenFabricacionDetalle.findByPrecioHora", query = "SELECT o FROM OrdenFabricacionDetalle o WHERE o.precioHora = :precioHora"),
    @NamedQuery(name = "OrdenFabricacionDetalle.findByCantidadHoras", query = "SELECT o FROM OrdenFabricacionDetalle o WHERE o.cantidadHoras = :cantidadHoras"),
    @NamedQuery(name = "OrdenFabricacionDetalle.findByTasaCif", query = "SELECT o FROM OrdenFabricacionDetalle o WHERE o.tasaCif = :tasaCif")})
public class OrdenFabricacionDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ORDEN")
    private BigDecimal idOrden;
    @Column(name = "CANTIDAD_OBREROS")
    private BigInteger cantidadObreros;
    @Column(name = "MATERIAL")
    private String material;
    @Column(name = "CANTIDAD_MATERIAL")
    private BigInteger cantidadMaterial;
    @Column(name = "PRECIO_UNITARIO")
    private Double precioUnitario;
    @Column(name = "PRECIO_HORA")
    private Double precioHora;
    @Column(name = "CANTIDAD_HORAS")
    private BigInteger cantidadHoras;
    @Column(name = "TASA_CIF")
    private Double tasaCif;
    @JoinColumn(name = "ID_ORDEN", referencedColumnName = "ID_ORDEN", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private OrdenFabricacion ordenFabricacion;

    public OrdenFabricacionDetalle() {
    }

    public OrdenFabricacionDetalle(BigDecimal idOrden) {
        this.idOrden = idOrden;
    }

    public BigDecimal getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(BigDecimal idOrden) {
        this.idOrden = idOrden;
    }

    public BigInteger getCantidadObreros() {
        return cantidadObreros;
    }

    public void setCantidadObreros(BigInteger cantidadObreros) {
        this.cantidadObreros = cantidadObreros;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public BigInteger getCantidadMaterial() {
        return cantidadMaterial;
    }

    public void setCantidadMaterial(BigInteger cantidadMaterial) {
        this.cantidadMaterial = cantidadMaterial;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(Double precioHora) {
        this.precioHora = precioHora;
    }

    public BigInteger getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(BigInteger cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    public Double getTasaCif() {
        return tasaCif;
    }

    public void setTasaCif(Double tasaCif) {
        this.tasaCif = tasaCif;
    }

    public OrdenFabricacion getOrdenFabricacion() {
        return ordenFabricacion;
    }

    public void setOrdenFabricacion(OrdenFabricacion ordenFabricacion) {
        this.ordenFabricacion = ordenFabricacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrden != null ? idOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenFabricacionDetalle)) {
            return false;
        }
        OrdenFabricacionDetalle other = (OrdenFabricacionDetalle) object;
        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SIC.Entidades.OrdenFabricacionDetalle[ idOrden=" + idOrden + " ]";
    }
    
}
