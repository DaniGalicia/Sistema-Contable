/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Vistas.tableModels;

import SIC.Entidades.OrdenFabricacion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Escobar
 */
public class EncabezadoOrdenTableModel extends AbstractTableModel{
    
    public List<OrdenFabricacion> ordenes= new ArrayList<>();
    
    @Override
    public int getRowCount(){
        return ordenes.size();
    }
    

    @Override
    public int getColumnCount() {
       return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        OrdenFabricacion orden = ordenes.get(rowIndex);
        Object valor = null;
        switch(columnIndex){
           case 0: valor = orden.getIdOrdenFabricacion();
            break;
            case 1: valor = orden.getFechaExpedicion();
            break;
            case 2: valor = orden.getFechaEntrega();
        }
        return valor;
    }
    
}

   
