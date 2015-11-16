/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Service;


import SIC.Entidades.Movimiento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author galicia
 */
public class ServMovimiento {


    private static EntityManagerFactory factory;
    private EntityManager entityManager;
    private String persistenceUnit;

    public ServMovimiento(String persistenceUnit) {
        this.persistenceUnit = persistenceUnit;
        factory = Persistence.createEntityManagerFactory(persistenceUnit);
        entityManager = factory.createEntityManager();
        this.persistenceUnit = persistenceUnit;
    }
    
    

    public boolean eliminar(Movimiento movimiento)
    {
        entityManager.getTransaction().begin();
        entityManager.remove(movimiento);
        entityManager.getTransaction().commit();
        
        return true;
    }
    
    public boolean guardar(Movimiento movimiento) {

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(movimiento);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }

        return true;
    }

    public Movimiento getMovimientoById(String idMovimiento) {
        Query q = entityManager.createQuery("SELECT c FROM Movimiento c where c.idMovimiento=:idMovimiento");
        q.setParameter("idMovimiento", idMovimiento);
        
        return entityManager.find(Movimiento.class, idMovimiento);
        //return (Movimiento) q.getSingleResult();

    }

    public List<Movimiento> getListado() {
        Query q = entityManager.createNamedQuery("Movimiento.findAll");
        return q.getResultList();
    }   
}
