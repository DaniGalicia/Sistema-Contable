
package clases;

import java.util.ArrayList;
import java.util.List;


public class Cuenta {
    String idCuenta;
    String nombre;
    String tipo;
    List<Movimiento> transacciones=new ArrayList<>();

    public Cuenta() {
    }

    public Cuenta(String nombre, String tipo, Movimiento transaccion) {
        this.nombre=nombre;
        this.tipo=tipo;
        agregarTransaccion(transaccion);
    }
    /*public double saldar(){
        double res=0;
        for (Transaccion transaccion : transacciones) {
            if(transaccion.getTipo()=="Debe")
                res+=transaccion.getCantidad();
            else
                res-=transaccion.getCantidad();
        }
        return res;
    }*/

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }
    
    public void agregarTransaccion(Movimiento transaccion)
    {
        transacciones.add(transaccion);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Movimiento> getTransacciones() {
        return transacciones;
    } 
   
    public String toString(){
           return nombre+"("+tipo+")";
    }
    
}
