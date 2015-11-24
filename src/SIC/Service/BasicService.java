package SIC.Service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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

    public BasicService() {
        factory = Persistence.createEntityManagerFactory("SistemaContablePU");
        entityManager = factory.createEntityManager();
    }

    public boolean eliminar(Object entidad) {
        boolean ret = false;
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entidad);
            entityManager.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
        return ret;
    }

    public boolean guardar(Object entidad) {
        boolean guardado = false;
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entidad);
            entityManager.getTransaction().commit();
            guardado = true;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }

        return guardado;
    }

    public Object getByPK(Class clase, Object PK) {
        return entityManager.find(clase, PK);
    }

    public List getListado(Class clase) {
        Query q = getEntityManager().createNamedQuery(clase.getSimpleName() + ".findAll");
        return q.getResultList();
    }
    
    public boolean guardar(List entidades){
        boolean guardado=false;
        
        try {
            entityManager.getTransaction().begin();
            for(Object object:entidades)
            {
                entityManager.persist(object);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
           if(entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
        }
        return guardado;
    }
}
