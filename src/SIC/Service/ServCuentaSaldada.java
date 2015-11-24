package SIC.Service;

import SIC.Entidades.CuentaSaldada;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author GALICIA
 */
public class ServCuentaSaldada extends BasicService{

    public ServCuentaSaldada(String persistenceUnit) {
        super();
    }
    
    public CuentaSaldada findByIdCuentaSaldada(String idCuentaSaldada) {
        Query q = getEntityManager().createNamedQuery("CuentaSaldada.findByIdCuentaSaldada");
        q.setParameter("idCuentaSaldada", idCuentaSaldada);

        return (CuentaSaldada) q.getSingleResult();

    }

    public List<CuentaSaldada> getListado() {
        Query q = getEntityManager().createNamedQuery("CuentaSaldada.findAll");
        return q.getResultList();
    }
    
    public List<CuentaSaldada> findByTipoCuenta(String tipoCuenta){

        List<CuentaSaldada> aux= getListado();
        
   //     aux.removeIf(p -> !p.getCuenta().getTipoCuenta().getIdTipoCuenta().equals(tipoCuenta));
 
        return aux;
    }
}
