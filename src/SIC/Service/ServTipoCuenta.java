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
public class ServTipoCuenta extends BasicService{

 
    public ServTipoCuenta(String persistenceUnit) {
        super(persistenceUnit);
    }

    public List<TipoCuenta> getListado() {
        Query q = getEntityManager().createNamedQuery("TipoCuenta.findAll");
        return q.getResultList();
    }

}
