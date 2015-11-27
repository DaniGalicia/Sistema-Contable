package SIC.Service;

import SIC.Entidades.Periodo;
import javax.persistence.Query;

/**
 *
 * @author GALICIA
 */
public class ServPeriodo extends BasicService{

    
public Periodo getActivo(){
    Query q=getEntityManager().createNamedQuery("Periodo.findByActivo");
    q.setParameter("activo", "1");
    
    return (Periodo) q.getSingleResult();
}
}
