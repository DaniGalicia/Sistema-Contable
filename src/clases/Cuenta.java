
package clases;

import java.util.ArrayList;
import java.util.List;


public class Cuenta {
    String idCuenta;
    String nombre;
    char tipo;
    List<Transaccion> transacciones=new ArrayList<>();

    public Cuenta(String nombre, char tipo, Transaccion transaccion) {
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
    
    public void agregarTransaccion(Transaccion transaccion)
    {
        transacciones.add(transaccion);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    } 
   
    public String toString(){
           return nombre+"("+tipo+")";
    }
    
}
