/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Entidades;

import SIC.Service.BasicService;
import SIC.Service.SICService;
import java.math.BigDecimal;
/**
 *
 * @author dannier
 */
public class PruebaServicio {

    public static void main(String[] args) {
        

        
        Cargo c=(Cargo) SICService.getServCargo().getByPK(Cargo.class,BigDecimal.valueOf(11));
        if(c!=null){
            System.out.println(c.getNombreCargo());
        }else{
            System.out.println("No find");
        }
    }
}
