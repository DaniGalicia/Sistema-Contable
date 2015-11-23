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
public class ServOrdenFabricacion extends BasicService{

    public ServOrdenFabricacion(String persistenceUnit) {
        super(persistenceUnit);
    }

    public List<Cargo> getListado() {
        Query q = getEntityManager().createNamedQuery("OrdenFabricacion.findAll");
        return q.getResultList();
    }
}
