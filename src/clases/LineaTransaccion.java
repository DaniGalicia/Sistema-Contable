
package clases;

public class LineaTransaccion {
    private Cuenta cuenta;
    private Movimiento transaccion;

    public LineaTransaccion(Cuenta cuenta, Movimiento transaccion) {
        this.cuenta = cuenta;
        this.transaccion = transaccion;
    }


    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Movimiento getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Movimiento transaccion) {
        this.transaccion = transaccion;
    }
    
    
    
}
