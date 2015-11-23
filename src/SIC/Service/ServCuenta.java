package SIC.Service;

import SIC.Entidades.Cuenta;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author GALICIA
 */
public class ServCuenta extends BasicService{

    public ServCuenta(String persistenceUnit) {
        super(persistenceUnit);
    }
   
    public List<Cuenta> getListado() {
        Query q = getEntityManager().createNamedQuery("Cuenta.findAll");
        return q.getResultList();
    }
}
