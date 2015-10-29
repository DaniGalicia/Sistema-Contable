/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author GALICIA
 */
public class SICService {

    private static Connection connection;
    private static ServCuenta servCuenta;
    private static ServMovimiento servMovimiento;

    public static ServCuenta getServCuenta() {
        if (servCuenta == null) {
            SICService.servCuenta = new ServCuenta();
        }
        return servCuenta;
    }

    
    public static ServMovimiento getServMovimiento() {
        if (servMovimiento == null) {
            SICService.servMovimiento = new ServMovimiento();
        }
        return servMovimiento;
    }
    
    public  static Connection getConnection() {
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

           connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SIC", "admin");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Conexion a base de datos","No se pueden obtener datos/n Por favor contacte al administrador",ERROR_MESSAGE);
            e.printStackTrace();
        }

        return connection;
    }

}
