package SIC.Service;

import SIC.Entidades.TipoCuenta;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author GALICIA
 */
public class ServTipoCuenta extends BasicService{

 
    public ServTipoCuenta(String persistenceUnit) {
        super();
    }

    public List<TipoCuenta> getListado() {
        Query q = getEntityManager().createNamedQuery("TipoCuenta.findAll");
        return q.getResultList();
    }

}
