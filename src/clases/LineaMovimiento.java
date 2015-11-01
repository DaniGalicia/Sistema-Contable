
package clases;

public class LineaMovimiento {
    private Cuenta cuenta;
    private Movimiento movimiento;

    public LineaMovimiento(Cuenta cuenta, Movimiento transaccion) {
        this.cuenta = cuenta;
        this.movimiento = transaccion;
    }


    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento transaccion) {
        this.movimiento = transaccion;
    }
    
    
    
}
