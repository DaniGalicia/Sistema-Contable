/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Entidades;

import SIC.Service.BasicService;
import SIC.Service.SICService;
import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author dannier
 */
public class PruebaServicio {

    public static void main(String[] args) {
        
        BasicService bs=new BasicService("SistemaContablePU");
        for(Cuenta cuenta:(List<Cuenta>)bs.getListado(Cuenta.class))
        {
            System.out.println(cuenta.getNombre());
        }
    }
}
