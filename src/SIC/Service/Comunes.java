/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Service;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author dannier
 */
public class Comunes {

    public static TableColumnModel crearModeloColumnas(String columnas) {
        TableColumnModel tColumnModel = new DefaultTableColumnModel();

        String cadenas[] = columnas.split(",");
        for (int i = 0; i < cadenas.length; i++) {
            TableColumn col = new TableColumn(i);
            col.setHeaderValue(cadenas[i]);
            tColumnModel.addColumn(col);
        }

        return tColumnModel;
    }

    public static DefaultComboBoxModel crearModeloComboBox(List lista) {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        for (Object objeto : lista) {

            combo.addElement(objeto);
        }
        return combo;
    }
    
    public static void actualizarTabla(DefaultTableModel modelo){
        while (modelo.getRowCount()>0)
            modelo.removeRow(0);
        
 
    }
}
