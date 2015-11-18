package SIC.Service;

import SIC.Entidades.CuentasSaldadas;
import java.util.ArrayList;
import java.util.List;
import static java.util.Locale.filter;
import java.util.logging.Filter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author GALICIA
 */
public class ServCuentaSaldada {

    private static EntityManagerFactory factory;
    private EntityManager entityManager;
    private String persistenceUnit;

    public ServCuentaSaldada(String persistenceUnit) {
        this.persistenceUnit = persistenceUnit;
        factory = Persistence.createEntityManagerFactory(persistenceUnit);
        entityManager = factory.createEntityManager();
        this.persistenceUnit = persistenceUnit;
    }

    public boolean eliminar(CuentasSaldadas cuenta) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(cuenta);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean guardar(CuentasSaldadas cuentaSaldada) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cuentaSaldada);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public CuentasSaldadas findByIdCuentaSaldada(String idCuentaSaldada) {
        Query q = entityManager.createNamedQuery("CuentasSaldadas.findByIdCuentaSaldada");
        q.setParameter("idCuentaSaldada", idCuentaSaldada);

        return (CuentasSaldadas) q.getSingleResult();

    }

    public List<CuentasSaldadas> getListado() {
        Query q = entityManager.createNamedQuery("CuentasSaldadas.findAll");
        return q.getResultList();
    }
    
    public List<CuentasSaldadas> findByTipoCuenta(String tipoCuenta){

        List<CuentasSaldadas> aux=getListado();
        
        aux.removeIf(p -> !p.getCuenta().getTipo().equals(tipoCuenta));
 
        return aux;
    }
}
