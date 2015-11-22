package SIC.Service;

import SIC.Entidades.TipoEstadoFinanciero;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author GALICIA
 */
public class ServTipoEstadoFinanciero extends BasicService{

    public ServTipoEstadoFinanciero(String persistenceUnit) {
        super(persistenceUnit);
    }


    public List<TipoEstadoFinanciero> getListado() {
        Query q = getEntityManager().createNamedQuery("EstadoFinanciero.findAll");
        return q.getResultList();
    }
}
