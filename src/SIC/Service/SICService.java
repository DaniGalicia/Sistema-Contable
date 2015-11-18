/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author GALICIA
 */
public class SICService {
  private static final String PERSISTENCE_UNIT_NAME = "SistemaContablePU";
  private EntityManager entityManager;
  private static EntityManagerFactory factory;
    private static ServCuenta servCuenta;
    private static ServMovimiento servMovimiento;
    private static ServUsuario servUsuario;
    private static ServCuentaSaldada servCuentaSaldada;

    public SICService() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        entityManager = factory.createEntityManager();
    }

    public static ServUsuario getServUsuario() {
        if(servUsuario==null)
            servUsuario=new ServUsuario(PERSISTENCE_UNIT_NAME);
        
        return servUsuario;
    }
    
    public static ServCuenta getServCuenta() {
        if (servCuenta == null) {
            SICService.servCuenta = new ServCuenta(PERSISTENCE_UNIT_NAME);
        }
        return servCuenta;
    }

    public static ServMovimiento getServMovimiento() {
        if (servMovimiento == null) {
            SICService.servMovimiento = new ServMovimiento(PERSISTENCE_UNIT_NAME);
        }
        return servMovimiento;
    }

    public static ServCuentaSaldada getServCuentaSaldada() {
        if(servCuentaSaldada==null)
            servCuentaSaldada=new ServCuentaSaldada(PERSISTENCE_UNIT_NAME);
        
        return servCuentaSaldada;
    }
    
}
