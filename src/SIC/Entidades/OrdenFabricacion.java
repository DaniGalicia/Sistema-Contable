/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author Escobar
 */
@Entity
@Table(name = "ORDEN_FABRICACION")
@NamedQueries({
    @NamedQuery(name = "OrdenFabricacion.findAll", query = "SELECT o FROM OrdenFabricacion o"),
    @NamedQuery(name = "OrdenFabricacion.findByIdOrdenFabricacion", query = "SELECT o FROM OrdenFabricacion o WHERE o.idOrdenFabricacion = :idOrdenFabricacion"),
    @NamedQuery(name = "OrdenFabricacion.findByRefPedido", query = "SELECT o FROM OrdenFabricacion o WHERE o.refPedido = :refPedido"),
    @NamedQuery(name = "OrdenFabricacion.findByFechaExpedicion", query = "SELECT o FROM OrdenFabricacion o WHERE o.fechaExpedicion = :fechaExpedicion"),
    @NamedQuery(name = "OrdenFabricacion.findByFechaEntrega", query = "SELECT o FROM OrdenFabricacion o WHERE o.fechaEntrega = :fechaEntrega"),
    @NamedQuery(name = "OrdenFabricacion.findByEspecificaciones", query = "SELECT o FROM OrdenFabricacion o WHERE o.especificaciones = :especificaciones"),
    @NamedQuery(name = "OrdenFabricacion.findByArticulo", query = "SELECT o FROM OrdenFabricacion o WHERE o.articulo = :articulo"),
    @NamedQuery(name = "OrdenFabricacion.findByFechaIniciado", query = "SELECT o FROM OrdenFabricacion o WHERE o.fechaIniciado = :fechaIniciado"),
    @NamedQuery(name = "OrdenFabricacion.findByFechaFinalizado", query = "SELECT o FROM OrdenFabricacion o WHERE o.fechaFinalizado = :fechaFinalizado"),
    @NamedQuery(name = "OrdenFabricacion.findByCantidad", query = "SELECT o FROM OrdenFabricacion o WHERE o.cantidad = :cantidad"),
    @NamedQuery(name = "OrdenFabricacion.findByFinalizada", query = "SELECT o FROM OrdenFabricacion o WHERE o.finalizada = :finalizada")})
public class OrdenFabricacion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SECUENCIA_ORDEN_FABRICACION")
    @Column(name = "ID_ORDEN_FABRICACION")
    private BigDecimal idOrdenFabricacion;
    @Column(name = "REF_PEDIDO")
    private String refPedido;
    @Basic(optional = false)
    @Column(name = "FECHA_EXPEDICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaExpedicion;
    @Basic(optional = false)
    @Column(name = "FECHA_ENTREGA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrega;
    @Column(name = "ESPECIFICACIONES")
    private String especificaciones;
    @Column(name = "ARTICULO")
    private String articulo;
    @Column(name = "FECHA_INICIADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIniciado;
    @Column(name = "FECHA_FINALIZADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinalizado;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Column(name = "FINALIZADA")
    private String finalizada;
    @JoinColumn(name = "ID_DEPARTAMENTO", referencedColumnName = "ID_DEPARTAMENTO")
    @ManyToOne
    private Departamento departamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenFabricacion")
    private List<OrdenFabricacionDetalle> ordenFabricacionDetalleList;

    public OrdenFabricacion() {
    }

    public OrdenFabricacion(BigDecimal idOrdenFabricacion) {
        this.idOrdenFabricacion = idOrdenFabricacion;
    }

    public OrdenFabricacion(BigDecimal idOrdenFabricacion, Date fechaExpedicion, Date fechaEntrega, BigInteger cantidad) {
        this.idOrdenFabricacion = idOrdenFabricacion;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaEntrega = fechaEntrega;
        this.cantidad = cantidad;
    }

    public BigDecimal getIdOrdenFabricacion() {
        return idOrdenFabricacion;
    }

    public void setIdOrdenFabricacion(BigDecimal idOrdenFabricacion) {
        this.idOrdenFabricacion = idOrdenFabricacion;
    }

    public String getRefPedido() {
        return refPedido;
    }

    public void setRefPedido(String refPedido) {
        this.refPedido = refPedido;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public Date getFechaIniciado() {
        return fechaIniciado;
    }

    public void setFechaIniciado(Date fechaIniciado) {
        this.fechaIniciado = fechaIniciado;
    }

    public Date getFechaFinalizado() {
        return fechaFinalizado;
    }

    public void setFechaFinalizado(Date fechaFinalizado) {
        this.fechaFinalizado = fechaFinalizado;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public String getFinalizada() {
        return finalizada;
    }

    public void setFinalizada(String finalizada) {
        this.finalizada = finalizada;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<OrdenFabricacionDetalle> getOrdenFabricacionDetalleList() {
        return ordenFabricacionDetalleList;
    }

    public void setOrdenFabricacionDetalleList(List<OrdenFabricacionDetalle> ordenFabricacionDetalleList) {
        this.ordenFabricacionDetalleList = ordenFabricacionDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenFabricacion != null ? idOrdenFabricacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenFabricacion)) {
            return false;
        }
        OrdenFabricacion other = (OrdenFabricacion) object;
        if ((this.idOrdenFabricacion == null && other.idOrdenFabricacion != null) || (this.idOrdenFabricacion != null && !this.idOrdenFabricacion.equals(other.idOrdenFabricacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SIC.Entidades.OrdenFabricacion[ idOrdenFabricacion=" + idOrdenFabricacion + " ]";
    }
    
}
