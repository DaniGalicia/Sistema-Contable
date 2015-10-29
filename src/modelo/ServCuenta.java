/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Cuenta;
import clases.Movimiento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GALICIA
 */
public class ServCuenta {

    private static Connection connection;

    public ServCuenta() {
        this.connection = SICService.getConnection();
    }

    public Cuenta getCuentaById(Integer id) {
        return null;
    }

    public List<Cuenta> getListado() {
        List<Cuenta> cuentas = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resulset = statement.executeQuery("Select * from cuentas");
            while (resulset.next()) {
                String idCuenta=resulset.getString("id");
                String nombre = resulset.getString("nombre");
                String tipo = resulset.getString("tipo");
                Cuenta cuenta=new Cuenta();
                cuenta.setNombre(nombre);
                cuenta.setTipo(tipo);
                cuenta.setIdCuenta(idCuenta);
                
                for(Movimiento movimiento:SICService.getServMovimiento().getListadoByIdCuenta(cuenta.getIdCuenta()))
                    cuenta.getTransacciones().add(movimiento);
                
                //Cuenta cuenta = new Cuenta(null, tipo, null)
                cuentas.add(cuenta);
            }

        } catch (Exception e) {
        }
        
        return cuentas;
    }
}
