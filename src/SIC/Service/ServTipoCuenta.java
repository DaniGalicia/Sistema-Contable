package SIC.Service;

import SIC.Entidades.TipoCuenta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author GALICIA
 */
public class ServTipoCuenta {

    private static EntityManagerFactory factory;
    private EntityManager entityManager;
    private String persistenceUnit;

    public ServTipoCuenta(String persistenceUnit) {
        this.persistenceUnit = persistenceUnit;
        factory = Persistence.createEntityManagerFactory(persistenceUnit);
        entityManager = factory.createEntityManager();
        this.persistenceUnit = persistenceUnit;
    }

    public boolean eliminar(TipoCuenta tipoCuenta)
    {
        entityManager.getTransaction().begin();
        entityManager.remove(tipoCuenta);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }
    
    public boolean guardar(TipoCuenta tipoCuenta) {

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(tipoCuenta);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }


    public List<TipoCuenta> getListado() {
        Query q = entityManager.createNamedQuery("TipoCuenta.findAll");
        return q.getResultList();
    }
}
