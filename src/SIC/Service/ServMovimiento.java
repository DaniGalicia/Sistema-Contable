/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Service;


import SIC.Entidades.Movimiento;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author galicia
 */
public class ServMovimiento extends BasicService{

    
    public List<Movimiento> getListado() {
        Query q = getEntityManager().createNamedQuery("Movimiento.findAll");
        return q.getResultList();
    }   
}
