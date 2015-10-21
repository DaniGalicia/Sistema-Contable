
package clases;

public class Transaccion {
     String tipo;
     Double cantidad;
    
     
    public Transaccion(String tipo, double cantidad) {
        this.tipo = tipo;
        this.cantidad = cantidad;
    }
   
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCantidad() {
        return cantidad;
    }
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
}
