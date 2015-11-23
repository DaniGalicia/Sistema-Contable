package SIC.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author GALICIA
 */
public class BasicService {

    private static EntityManagerFactory factory;
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public BasicService(String persistenceUnit) {
        factory = Persistence.createEntityManagerFactory(persistenceUnit);
        entityManager = factory.createEntityManager();
    }

    public boolean eliminar(Object entidad) {

        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entidad);
            entityManager.getTransaction().commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean guardar(Object entidad) {

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entidad);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public Object getByPK(Class clase, Object PK) {
        
        try {
            
            
            return entityManager.find(clase, PK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }
    
    
}
