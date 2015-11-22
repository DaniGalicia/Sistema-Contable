package SIC.Vistas.tableModels;

import SIC.Entidades.CuentaSaldada;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CuentasEFModel extends AbstractTableModel {
   public List<CuentaSaldada> cuentasSaldadas= new ArrayList<>();
    
    @Override
    public int getRowCount(){
        return cuentasSaldadas.size();
    }
    

    @Override
    public int getColumnCount() {
       return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CuentaSaldada cuentaSaldada = cuentasSaldadas.get(rowIndex);
        Object valor = null;
        switch(columnIndex){
            case 0: valor = cuentaSaldada.getCuenta().getNombre();
            break;
            case 1:
                if(cuentaSaldada.getSaldo()>0)
                valor = cuentaSaldada.getSaldo();
            break;
            case 2:
                if(cuentaSaldada.getSaldo()< 0)
                valor = -cuentaSaldada.getSaldo();
        }
        return valor;
    }
    
}
