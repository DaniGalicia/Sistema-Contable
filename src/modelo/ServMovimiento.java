/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Movimiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author galicia
 */
public class ServMovimiento {

    private static Connection connection;

    public ServMovimiento() {
        this.connection = SICService.getConnection();
    }

    public List<Movimiento> getListadoByIdCuenta(String idCuenta) {
        List<Movimiento> transacciones=new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from MOVIMIENTOS where cuenta= ? ");
            preparedStatement.setString(1, idCuenta);
            ResultSet resultSet=preparedStatement.executeQuery();
            
            while(resultSet.next()){
                String tipo=resultSet.getString("tipo");
                double cantidad=resultSet.getDouble("cantidad");
                
                Movimiento transaccion= new Movimiento(tipo, cantidad);
                transacciones.add(transaccion);
            }
            
            
            
        } catch (Exception e) {
            
        }
    return  transacciones;
    }
    
}
