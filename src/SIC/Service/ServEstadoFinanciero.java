package SIC.Service;

import SIC.Entidades.EstadoFinanciero;
import javax.persistence.Query;

/**
 *
 * @author GALICIA
 */
public class ServEstadoFinanciero extends BasicService{
    
    public EstadoFinanciero getEstadoFinacieroPeriodoActivo(){
        Query q=getEntityManager().createNamedQuery("EstadoFinanciero.findByIdPeriodo");
        q.setParameter("idPeriodo", SICService.getServPeriodo().getActivo().getIdPeriodo());
        try {
            return (EstadoFinanciero) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
