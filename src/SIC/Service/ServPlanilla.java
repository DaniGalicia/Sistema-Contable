/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Service;

import SIC.Entidades.Periodo;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author IVON-GARCIA
 */
public class ServPlanilla extends BasicService{
    public List getPlanillaByPeriodo(Periodo periodo){
    Query q=getEntityManager().createNamedQuery("Planilla.findByPeriodo");
    q.setParameter("periodo", periodo);
    
    try {
        return q.getResultList();
    } catch (Exception e) {
    }
    return null;
}
}
