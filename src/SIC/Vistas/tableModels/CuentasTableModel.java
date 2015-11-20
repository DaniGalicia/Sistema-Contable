package SIC.Vistas.tableModels;

import SIC.Entidades.Cuenta;
import SIC.Entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CuentasTableModel extends AbstractTableModel {
   public List<Cuenta> cuentas= new ArrayList<>();
    
    @Override
    public int getRowCount(){
        return cuentas.size();
    }
    

    @Override
    public int getColumnCount() {
       return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cuenta cuenta = cuentas.get(rowIndex);
        Object valor = null;
        switch(columnIndex){
            case 0: valor = cuenta.getIdCuenta();
            break;
            case 1: valor = cuenta.getNombre();
            break;
            case 2: valor = cuenta.getTipo();
        }
        return valor;
    }
    
}
