
package clases;

public class LineaTransaccion {
    private Cuenta cuenta;
    private Transaccion transaccion;

    public LineaTransaccion(Cuenta cuenta, Transaccion transaccion) {
        this.cuenta = cuenta;
        this.transaccion = transaccion;
    }


    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }
    
    
    
}
