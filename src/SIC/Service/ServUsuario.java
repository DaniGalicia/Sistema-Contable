package SIC.Service;

import SIC.Entidades.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author GALICIA
 */
public class ServUsuario {

    private static EntityManagerFactory factory;
    private EntityManager entityManager;
    private String persistenceUnit;

    public ServUsuario(String persistenceUnit) {
        this.persistenceUnit = persistenceUnit;
        factory = Persistence.createEntityManagerFactory(persistenceUnit);
        entityManager = factory.createEntityManager();
        this.persistenceUnit = persistenceUnit;
    }

    public boolean eliminar(Usuario usuario)
    {
        entityManager.getTransaction().begin();
        entityManager.remove(usuario);
        entityManager.getTransaction().commit();
        return true;
    }
    
    public boolean guardar(Usuario usuario) {

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }

        return true;
    }
    
    public Usuario getUsuarioByCodigoEmpleado(String codigoEmpleado) {
        
        
        Query q = entityManager.createNamedQuery("Usuario.findByCodigoEmpleado");
               
        q.setParameter("codigoEmpleado", codigoEmpleado);
        
        try {
            return (Usuario) q.getSingleResult();
        } catch (Exception e) {
        }
        
        return null;
    }

    public List<Usuario> getListado() {
        Query q = entityManager.createNamedQuery("Usuario.findAll");
        return q.getResultList();
    }
}
