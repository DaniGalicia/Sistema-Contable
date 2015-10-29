
package clases;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class MovimientosTableModel extends AbstractTableModel{
    
    public List<LineaTransaccion> lineas= new ArrayList<>();
    
    @Override
    public int getRowCount(){
        return lineas.size();
    }

    @Override
    public int getColumnCount() {
       return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LineaTransaccion linea = lineas.get(rowIndex);
        Object valor = null;
        switch(columnIndex){
            case 0: valor = linea.getCuenta().getNombre();
            break;
            case 1: valor = linea.getTransaccion().getTipo();
            break;
            case 2: valor = linea.getTransaccion().getCantidad();
        }
        return valor;
    }
    
}
