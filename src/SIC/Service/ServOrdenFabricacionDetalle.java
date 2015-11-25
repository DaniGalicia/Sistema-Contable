package SIC.Service;

import SIC.Entidades.OrdenFabricacionDetalle;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author GALICIA
 */
public class ServOrdenFabricacionDetalle extends BasicService{

    public List<OrdenFabricacionDetalle> getListadoByIDOFDetalle(BigDecimal id){
       Query q= getEntityManager().createNativeQuery("");
        q.setParameter("idOrdenFrabricacion", id);
        JOptionPane.showMessageDialog(null, q.getResultList().size());
       // return q.getResultList();
        return null;
    }
    
}
