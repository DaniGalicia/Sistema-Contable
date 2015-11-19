package SIC.Service;

import SIC.Entidades.Cargo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author GALICIA
 */
public class ServCargo {

    private static EntityManagerFactory factory;
    private EntityManager entityManager;
    private String persistenceUnit;

    public ServCargo(String persistenceUnit) {
        this.persistenceUnit = persistenceUnit;
        factory = Persistence.createEntityManagerFactory(persistenceUnit);
        entityManager = factory.createEntityManager();
        this.persistenceUnit = persistenceUnit;
    }

    public boolean eliminar(Cargo cargo)
    {
        entityManager.getTransaction().begin();
        entityManager.remove(cargo);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }
    
    public boolean guardar(Cargo cargo) {

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cargo);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public Cargo getCargoByCodigo(String codigoCargo) {
        Query q = entityManager.createNamedQuery("Cargo.findByCodigoCargo");
               
        q.setParameter("codigoCargo", codigoCargo);

        return (Cargo) q.getSingleResult();

    }

    public List<Cargo> getListado() {
        Query q = entityManager.createNamedQuery("Cargo.findAll");
        return q.getResultList();
    }
}
