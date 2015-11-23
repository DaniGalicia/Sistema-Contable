package SIC.Service;

import SIC.Entidades.Cargo;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author GALICIA
 */
public class ServOrdenFabricacionDetalle extends BasicService{

    public ServOrdenFabricacionDetalle(String persistenceUnit) {
        super(persistenceUnit);
    }

    public List<Cargo> getListado() {
        Query q = getEntityManager().createNamedQuery("OrdenFabricacionDetalle.findAll");
        return q.getResultList();
    }
}
