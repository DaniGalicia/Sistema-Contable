
package SIC.Vistas;

import SIC.Entidades.Movimiento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class MovimientosTableModel extends AbstractTableModel{
    
    public List<Movimiento> movimientos= new ArrayList<>();
    
    @Override
    public int getRowCount(){
        return movimientos.size();
    }

    @Override
    public int getColumnCount() {
       return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Movimiento movimiento = movimientos.get(rowIndex);
        Object valor = null;
        switch(columnIndex){
            case 0: valor = movimiento.getCuenta().getNombre();
            break;
            case 1: valor = movimiento.getTipo();
            break;
            case 2: valor = movimiento.getCantidad();
        }
        return valor;
    }
    
}
