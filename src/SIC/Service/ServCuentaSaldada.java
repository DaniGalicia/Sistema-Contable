package SIC.Service;

import SIC.Entidades.CuentaSaldada;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author GALICIA
 */
public class ServCuentaSaldada extends BasicService{

        
    public CuentaSaldada findByIdCuentaSaldada(String idCuentaSaldada) {
        Query q = getEntityManager().createNamedQuery("CuentaSaldada.findByIdCuentaSaldada");
        q.setParameter("idCuentaSaldada", idCuentaSaldada);

        return (CuentaSaldada) q.getSingleResult();

    }

    public List<CuentaSaldada> findByTiposCuenta(String tipoCuentaList){
        List<CuentaSaldada> retorno=new ArrayList<>();
        
        for(String tipoCuenta:tipoCuentaList.split(","))
            retorno.addAll(findByTipoCuenta(tipoCuenta));
        
        return retorno;
    }
    
    public List<CuentaSaldada> findByTipoCuenta(String tipoCuenta){

        List<CuentaSaldada> aux= getListado(CuentaSaldada.class);
        
        aux.removeIf(p -> !p.getCuenta().getTipoCuenta().getIdTipoCuenta().equals(tipoCuenta));
 
        return aux;
    }
}
