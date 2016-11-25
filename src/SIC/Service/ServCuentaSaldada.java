package SIC.Service;

import SIC.Entidades.CuentaSaldada;
import SIC.Entidades.Periodo;
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
       //Solo funciona en java 8
        // aux.removeIf(p -> !p.getCuenta().getTipoCuenta().getIdTipoCuenta().equals(tipoCuenta));
        
        return aux;
    }
    
    
    public List<CuentaSaldada> getSaldosAnteriores(){
        
        List<Periodo> periodos=SICService.getServPeriodo().getFinalizados();
        if(periodos.isEmpty())
            return new ArrayList<>();
        
        Periodo periodo=periodos.get(0);
        
        for(Periodo p:periodos)
            if(p.getIdPeriodo().compareTo(periodo.getIdPeriodo())==1)
                periodo=p;
        List<CuentaSaldada> retorno= new ArrayList<>();

        for(CuentaSaldada cs:(List<CuentaSaldada>)getListado(CuentaSaldada.class))
        {
            if(cs.getPeriodo().equals(periodo))
                retorno.add(cs);
        }
        
        

        return retorno;
    }
}
