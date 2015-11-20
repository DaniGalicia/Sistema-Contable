package SIC.Service;

import SIC.Entidades.Empleado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author GALICIA
 */
public class ServEmpleado {

    private static EntityManagerFactory factory;
    private EntityManager entityManager;
    private String persistenceUnit;

    public ServEmpleado(String persistenceUnit) {
        this.persistenceUnit = persistenceUnit;
        factory = Persistence.createEntityManagerFactory(persistenceUnit);
        entityManager = factory.createEntityManager();
        this.persistenceUnit = persistenceUnit;
    }

    public boolean eliminar(Empleado empleado) {
        entityManager.getTransaction().begin();
        entityManager.remove(empleado);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    public boolean guardar(Empleado empleado) {

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(empleado);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public Empleado getEmpleadoByCodigo(String codigoEmpleado) {
        Query q = entityManager.createNamedQuery("Empleado.findByCodigoEmpleado");
        q.setParameter("codigoEmpleado", codigoEmpleado);
        try {
            return (Empleado) q.getSingleResult();
        } catch (Exception e) {
        }

        return null;
    }

    public List<Empleado> getListado() {
        Query q = entityManager.createNamedQuery("Empleado.findAll");
        return q.getResultList();
    }
}
