package SIC.Service;

import SIC.Entidades.Cuenta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author GALICIA
 */
public class ServCuenta {

    private static EntityManagerFactory factory;
    private EntityManager entityManager;
    private String persistenceUnit;

    public ServCuenta(String persistenceUnit) {
        this.persistenceUnit = persistenceUnit;
        factory = Persistence.createEntityManagerFactory(persistenceUnit);
        entityManager = factory.createEntityManager();
        this.persistenceUnit = persistenceUnit;
    }

    public boolean eliminar(Cuenta cuenta)
    {
        entityManager.getTransaction().begin();
        entityManager.remove(cuenta);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }
    
    public boolean guardar(Cuenta cuenta) {

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cuenta);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public Cuenta getCuentaById(String idCuenta) {
        Query q = entityManager.createQuery("SELECT c FROM Cuenta c where c.idCuenta=:idCuenta");
        q.setParameter("idCuenta", idCuenta);

        return (Cuenta) q.getSingleResult();

    }

    public List<Cuenta> getListado() {
        Query q = entityManager.createNamedQuery("Cuenta.findAll");
        return q.getResultList();
    }
}
