package SIC.Service;

import SIC.Entidades.EstadoFinanciero;
import SIC.Entidades.TipoEstadoFinanciero;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author GALICIA
 */
public class ServEstadoFinanciero extends BasicService{
    
    public EstadoFinanciero getEstadoFinacieroPeriodoActivo(String idTipoEstadoFinanciero){
        
        
        Query q=getEntityManager().createNamedQuery("EstadoFinanciero.findByIdPeriodo");
        q.setParameter("idPeriodo", SICService.getServPeriodo().getActivo().getIdPeriodo());
        try {
            for(EstadoFinanciero estadoFinanciero:(List<EstadoFinanciero>)q.getResultList())
            {
                if(estadoFinanciero.getTipoEstadoFinanciero().equals(SICService.getServTipoEstadoFinanciero().findByIdTipoEstadoFinanciero(idTipoEstadoFinanciero)))
                    return estadoFinanciero;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
