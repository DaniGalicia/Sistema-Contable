package SIC.Service;

import SIC.Entidades.Periodo;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author GALICIA
 */
public class ServPeriodo extends BasicService{

    
public Periodo getActivo(){
    Query q=getEntityManager().createNamedQuery("Periodo.findByActivo");
    q.setParameter("activo", "1");
    
    try {
        return (Periodo) q.getSingleResult();
    } catch (Exception e) {
    }
    return null;
}

public List<Periodo> getFinalizados(){
        Query q=getEntityManager().createNamedQuery("Periodo.findByActivo");
    q.setParameter("activo", "0");
    
    try {
        return q.getResultList();
    } catch (Exception e) {
    }
    return null;
}
}
