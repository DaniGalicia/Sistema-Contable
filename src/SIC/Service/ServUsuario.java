/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Service;

import SIC.Entidades.Cargo;
import SIC.Entidades.Usuario;
import javax.persistence.EntityManager;
import org.eclipse.persistence.internal.jpa.EntityManagerImpl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author dannier
 */
public class ServUsuario {
    private static EntityManagerFactory factory;
    private EntityManager entityManager;
    private String persistenceUnit;

    public ServUsuario(String persistenceUnit) {
        factory=Persistence.createEntityManagerFactory(persistenceUnit);
        entityManager=factory.createEntityManager();
        this.persistenceUnit = persistenceUnit;
    }
    
        public boolean guardar(Usuario usuario) {

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }
    
    
    public Usuario getUsuario(String carnet, String clave) {       
        Query q = entityManager.createQuery("select t from Usuario t  where  t.carnet=:carnet and t.clave=:clave");
    
        q.setParameter("carnet", carnet);
        q.setParameter("clave", clave);
        
        try {
             return (Usuario) q.getSingleResult();
        } catch (Exception e) {
        }
       
        
        
        return null;
    }

    
}
