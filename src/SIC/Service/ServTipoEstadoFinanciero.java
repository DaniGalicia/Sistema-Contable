package SIC.Service;

import SIC.Entidades.TipoEstadoFinanciero;
import javax.persistence.Query;

/**
 *
 * @author GALICIA
 */
public class ServTipoEstadoFinanciero extends BasicService{
    
    public TipoEstadoFinanciero findByIdTipoEstadoFinanciero(String idTipoEstadoFinanciero){
        
       Query q=getEntityManager().createNamedQuery("TipoEstadoFinanciero.findByIdTipoEstadoFinanciero");
       q.setParameter("idTipoEstadoFinanciero", idTipoEstadoFinanciero);
        try {
            return (TipoEstadoFinanciero) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
    return null;
    }
    
         
}
