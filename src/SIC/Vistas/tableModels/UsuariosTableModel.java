package SIC.Vistas.tableModels;

import SIC.Entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UsuariosTableModel extends AbstractTableModel {
   public List<Usuario> usuarios= new ArrayList<>();
    
    @Override
    public int getRowCount(){
        return usuarios.size();
    }
    

    @Override
    public int getColumnCount() {
       return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario = usuarios.get(rowIndex);
        Object valor = null;
        switch(columnIndex){
            case 0: valor = usuario.getCodigoEmpleado();
            break;
            case 1: valor = usuario.getUsuario();
            break;
            case 2: valor = usuario.getClave();
        }
        return valor;
    }
    
}
