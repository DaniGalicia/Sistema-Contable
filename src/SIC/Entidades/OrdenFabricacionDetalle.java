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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Escobar
 */
@Entity
@Table(name = "ORDEN_FABRICACION_DETALLE")
@NamedQueries({
    @NamedQuery(name = "OrdenFabricacionDetalle.findAll", query = "SELECT o FROM OrdenFabricacionDetalle o"),
    @NamedQuery(name = "OrdenFabricacionDetalle.findByCantidadObreros", query = "SELECT o FROM OrdenFabricacionDetalle o WHERE o.cantidadObreros = :cantidadObreros"),
    @NamedQuery(name = "OrdenFabricacionDetalle.findByMaterial", query = "SELECT o FROM OrdenFabricacionDetalle o WHERE o.material = :material"),
    @NamedQuery(name = "OrdenFabricacionDetalle.findByCantidadMaterial", query = "SELECT o FROM OrdenFabricacionDetalle o WHERE o.cantidadMaterial = :cantidadMaterial"),
    @NamedQuery(name = "OrdenFabricacionDetalle.findByPrecioUnitario", query = "SELECT o FROM OrdenFabricacionDetalle o WHERE o.precioUnitario = :precioUnitario"),
    @NamedQuery(name = "OrdenFabricacionDetalle.findByPrecioHora", query = "SELECT o FROM OrdenFabricacionDetalle o WHERE o.precioHora = :precioHora"),
    @NamedQuery(name = "OrdenFabricacionDetalle.findByCantidadHoras", query = "SELECT o FROM OrdenFabricacionDetalle o WHERE o.cantidadHoras = :cantidadHoras"),
    @NamedQuery(name = "OrdenFabricacionDetalle.findByTasaCif", query = "SELECT o FROM OrdenFabricacionDetalle o WHERE o.tasaCif = :tasaCif"),
    @NamedQuery(name = "OrdenFabricacionDetalle.findByIdOrdenFrabricacionDetalle", query = "SELECT o FROM OrdenFabricacionDetalle o WHERE o.idOrdenFrabricacionDetalle = :idOrdenFrabricacionDetalle")})
public class OrdenFabricacionDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "CANTIDAD_OBREROS")
    private BigInteger cantidadObreros;
    @Column(name = "MATERIAL")
    private String material;
    @Column(name = "CANTIDAD_MATERIAL")
    private BigInteger cantidadMaterial;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO_UNITARIO")
    private Double precioUnitario;
    @Column(name = "PRECIO_HORA")
    private Double precioHora;
    @Column(name = "CANTIDAD_HORAS")
    private BigInteger cantidadHoras;
    @Column(name = "TASA_CIF")
    private Double tasaCif;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SECUENCIA_OF_DETALLE")
    @Column(name = "ID_ORDEN_FRABRICACION_DETALLE")
    private BigDecimal idOrdenFrabricacionDetalle;
    @JoinColumn(name = "ID_ORDEN_FABRICACION", referencedColumnName = "ID_ORDEN_FABRICACION")
    @ManyToOne(optional = false)
    private OrdenFabricacion ordenFabricacion;

    public OrdenFabricacionDetalle() {
    }

    public OrdenFabricacionDetalle(BigDecimal idOrdenFrabricacionDetalle) {
        this.idOrdenFrabricacionDetalle = idOrdenFrabricacionDetalle;
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

    public BigDecimal getIdOrdenFrabricacionDetalle() {
        return idOrdenFrabricacionDetalle;
    }

    public void setIdOrdenFrabricacionDetalle(BigDecimal idOrdenFrabricacionDetalle) {
        this.idOrdenFrabricacionDetalle = idOrdenFrabricacionDetalle;
    }

    public OrdenFabricacion getOrdenFabricacion() {
        return ordenFabricacion;
    }
    
    public Double getTotalMaterial() {
        return cantidadMaterial.floatValue()*precioUnitario;
    }
    public Double getTotalManoObra() {
        return cantidadObreros.floatValue()*cantidadHoras.floatValue()*precioHora;
    }
    public Double getImporte() {
        return tasaCif * (getTotalMaterial()+getTotalManoObra());
    }
    public Double getCostoTotal() {
        return getTotalMaterial()+getTotalManoObra()+getImporte();
    }
    public Double getCostoUnitario(int cantidad) {
        return getCostoTotal()/cantidad;
    }
    public void setOrdenFabricacion(OrdenFabricacion ordenFabricacion) {
        this.ordenFabricacion = ordenFabricacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenFrabricacionDetalle != null ? idOrdenFrabricacionDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenFabricacionDetalle)) {
            return false;
        }
        OrdenFabricacionDetalle other = (OrdenFabricacionDetalle) object;
        if ((this.idOrdenFrabricacionDetalle == null && other.idOrdenFrabricacionDetalle != null) || (this.idOrdenFrabricacionDetalle != null && !this.idOrdenFrabricacionDetalle.equals(other.idOrdenFrabricacionDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SIC.Entidades.OrdenFabricacionDetalle[ idOrdenFrabricacionDetalle=" + idOrdenFrabricacionDetalle + " ]";
    }
    
}
